package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.Statement;


import generalinfo.Customer;
import generalinfo.Staff;
import generalinfo.TripOrder;
import generalinfo.logins;
import generalinfo.routeRates;

public class server {
	private ServerSocket serverSocket;
	private Socket connectedClient;
	protected Statement stmt;
	protected ResultSet result;
	
	
	
	public 	server() {
	    

		try {
			
			serverSocket = new ServerSocket(8888);
			
			while (!serverSocket.isClosed()) {
	             
				connectedClient = serverSocket.accept();
	            System.out.println("Client connected");

	             ClientHandler client = new ClientHandler(connectedClient);
	             Thread thread = new Thread(client);
	             thread.start();

	         }
			
		} catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
	  
	  
	  
	}
	
	
	class ClientHandler implements Runnable{
		
		
		protected ObjectOutputStream objOs;
		protected ObjectInputStream objIs;
		private Socket socket;
		private String request;
		
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
	           
	     }
		 

		@Override
		public void run() {
			 configureStreams();
			 Staff staffObj = null;
			 
			 try {
				 
				while ((request = (String) objIs.readObject()) != null) {
					
					System.out.println("In Server Thread");
					
					if (request.equalsIgnoreCase("Add Staff")) {
						System.out.println("in server to add staff");
						staffObj =  (Staff) objIs.readObject();
						staffCrud obj3 = new staffCrud();
						
						
						boolean saved = obj3.addStaffToFile(staffObj);
						objOs.writeObject(saved);
					}
					
//					waitForRequests(request);
					 
				}
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConnection();
			}
			
		}
		
		private void waitForRequests(String action) { 
			Customer custObj = null; 
			customerCrud obj1 = null;
			TripOrder tripObj = null;
			orderCrud obj2 = null;
			Staff staffObj = null;
			//staffCrud obj3 = new staffCrud();
			routeRates routeRateObj = null;
			routeRatesCrud obj4 = null;
			logins loginObj = null;
			loginCrud obj5 = null;
			
			try {
				while (true) {
					
					try {
						if (action.equals ("Add Customer")) {
							custObj = (Customer) objIs.readObject();
							obj1.addCustomerToFile(custObj); 
							objOs.writeObject(true);
						} else if (action.equals ("Find Customer")) {
							String cusID = (String) objIs.readObject();
							// Call method to find the student based on the id number
							custObj = obj1.findCustomerById(custObj.getCustId());
							objOs.writeObject(custObj);
						}
						else if(action.equals("Update Customer")) {
							custObj = (Customer) objIs.readObject();
							obj1.updateCust(custObj); 
							objOs.writeObject(true);
						}
						else if(action.equals("Add Order")) {
							tripObj = (TripOrder) objIs.readObject();
							obj2.createOrder(tripObj);
							objOs.writeObject(true);
						}
						else if (action.equals("Find Order")) {
							String invoiceNo = (String) objIs.readObject();
							tripObj = obj2.searchOrder(tripObj.getInvoiceNo());
							objOs.writeObject(custObj);
						}
						else if (action.equalsIgnoreCase("Add Staff")) {
							System.out.println("in server to add staff");
							staffObj =  (Staff) objIs.readObject();
							staffCrud obj3 = new staffCrud();
							
							
							boolean saved = obj3.addStaffToFile(staffObj);
							objOs.writeObject(saved);
						}
						else if (action.equals("Find Staff")) {
			
							String staffID = (String) objIs.readObject();
							staffCrud obj3 = new staffCrud();
							staffObj = obj3.findStaffById(Integer.parseInt(staffID));
							objOs.writeObject(staffObj);
						}
						else if (action.equals("Delete Staff")) {
							String staffID = (String) objIs.readObject();
							staffCrud obj3 = new staffCrud();
							obj3.deleteStaff(Integer.parseInt(staffID));
							objOs.writeObject(true);
						}
						else if (action.equals("Get Rate")) {
							String routeName = (String) objIs.readObject();
							routeRateObj = obj4.searchRoute(routeRateObj.getRouteName());
							objOs.writeObject(routeRateObj);
						}
						else if (action.equals(" Login ")) {
							String userName = (String) objIs.readObject();
							loginObj = obj5.checkLogin(loginObj.getPassword());
							objOs.writeObject(loginObj);
						}
						
						
					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
					} catch (ClassCastException ex) {
						ex.printStackTrace();
					}
					this.closeConnection();
				}
			
			} catch (EOFException ex) {
				System.out.println("Client has terminted connections with the server");
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
		
		private void closeConnection() {
					
					try {
						objOs.close();
						objIs.close();
						socket.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
		
		private void configureStreams() {
			
			
			try {
				objIs = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				
				objOs = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}


	
	
		
		
		
		
		
}

