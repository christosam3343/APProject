package client;
import java.io.*;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import generalinfo.Customer;
import generalinfo.RouteRates;
import generalinfo.Staff;
import generalinfo.TripOrder;


public class Client{
	private final Logger logger = LogManager.getLogger(Client.class);
	private Socket connectionSockett;
	protected ObjectOutputStream objOss;
	protected ObjectInputStream objIss;
	private String action;
	
	public Client() {
		createConnection();
		configureStreams();
//		receiveResponse();
	}
	
	private void createConnection() {
		try {
			connectionSockett = new Socket("127.0.0.1",8888);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	private void configureStreams() {
		try {
			objOss = new ObjectOutputStream(connectionSockett.getOutputStream());
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
		try {
			objIss = new ObjectInputStream(connectionSockett.getInputStream());
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	public void closeConnection() {
		
		try {
			objOss.close();
			objIss.close();
			connectionSockett.close();
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	public void sendAction(String action) {
		this.action = action;
		try {
			objOss.writeObject(action);
			System.out.println("Sending action: "+ action);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	public void sendStaff(Staff staffObj) {
		try {
			objOss.writeObject(staffObj);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	
	
	public void sendStaffId(int staffId) {
		try {
			objOss.writeObject(staffId);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}	
	}
	
	
	
	public boolean addedSuccessful() {
		
		 try {
			Boolean flag = (Boolean) objIss.readObject();
			return flag;
		} catch (EOFException eof) {
			logger.error("End of file reached: " + eof.getMessage());
		} catch (ClassNotFoundException | IOException e) {
			logger.error("Error: " + e.getMessage());
		}
		return false;
	}
	
	public Object receiveResponse() {
	    Staff staff = null;
	    RouteRates[] routes;
	    
	    try {
	    	System.out.print("RECEIVING RESPONSE\n");
	    	
	        if (action.equalsIgnoreCase("Add Staff")) {
	            Boolean flag = (Boolean) objIss.readObject();
	            if (flag) {
	                JOptionPane.showMessageDialog(null, "Record added successfully",
	                        "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } 
	        else if (action.equalsIgnoreCase("Find Staff")) {
	        	System.out.print("finding staff...\n");
	            staff = (Staff) objIss.readObject();
	            
	            if (staff == null) {
	                JOptionPane.showMessageDialog(null, "Record could not be found",
	                        "Find Record Status", JOptionPane.ERROR_MESSAGE);
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Staff Found",
	                        "Found staff member", JOptionPane.INFORMATION_MESSAGE);
	            }
	            
	            staff.Display();
	    	    return staff;
	        }
	        else if (action.equalsIgnoreCase("Get Routes")) {
	        	System.out.print("loading routes...\n");
	            routes = (RouteRates[]) objIss.readObject();
	            
	            if (routes == null) {
	                JOptionPane.showMessageDialog(null, "Record could not be found",
	                        "Find Record Status", JOptionPane.ERROR_MESSAGE);
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Roues Found",
	                        "Found routes", JOptionPane.INFORMATION_MESSAGE);
	            }
	            
	            return routes;
	        }
	    } catch (ClassCastException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (ClassNotFoundException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (EOFException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    }catch (IOException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    }
	    
	    return null;
	}
	
	
	
	public void sendCustomer(Customer custObj) {
		try {
			objOss.writeObject(custObj);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	public void sendCustomerId(int custId) {
		try {
			objOss.writeObject(custId);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}	
	}
	
	public Customer receiveResponse1() {
		Customer customer = null;
	    try {
	    	System.out.print("RECEIVING RESPONSE\n");
	    	
	        if (action.equalsIgnoreCase("Add Customer")) {
	            Boolean flag = (Boolean) objIss.readObject();
	            if (flag) {
	                JOptionPane.showMessageDialog(null, "Record added successfully",
	                        "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } 
	        else if (action.equalsIgnoreCase("Find Customer")) {
	        	System.out.print("finding customer...\n");
	        	customer = (Customer) objIss.readObject();
	            
	            if (customer == null) {
	                JOptionPane.showMessageDialog(null, "Record could not be found",
	                        "Find Record Status", JOptionPane.ERROR_MESSAGE);
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Customer Found",
	                        "Found customer member", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (ClassCastException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (ClassNotFoundException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (EOFException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (IOException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    }
	    
	    customer.Display();
	    return customer;
	}
	
	public void sendTripOrder(TripOrder tripObj) {
		try {
			objOss.writeObject(tripObj);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	public void sendRouteName(String routeName) {
		try {
			objOss.writeObject(routeName);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}	
	}
	
	public TripOrder receiveResponse2() {
		TripOrder tripOrder = null;
	    try {
	    	logger.info("RECEIVING RESPONSE FOR TRIP ORDER");
	    	
	        if (action.equalsIgnoreCase("Add Trip Order")) {
	            Boolean flag = (Boolean) objIss.readObject();
	            if (flag) {
	                JOptionPane.showMessageDialog(null, "Record added successfully",
	                        "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
	                logger.info("Record added successfully");
	            }
	        } 
	        else if (action.equalsIgnoreCase("Find Trip Order")) {
	        	logger.info("Finding Trip Order ...");
	        	tripOrder = (TripOrder) objIss.readObject();
	            
	            if (tripOrder == null) {
	                JOptionPane.showMessageDialog(null, "Record could not be found",
	                        "Find Record Status", JOptionPane.ERROR_MESSAGE);
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Customer Found",
	                        "Found customer member", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (ClassCastException ex) {
	        logger.error("Error: " + ex.getMessage());
	    } catch (ClassNotFoundException ex) {
	    	  logger.error("Error: " + ex.getMessage());
	    } catch (EOFException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (IOException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    }
	    
	    tripOrder.Display();
	    return tripOrder;
	}
	
	public void sendRouteRates(RouteRates routeObj) {
		try {
			objOss.writeObject(routeObj);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	
	public void sendRouteName1(String routeName) {
		try {
			objOss.writeObject(routeName);
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		}	
	}
	
	public RouteRates receiveResponse3() {
		RouteRates routeRates = null;
	    try {
	    	logger.info("RECEIVING RESPONSE FOR ROUTE RATES");
	    	
	        if (action.equalsIgnoreCase("Add Route and Rates")) {
	            Boolean flag = (Boolean) objIss.readObject();
	            if (flag) {
	                JOptionPane.showMessageDialog(null, "Record added successfully",
	                        "Add Record Status", JOptionPane.INFORMATION_MESSAGE);
	                logger.info("Record added successfully");
	            }
	        } 
	        else if (action.equalsIgnoreCase("Find Route and Rates")) {
	        	logger.info("Finding Trip Order ...");
	        	routeRates = (RouteRates) objIss.readObject();
	            
	            if (routeRates == null) {
	                JOptionPane.showMessageDialog(null, "Record could not be found",
	                        "Find Record Status", JOptionPane.ERROR_MESSAGE);
	            }
	            else {
	            	JOptionPane.showMessageDialog(null, "Customer Found",
	                        "Found customer member", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (ClassCastException ex) {
	        logger.error("Error: " + ex.getMessage());
	    } catch (ClassNotFoundException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (EOFException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    } catch (IOException ex) {
	    	logger.error("Error: " + ex.getMessage());
	    }
	    
	    routeRates.Display();
	    return routeRates;
	}
}
