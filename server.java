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
import domain.routeRates;

import javax.swing.JOptionPane;

import domain.Customer;

public class server {
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private static Connection dBConn;
	private Statement stmt;
	private ResultSet result;
	
	public 	server() {
	    
	 //   createConnection();
	 //   waitForRequests();
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
		
		public void addCustomerToFile(Customer customer) {
			boolean stat = customer.isCustStatus();
			String sql = "INSERT INTO customer (CustId,company,contactPerson,custAddress1,custAddress2,"
					+ "custPostOffice,custParish, custTelephone,custEmail, balance, custStatus)"
					+ "VALUES ("+customer.getCustId()+",'"+customer.getCompany()+"','"+customer.getContactPerson()+"',"
					+ "'"+customer.getCustAddress1()+"','"+customer.getCustAddress2()+"','"+ customer.getCustPostOffice()+"'"
					+ ",'"+customer.getCustParish()+"','"+customer.getCustTelephone()+"',"
					+ "'"+customer.getCustEmail()+"',"+customer.getCustBalance()+","+customer.isCustStatus()+")";
					
			try {		
					stmt = dBConn.createStatement();
						
					if ((stmt.executeUpdate(sql) == 1)) {
						objOs.writeObject (true);//Return true to client if successful
					} else {
						objOs.writeObject(false);
					   }				
				} catch (IOException ioe) {
					// Ideally you want to save errors to a log file
					
					ioe.printStackTrace();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		public Customer findCustomerById(int custId) {
			Customer custObj = new Customer();
			String sql = "Select * from customer "+"WHERE CustId ='"+custObj.getCustId()+"'";
			try {
				stmt = dBConn.createStatement();
				result = stmt.executeQuery(sql); 
				if (result.next()) {
					custObj.setCustId(result.getInt (1));
					custObj.setCompany (result.getString(2));
					custObj.setContactPerson (result.getString(3)); 
					custObj.setCustAddress1 (result.getString(4));
					custObj.setCustAddress1 (result.getString(5));
					custObj.setCustPostOffice (result.getString(6));
					custObj.setCustParish (result.getString(7));
					custObj.setCustTelephone (result.getString(8));
					custObj.setCustEmail (result.getString(9));
					custObj.setCustBalance (result.getFloat(10));
					custObj.setCustStatus (result.getBoolean(11));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return custObj;	
		}
		public void deleteCust(int CustId)  {
			String sql = "DELETE from customer"+" WHERE CustID="+"'"+CustId+"'";
			Statement ex = null;
			try {
				ex = dBConn.createStatement();
			
				ex.executeUpdate(sql);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public void createOrder(String invoiceNo, String company, String sourceAddress, String destinationAddress, 
								double rate, String driver, String billedBy)  {
			String sql = "INSERT INTO orders (invoiceNo,company,sourceAddress,destinationAddress,rate,"
									+ "driver,billedBy)"
									+ "VALUES ('"+invoiceNo+"','"+company+"','"+sourceAddress+"',"
									+ "'"+destinationAddress+"',"+rate+",'"+ driver+"'"
									+ ",'"+billedBy+"')";
			try {		
				stmt = dBConn.createStatement();
				stmt.executeUpdate(sql);
				if ((stmt.executeUpdate(sql) == 1)) {
					objOs.writeObject (true);//Return true to client if successful
				} else {
					objOs.writeObject(false);
				   }
			}catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public TripOrder searchOrder(String invoiceNo)  {
			TripOrder tripObj = new TripOrder();
			try {
				String sql = "Select * from orders "+"WHERE invoiceNo ='"+invoiceNo+"'";
				Statement ex = null;
				ResultSet set = null;

				ex = dBConn.createStatement();
				set = ex.executeQuery(sql);
				
			
				if (set.next()) {
					tripObj.setInvoiceNo(set.getString(1));
					tripObj.setCompany (set.getString(2));
					tripObj.setSourceAddress(set.getString(3)); 
					tripObj.setDestinationAddress(set.getString(4));
					tripObj.setRate(set.getDouble(5));
					tripObj.setDriver (set.getString(6));
					tripObj.setBilledBy(set.getString(7));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return tripObj;	
		}
		
		public void deleteOrder(String invoiceNo)  {
			String sql = "DELETE from orders"+" WHERE invoiceNo="+"'"+invoiceNo+"'";
			Statement ex = null;
			try {
				ex = dBConn.createStatement();

				ex.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void createRoute(int routenumber, String source, String destination, double rate)  {
			String sql = "INSERT INTO routerates (routenumber,source,destination,rate)"
						+ "VALUES ("+routenumber+",'"+source+"','"+destination+"'," +rate+")";
			
			Statement ex = null;
			try {		
				stmt = dBConn.createStatement();
					
				if ((stmt.executeUpdate(sql) == 1)) {
					objOs.writeObject (true);//Return true to client if successful
				} else {
					objOs.writeObject(false);
				   }				
			} catch (IOException ioe) {
				// Ideally you want to save errors to a log file
				
				ioe.printStackTrace();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
			
			public routeRates searchRoute(int routeNumber)  {
				routeRates routeObj = new routeRates();
				try {
					String sql = "Select * from routerates "+"WHERE routenumber ='"+routeNumber+"'";
					Statement ex = null;
					ResultSet set = null;
					
						ex = dBConn.createStatement();
						set = ex.executeQuery(sql);
						
						if (set.next()) {
							routeObj.setRouteNumber(set.getInt(1));
							routeObj.setSource (set.getString(2));
							routeObj.setDestination(set.getString(3)); 
							routeObj.setRate(set.getDouble(4));							
						}	
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				return routeObj;
			}
			
			
			
			public void deleteRoute(int routenumber)  {
				String sql = "DELETE from routerates"+" WHERE routenumber="+"'"+routenumber+"'";
				Statement ex = null;
				try {
					ex = dBConn.createStatement();
				
					ex.executeUpdate(sql);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
	
		private void waitForRequests() { 
			String action = ""; 
			getDatabaseConnection();
			Customer custObj = null; 
			try {
				while (true) {
					connectionSocket = serverSocket.accept(); 
					this.configureStreams ();
					try {
						action = (String) objIs.readObject();
						if (action.equals ("Add Student")) {
							custObj = (Customer) objIs.readObject();
							addCustomerToFile (custObj); 
							objOs.writeObject(true);
						} else if (action.equals ("Find Customer")) {
							String stuId = (String) objIs.readObject();
							// Call method to find the student based on the id number
							custObj = findCustomerById(custObj.getCustId());
							objOs.writeObject(custObj);
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

