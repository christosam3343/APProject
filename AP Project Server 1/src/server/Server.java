package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import generalinfo.Staff;
import models.DBConnectorFactory;

public class Server {
	private ServerSocket serverSocket;
	private Socket connectedClient;
	protected Statement stmt;
	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	protected ResultSet result;
	private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
	
	
    public Server() {
        createConnection();
        DBConnectorFactory.getDatabaseConnection();
        waitForRequests();
   }
    private void createConnection() {
        try {
            serverSocket = new ServerSocket(8888);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configureStreams() {
        try {
            objOs = new ObjectOutputStream(connectedClient.getOutputStream());
            objIs = new ObjectInputStream(connectedClient.getInputStream());
        } catch (IOException e) {
        	System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            objOs.close();
            objIs.close();
            connectedClient.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void waitForRequests() {
//        mainScreen = new MainScreen(serverSocket);
//        splashScreen.dispose();
//        mainScreen.setVisible(true);
        System.out.println("Sever is running");
        try {
            // running infinite loop for getting client request
            while (true) {
                // get current local time
                LocalDateTime localDateTime = LocalDateTime.now();

                // socket object to receive incoming connectedClient requests
                connectedClient = serverSocket.accept();

                String clientConnected = "Client connected: " + connectedClient.getInetAddress().getHostAddress() +
                        " @ " + localDateTime.format(dateTimeFormatter);

                // Displaying that new client is connected to server
                System.out.println(clientConnected);

                // Update text area
//                mainScreen.setTextArea(clientConnected);

                // create a new thread object
                ClientHandler clientHandler = new ClientHandler();

                // This thread will handle the client separately
                new Thread(clientHandler).start();
            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
        	System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
            	System.out.println("IOException: " + e.getMessage());
            }
        }
    }
    
    
    public boolean addStaffToFile(Staff staff) {
		
		boolean saved = false;
		
		String sql = "INSERT INTO staff(`staffID`, `staffFirstName`, `staffLastName`, "
				+ "`staffDob`, `staffAddress1`, `staffAddress2`,"
				+ " `staffPostOffice`, `staffParish`, `staffTelephone`,"
				+ " `staffEmail`, `staffPosition`, `staffStatus`) "
				+ "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		try {	
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, staff.getStaffID());
			statement.setString(2, staff.getstaffFirstName());
			statement.setString(3, staff.getstaffLastName());
			// 2001-05-21
			statement.setDate(4, new java.sql.Date(staff.getstaffDob().getTime()));
			statement.setString(5, staff.getstaffAddress1());
			statement.setString(6, staff.getstaffAddress2());
			
			statement.setString(7, staff.getstaffPostOffice());
			statement.setString(8, staff.getstaffParish());
			statement.setString(9, staff.getstaffTelephone());
			statement.setString(10, staff.getstaffEmail());
			
			statement.setString(11, staff.getstaffPosition());
			//int
			statement.setBoolean(12, staff.getstaffStatus());
					
			if ((statement.executeUpdate() == 1)) {
				saved = true; 
				System.out.print("SAVED STAFF");
			}
				
		} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return saved; //Return true to client if successful
	}
    
    public Staff findStaffById(int staffID) {
		Staff staffObj = new Staff();
		String sql = "Select * from staff WHERE staffID ='" + staffID + "'";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			result = statement.executeQuery(sql); 
			if (result.next()) {
				staffObj.setStaffID(result.getInt (1));
				staffObj.setstaffFirstName(result.getString(2));
				staffObj.setstaffLastName(result.getString(3)); 
				staffObj.setstaffDob(new java.util.Date(result.getDate(4).getTime()));
				staffObj.setstaffAddress1(result.getString(5));
				staffObj.setstaffAddress2(result.getString(6));
				staffObj.setstaffPostOffice(result.getString(7));
				staffObj.setstaffParish(result.getString(8));
				staffObj.setstaffTelephone(result.getString(9));
				staffObj.setstaffEmail(result.getString(10));
				staffObj.setstaffPosition(result.getString(11));
				staffObj.setstaffStatus(result.getBoolean(12));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return staffObj;	
	}

  //Class for handling client requests
  class ClientHandler implements Runnable {

      @Override
      public void run() {
          String action;
          Staff staff;
          configureStreams();
          
          try {
              action = (String) objIs.readObject();
//              logger.info("Requested action: " + action);
//              mainScreen.setRequestsText(requestAmount++);
//              mainScreen.setTextArea("\nRequested action: " + action);
//              mainScreen.setTextArea("\nHandled on: " + Thread.currentThread().getName() + "\n\n");
              if (action.equals("Add Staff")) {
                  staff = (Staff) objIs.readObject();
                  addStaffToFile(staff);
              }
              if (action.equals("Find Staff")) {
                  int id = (int) objIs.readObject();
                  staff = findStaffById(id);
                  objOs.writeObject(staff);
              }
          } catch (EOFException e) {
//              logger.error("EOFException: " + e.getMessage());
              e.printStackTrace();
          } catch (IOException e) {
//              logger.error("IOException: " + e.getMessage());
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
//              logger.error("ClassNotFoundException: " + e.getMessage());
              e.printStackTrace();
          } catch (ClassCastException e) {
//              logger.error("ClassCastException: " + e.getMessage());
              e.printStackTrace();
          } finally {
              closeConnections();
          }
      }
  }
//	public 	Server() {
//		try {
//			serverSocket = new ServerSocket(8888);
//			while (!serverSocket.isClosed()) {
//				connectedClient = serverSocket.accept();
//	            System.out.println("Client connected");
//	             ClientHandler client = new ClientHandler(connectedClient);
//	             Thread thread = new Thread(client);
//	             thread.start();
//	         }
//		} catch (IOException e) {
//            System.out.println("Server exception: " + e.getMessage());
//        }
//	}
//	
//	
//	class ClientHandler implements Runnable{
//		protected ObjectOutputStream objOs;
//		protected ObjectInputStream objIs;
//		private Socket socket;
//		private String request;
//		
//		
//		public ClientHandler(Socket socket) {
//			this.socket = socket;
//	           
//	     }
//		 
//
//		@Override
//		public void run() {
//			 configureStreams();
//			 Staff staffObj = null;
//			 
//			 try {
//				 
//				while ((request = (String) objIs.readObject()) != null) {
//					
//					System.out.println("In Server Thread");
//					
//					if (request.equalsIgnoreCase("Add Staff")) {
//						System.out.println("in server to add staff");
//						staffObj =  (Staff) objIs.readObject();
//						StaffCrud obj3 = new StaffCrud();
//						
//						boolean saved = obj3.addStaffToFile(staffObj);
//						objOs.writeObject(saved);
//					}
//					
////					waitForRequests(request);
//					 
//				}
//			} catch (ClassNotFoundException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				closeConnection();
//			}
//			
//		}
//		
//		private void waitForRequests(String action) { 
//			Customer custObj = null; 
//			CustomerCrud obj1 = null;
//			TripOrder tripObj = null;
//			OrderCrud obj2 = null;
//			Staff staffObj = null;
//			//staffCrud obj3 = new staffCrud();
//			RouteRates routeRateObj = null;
//			RouteRatesCrud obj4 = null;
//			Logins loginObj = null;
//			LoginCrud obj5 = null;
//			
//			try {
//				while (true) {
//					
//					try {
//						if (action.equals ("Add Customer")) {
////							Customer custObj = new Customer();
//;							custObj = (Customer) objIs.readObject();
//							obj1.addCustomerToFile(custObj); 
//							objOs.writeObject(true);
//						} else if (action.equals ("Find Customer")) {
//							String cusID = (String) objIs.readObject();
//							// Call method to find the student based on the id number
//							custObj = obj1.findCustomerById(custObj.getCustId());
//							objOs.writeObject(custObj);
//						}
//						else if(action.equals("Update Customer")) {
//							custObj = (Customer) objIs.readObject();
//							obj1.updateCust(custObj); 
//							objOs.writeObject(true);
//						}
//						else if(action.equals("Add Order")) {
//							tripObj = (TripOrder) objIs.readObject();
//							obj2.createOrder(tripObj);
//							objOs.writeObject(true);
//						}
//						else if (action.equals("Find Order")) {
//							String invoiceNo = (String) objIs.readObject();
//							tripObj = obj2.searchOrder(tripObj.getInvoiceNo());
//							objOs.writeObject(custObj);
//						}
//						else if (action.equalsIgnoreCase("Add Staff")) {
//							System.out.println("in server to add staff");
//							staffObj =  (Staff) objIs.readObject();
//							StaffCrud obj3 = new StaffCrud();
//							
//							
//							boolean saved = obj3.addStaffToFile(staffObj);
//							objOs.writeObject(saved);
//						}
//						else if (action.equals("Find Staff")) {
//			
//							String staffID = (String) objIs.readObject();
//							StaffCrud obj3 = new StaffCrud();
//							staffObj = obj3.findStaffById(Integer.parseInt(staffID));
//							objOs.writeObject(staffObj);
//						}
//						else if (action.equals("Delete Staff")) {
//							String staffID = (String) objIs.readObject();
//							StaffCrud obj3 = new StaffCrud();
//							obj3.deleteStaff(Integer.parseInt(staffID));
//							objOs.writeObject(true);
//						}
//						else if (action.equals("Get Rate")) {
//							String routeName = (String) objIs.readObject();
//							routeRateObj = obj4.searchRoute(routeRateObj.getRouteName());
//							objOs.writeObject(routeRateObj);
//						}
//						else if (action.equals(" Login ")) {
//							String userName = (String) objIs.readObject();
//							loginObj = obj5.checkLogin(loginObj.getPassword());
//							objOs.writeObject(loginObj);
//						}
//						
//						
//					} catch (ClassNotFoundException ex) {
//						ex.printStackTrace();
//					} catch (ClassCastException ex) {
//						ex.printStackTrace();
//					}
//					this.closeConnection();
//				}
//			
//			} catch (EOFException ex) {
//				System.out.println("Client has terminted connections with the server");
//				ex.printStackTrace();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//	}
		
//		private void closeConnection() {
//					
//					try {
//						objOs.close();
//						objIs.close();
//						socket.close();
//					} catch (IOException e) {
//						
//						e.printStackTrace();
//					}
//					
//				}
//		
//		private void configureStreams() {
//			
//			
//			try {
//				objIs = new ObjectInputStream(socket.getInputStream());
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//			try {
//				
//				objOs = new ObjectOutputStream(socket.getOutputStream());
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//			
//			
//			
//		}
		
		
		
		
	}


	
	
		
		
		
		

