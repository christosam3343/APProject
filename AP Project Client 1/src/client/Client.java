package client;
import java.io.*;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import generalinfo.Staff;


public class Client{
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
			
			e.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objOss = new ObjectOutputStream(connectionSockett.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			objIss = new ObjectInputStream(connectionSockett.getInputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		
		try {
			objOss.close();
			objIss.close();
			connectionSockett.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void sendAction(String action) {
		this.action = action;
		try {
			objOss.writeObject(action);
			System.out.println("Sending action: "+ action);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void sendStaff(Staff staffObj) {
		try {
			objOss.writeObject(staffObj);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public void sendStaffId(int staffId) {
		try {
			objOss.writeObject(staffId);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public boolean addedSuccessful() {
		
		 try {
			Boolean flag = (Boolean) objIss.readObject();
			return flag;
		} catch (EOFException eof) {
			System.out.println("End of file reached: "+eof.getMessage());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Staff receiveResponse() {
	    Staff staff = null;
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
	        }
	    } catch (ClassCastException ex) {
	        ex.printStackTrace();
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	    } catch (EOFException ex) {
	        ex.printStackTrace();
	    }catch (IOException ex) {
	        ex.printStackTrace();
	    }
	    
	    staff.Display();
	    return staff;
	}
}
