package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import domain.TripOrder;
import domain.logins;
import domain.routeRates;
import javax.swing.JOptionPane;

import domain.Customer;
import domain.Staff;

public class server {
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	protected ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	protected static Connection dBConn;
	protected Statement stmt;
	protected ResultSet result;
	
	
	public 	server() {
	    
	   createConnection();
	  
	   waitForRequests();
	}

	public void createConnection() {
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
		public static Connection getDatabaseConnection() {
			if (dBConn == null) {
				String url = "jdbc:mysql://localhost:3306/jhtdatabase";
				try {
					dBConn = DriverManager.getConnection(url,"root","");
					JOptionPane.showMessageDialog(null, "DB Connection Established",
							"Connection Status",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Could not establish DB Connection ",
							"Connection Failure",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			return dBConn;
			
		}
		
		private void closeConnection() {
			
			try {
				objOs.close();
				objIs.close();
				connectionSocket.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		private void waitForRequests() { 
			String action = ""; 
			getDatabaseConnection();
			Customer custObj = null; 
			customerCrud obj1 = null;
			TripOrder tripObj = null;
			orderCrud obj2 = null;
			Staff staffObj = null;
			staffCrud obj3 = null;
			routeRates routeRateObj = null;
			routeRatesCrud obj4 = null;
			logins loginObj = null;
			loginCrud obj5 = null;
			
			try {
				while (true) {
					connectionSocket = serverSocket.accept(); 
					this.configureStreams ();
					try {
						action = (String) objIs.readObject();
						if (action.equals ("Add Customer")) {
							custObj = (Customer) objIs.readObject();
							obj1.addCustomerToFile(custObj); 
							objOs.writeObject(true);
						} else if (action.equals ("Find Customer")) {
							String custID = (String) objIs.readObject();
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
						else if (action.equals("Add Staff")) {
							staffObj = (Staff) objIs.readObject();
							obj3.addStaffToFile(staffObj);
							objOs.writeObject(true);
						}
						else if (action.equals("Find Staff")) {
							String staffID = (String) objIs.readObject();
							staffObj = obj3.findStaffById(staffObj.getStaffID());
							objOs.writeObject(staffObj);
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
}

