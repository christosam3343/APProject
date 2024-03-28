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
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import client.Client;
import generalinfo.Customer;
import generalinfo.RouteRates;
import generalinfo.Staff;
import generalinfo.TripOrder;
import models.DBConnectorFactory;

public class Server {
	private ServerSocket serverSocket;
	private Socket connectedClient;
	protected Statement stmt;
	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	protected ResultSet result;
	private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private final Logger logger = LogManager.getLogger(Server.class);
	
	
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
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configureStreams() {
        try {
            objOs = new ObjectOutputStream(connectedClient.getOutputStream());
            objIs = new ObjectInputStream(connectedClient.getInputStream());
        } catch (IOException e) {
        	logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            objOs.close();
            objIs.close();
            connectedClient.close();
        } catch (IOException e) {
        	logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void waitForRequests() {
//        mainScreen = new MainScreen(serverSocket);
//        splashScreen.dispose();
//        mainScreen.setVisible(true);
    	logger.info("Sever is running");
        try {
            // running infinite loop for getting client request
            while (true) {
                // get current local time
                LocalDateTime localDateTime = LocalDateTime.now();

                // socket object to receive incoming connectedClient requests
                connectedClient = serverSocket.accept();

                String clientConnected = "Client connected: " + connectedClient.getInetAddress().getHostAddress() +
                        " @ " + localDateTime.format(dateTimeFormatter);
                
                logger.info(clientConnected);

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
			statement.setInt(12, staff.getstaffStatus());
					
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
				staffObj.setstaffStatus(result.getInt(12));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return staffObj;	
	}

	public void updateStaff(Staff staff) {
			
			String sql = "UPDATE staff SET staffFirstName = '"+ staff.getstaffFirstName()+"',staffLastName = '"+staff.getstaffLastName()+"',"
						+ "staffDob ='"+staff.getstaffDob()+"', staffAddress1 = '"+staff.getstaffAddress1()+"', staffAddress2 = '"
						+ staff.getstaffAddress2()+"',staffPostOffice = '"+ staff.getstaffPostOffice()+"', staffParish = '"+staff.getstaffParish()
						+"',staffTelephone = '"+ staff.getstaffTelephone()+"', staffEmail = '"+staff.getstaffEmail()+"', staffPosition = '"
						+staff.getstaffPosition()+"' ,staffStatus = "+staff.getstaffStatus()+" WHERE staffID = '"+ staff.getStaffID()+"'";
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
				PreparedStatement statement = connection.prepareStatement(sql);
			
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
    
    public void deleteStaff(int StaffID)  {
		String sql = "DELETE from staff"+" WHERE StaffID="+"'"+StaffID+"'";
		Statement ex = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
    
    
    public boolean addCustomerToFile(Customer customer) {

		boolean saved = false;
		
		String sql = "INSERT INTO customer (`CustId`, `company`, `contactPerson`, `custAddress1`, `custAddress2`,"
				+ "`custPostOffice`, `custParish`, `custTelephone`, `custEmail`, `custBalance`, `custStatus`)"
				+ "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		try {		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, customer.getCustId());
			statement.setString(2, customer.getCompany());
			statement.setString(3, customer.getContactPerson());
			statement.setString(4, customer.getCustAddress1());
			statement.setString(5, customer.getCustAddress2());
			statement.setString(6, customer.getCustPostOffice());
			statement.setString(7, customer.getCustParish());
			statement.setString(8, customer.getCustTelephone());
			statement.setString(9, customer.getCustEmail());
			statement.setDouble(10, customer.getCustBalance());
			statement.setBoolean(11, customer.isCustStatus());
			
			
			if ((statement.executeUpdate() == 1)) {
					saved = true; 
					System.out.print("SAVED CUSTOMER");
			}
				
		} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return saved; //Return true to client if successful
	}
    
    public Customer findCustomerById(int customerID) {
		Customer customerObj = new Customer();
		String sql = "Select * from customer WHERE CustId ='" + customerID + "'";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			result = statement.executeQuery(sql); 
			if (result.next()) {
				customerObj.setCustId(result.getInt(1));
				customerObj.setCompany(result.getString(2));
				customerObj.setContactPerson(result.getString(3)); 
				customerObj.setCustAddress1(result.getString(4));
				customerObj.setCustAddress2(result.getString(5));
				customerObj.setCustPostOffice(result.getString(6));
				customerObj.setCustParish(result.getString(7));
				customerObj.setCustTelephone(result.getString(8));
				customerObj.setCustEmail(result.getString(9));
				customerObj.setCustBalance(result.getFloat(10));
				customerObj.setCustStatus(result.getBoolean(11));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return customerObj;	
	}
    
    public void updateCustomer(Customer customer) {
		
		String sql = "UPDATE customer SET company = '"+ customer.getCompany()+"',contactPerson = '"+customer.getContactPerson()+"',"
					+ "custAddress1 ='"+customer.getCustAddress1()+"', custAddress2 = '"+customer.getCustAddress2()+"', custPostOffice = '"
					+ customer.getCustPostOffice()+"',custParish = '"+ customer.getCustParish()+"', custTelephone = '"+customer.getCustTelephone()
					+"',custEmail = '"+ customer.getCustEmail()+"', custBalance = "+customer.getCustBalance()+", custStatus = "
					+customer.isCustStatus()+ " WHERE CustId = '"+ customer.getCustId()+"'";
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
    public void deleteCustomer(int CustId)  {
		String sql = "DELETE from customer"+" WHERE CustID="+"'"+CustId+"'";
		Statement ex = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
    public boolean addTripOrder(TripOrder tripOrder) {

		boolean saved = false;
		
		String sql = "INSERT INTO orders (`invoiceNo`, `routeName`, `company`, `sourceAddress`, `destinationAddress`,"
				+ "`rate`, `driver`, `billedBy`)"
				+ "VALUES (? , ?, ?, ?, ?, ?, ?, ?)";
				
		try {		
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tripOrder.getInvoiceNo());
			statement.setString(2, tripOrder.getRouteName());
			statement.setString(3, tripOrder.getCompany());
			statement.setString(4, tripOrder.getSourceAddress());
			statement.setString(5, tripOrder.getDestinationAddress());
			statement.setFloat(6, tripOrder.getRate());
			statement.setString(7, tripOrder.getDriver());
			statement.setString(8, tripOrder.getBilledBy());
			
			
		
			
			
			if ((statement.executeUpdate() == 1)) {
					saved = true; 
					System.out.print("SAVED STAFF");
			}
				
		} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return saved; //Return true to client if successful
	}
    
    public TripOrder findTripOrder(String invoiceNo) {
		TripOrder tripOrder = new TripOrder();
		String sql = "Select * from orders WHERE invoiceNo ='" + invoiceNo + "'";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			result = statement.executeQuery(sql); 
			if (result.next()) {
				tripOrder.setInvoiceNo(result.getString(1));
				tripOrder.setRouteName(result.getString(2));
				tripOrder.setCompany(result.getString(3)); 
				tripOrder.setSourceAddress(result.getString(4));
				tripOrder.setDestinationAddress(result.getString(5));
				tripOrder.setRate(result.getFloat(6));
				tripOrder.setDriver(result.getString(7));
				tripOrder.setBilledBy(result.getString(8));
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return tripOrder;	
	}
    
    public void deleteTripOrder(String invoiceNo)  {
		String sql = "DELETE from orders"+" WHERE invoiceNo="+"'"+invoiceNo+"'";
		Statement ex = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
 public void updateTripOrder(TripOrder tripOrder) {
		
		String sql = "UPDATE orders SET invoiceNo = '"+ tripOrder.getInvoiceNo()+"',routeName = '"+tripOrder.getRouteName()+"',"
					+ "company ='"+tripOrder.getCompany()+"', sourceAddress = '"+tripOrder.getSourceAddress()+"', destinationAddress = '"
					+ tripOrder.getDestinationAddress()+"',rate = '"+ tripOrder.getRate()+"', driver = '"+tripOrder.getDriver()
					+"',billedBy = '"+ tripOrder.getBilledBy()+"'"+" WHERE invoiceNo = '"+ tripOrder.getInvoiceNo()+"'";
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
 
 	public RouteRates[] getRoutes() {
	 	ArrayList<RouteRates> routes =  new ArrayList<RouteRates>();
	 
		String sql = "Select * from routerates";
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			result = statement.executeQuery(sql);
			
			while (result.next()) {
				RouteRates route = new RouteRates();
				
				System.out.println(route.toString());
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				
				route.setrouteName(result.getString(1));
				route.setSource(result.getString(2));
				route.setDestination(result.getString(3));
				route.setRate(result.getDouble(4));
				
				routes.add(route);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return routes.toArray(new RouteRates[routes.size()]);	
	}
    
  //Class for handling client requests
  class ClientHandler implements Runnable {

      @Override
      public void run() {
          String action;
          Staff staff;
          Customer customer;
          TripOrder tripOrder;
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
              if (action.equals("Delete Staff")) {
                  int id = (int) objIs.readObject();
                   deleteStaff(id);
                 // objOs.writeObject(staff);
              }
              if (action.equals("Update Staff")) {
                  staff = (Staff) objIs.readObject();
                  updateStaff(staff);
              }
              if (action.equals("Add Customer")) {
            	  customer = (Customer) objIs.readObject();
                  addCustomerToFile(customer);
              }
              if (action.equals("Find Customer")) {
                  int id = (int) objIs.readObject();
                  customer = findCustomerById(id);
                  objOs.writeObject(customer);
              }
              if (action.equals("Delete Customer")) {
                  int id = (int) objIs.readObject();
                   deleteCustomer(id);
                 // objOs.writeObject(staff);
              }
              if (action.equals("Update Customer")) {
            	  customer = (Customer) objIs.readObject();
                  updateCustomer(customer);
              }
              if (action.equals("Add Trip Order")) {
            	  tripOrder = (TripOrder) objIs.readObject();
                  addTripOrder(tripOrder);
              }
              if (action.equals("Find Trip Order")) {
                  String invoiceNumber = (String) objIs.readObject();
                  tripOrder = findTripOrder(invoiceNumber);
                  objOs.writeObject(tripOrder);
              }
              if (action.equals("Delete Trip Order")) {
                  String invoiceNo = (String) objIs.readObject();
                   deleteTripOrder(invoiceNo);
                 // objOs.writeObject(staff);
              }
              if (action.equals("Update Trip Order")) {
            	  tripOrder = (TripOrder) objIs.readObject();
                  updateTripOrder(tripOrder);
              }
              if (action.equals("Get Routes")) {
            	  RouteRates[] routes = getRoutes();
                  objOs.writeObject(routes);
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


	
	
		
		
		
		

