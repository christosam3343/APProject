//package server;
//
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import javax.swing.JOptionPane;
//
////import src.constants.JDBCPersistence;
////import src.database.SaveEntityToDB;
////import src.models.Address;
////import src.models.Staff;
//
//public class Server1 {
//
//    private ServerSocket serverSocket;
//    private Socket connectedSocket;
//
//
//    public Server() {
//
//        try { 
//            
//            serverSocket = new ServerSocket(8040);
//
//            System.out.println("Server started");
//
//            while (!serverSocket.isClosed()) {
//                
//                connectedSocket = serverSocket.accept();
//                System.out.println("Client connected");
//
//                ClientHandler client = new ClientHandler(connectedSocket);
//                Thread thread = new Thread(client);
//                thread.start();
//
//            }
//        } catch (IOException e) {
//            System.out.println("Server exception: " + e.getMessage());
//        }
//    }
//
//    class ClientHandler implements Runnable {
//
//        private Socket socket;
//        private String request;
//        private boolean response;
//        private ObjectInputStream dataInput;
//        private ObjectOutputStream dataOutput;
//
//        public ClientHandler(Socket socket) {
//            this.socket = socket;
//        }
//
//        @Override
//        public void run() {
//            try {
//                initializeDataStream();
//                while ((request = (String) dataInput.readObject()) != null) {
//
//                    System.out.println("Request received: " + request);
//                    if (request.equalsIgnoreCase("Staff Login")) {
//                        validateLogin();
//                    }
//
//                    if (request.equalsIgnoreCase("Add Staff")) {
//                        addStaff();
//                    }
//                    if (request.equalsIgnoreCase("Does Staff Exist")) {
//                        doesStaffExists();
//                    }
//                    if (request.equalsIgnoreCase("Reset Password")) {
//                        resetStaffPassword();
//                    }
//                }
//            } catch (IOException | ClassNotFoundException e) {
//                System.out.println("Client handler exception: " + e.getMessage());
//            } finally {
//                closeResources();
//            }
//        }
//
//        private void initializeDataStream() throws IOException {
//            dataOutput = new ObjectOutputStream(socket.getOutputStream());
//            dataInput = new ObjectInputStream(socket.getInputStream());
//            System.out.println("Data streams initialized");
//        }
//
//        private void closeResources() {
//            try {
//                if (dataInput != null)
//                    dataInput.close();
//                if (dataOutput != null)
//                    dataOutput.close();
//                if (socket != null)
//                    socket.close();
//                System.out.println("Closed client connection");
//            } catch (IOException e) {
//                System.out.println("Error closing resources: " + e.getMessage());
//            }
//        }
//
//        public void validateLogin() {
//
//            Long staffId = null;
//            String password = null;
//            try {
//                staffId = (Long) dataInput.readObject();
//                password = (String) dataInput.readObject();
//
//            } catch (ClassNotFoundException | IOException e) {
//                e.printStackTrace();
//            }
//
//            response = JDBCPersistence.isValidLogin(staffId, password);
//
//            try {
//                dataOutput.writeObject(response);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        public void doesStaffExists() {
//
//            Long staffId = null;
//           
//            try {
//
//                staffId = (Long) dataInput.readObject();
//
//            } catch (ClassNotFoundException | IOException e) {
//                e.printStackTrace();
//            }
//
//            response = JDBCPersistence.isStaffIdPresent(staffId);
//
//            try {
//                dataOutput.writeObject(response);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        public void addStaff() {
//
//            try {
//                model.Staff staff = (model.Staff) dataInput.readObject();
//
//
//                Address address = new Address();
//                address.setAddress1(staff.getAddress().getAddress1());
//                address.setAddress2(staff.getAddress().getAddress2());
//                address.setParish(staff.getAddress().getParish());
//                address.setPostOffice(staff.getAddress().getPostOffice());
//
//                SaveEntityToDB.saveObject(address, Address.class);
//
//                Staff staffToSave = new Staff();
//                staffToSave.setFirstName(staff.getFirstName());
//                staffToSave.setLastName(staff.getLastName());
//                staffToSave.setDateOfBirth(staff.getDateOfBirth());
//                staffToSave.setDateOfBirth(staff.getDateOfBirth());
//                staffToSave.setAddress(address);
//                staffToSave.setEmail(staff.getEmail());
//                staffToSave.setPosition(staff.getPosition());
//                staffToSave.setStatus(staff.getStatus());
//
//
//                SaveEntityToDB.saveObject(staffToSave, Staff.class);
//
//            } catch (ClassNotFoundException | IOException e) {
//                e.printStackTrace();
//            } finally {
//                SaveEntityToDB.closeSession();
//            }
//
//        }
//
//        public void resetStaffPassword() {
//
//            Long staffId = null;
//            String password = null;
//            try {
//                staffId = (Long) dataInput.readObject();
//                password = (String) dataInput.readObject();
//
//            } catch (ClassNotFoundException | IOException e) {
//                e.printStackTrace();
//            }
//
//            response = JDBCPersistence.resetPassword(staffId, password);
//
//            if(response) {
//               JOptionPane.showMessageDialog(null, "Password reset successful");
//            }
//
//        }
//    }
//    
//    public static void main(String[] args) {
//        new Server();
//    }
//    
//}