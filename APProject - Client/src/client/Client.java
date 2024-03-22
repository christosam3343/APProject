package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


	public class Client
	{
		private Socket socket;
		private ObjectOutputStream objectOutputStream;
		private ObjectInputStream objectInputStream;
		private String action;
		
		public Client()
		{
			try
			{
				// Create a socket to connect to the server
				socket = new Socket("127.0.0.1", 8888);
				System.out.println("Connected");
				// Input stream to get data from the server
				objectInputStream = new ObjectInputStream(socket.getInputStream());
				// Output stream to send data to the server
				objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
			
			String line = "";
		}
		
		public void closeConnection()
		{
			try
			{
				objectOutputStream.close();
				objectInputStream.close();
				socket.close();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		public void receiveResponse()
		{
			System.out.println("Got response from server");
			
			try
			{
				if(action.equalsIgnoreCase("Verify Credentials"))
				{
					User user = new User();
					user = (User) objectInputStream.readObject();
					
					System.out.println("Searching information message for - " + user.getRole());
					if(user.getRole().equalsIgnoreCase("Customer Service Representative"))
					{
						System.out.println("Welcome " + user.getName() + " to the " + user.getRole() + " Menu");
						JOptionPane.showMessageDialog(null, "Welcome " + user.getName() + " to the " + user.getRole() + " Menu", "Login Status", JOptionPane.INFORMATION_MESSAGE);
						
						// Call Customer Service Representative GUI Menu
						CustomerServiceRepresentative scr = (CustomerServiceRepresentative) user;
						AdminDash.RepresentativeAdminDash(scr);
					}
					else if(user.getRole().equalsIgnoreCase("Technician"))
					{
						System.out.println("Welcome " + user.getName() + " to the " + user.getRole() + " Menu");
						JOptionPane.showMessageDialog(null, "Welcome " + user.getName() + " to the " + user.getRole() + " Menu", "Login Status", JOptionPane.INFORMATION_MESSAGE);
						
						// Call Technician GUI Menu
						Technician technician = (Technician) user;
						TechDash.TechnicianDash(technician);
					}
					else if(user.getRole().equalsIgnoreCase("Customer"))
					{
						System.out.println("Welcome " + user.getName() + " to the " + user.getRole() + " Menu");
						JOptionPane.showMessageDialog(null, "Welcome " + user.getName() + " to the " + user.getRole() + " Menu", "Login Status", JOptionPane.INFORMATION_MESSAGE);
						// Call Customer GUI Menu
						Customer customer = (Customer) user;
						CustomerDash.CustomerComplaint(customer);
					}
					else
					{
						System.out.println("Sorry record cound not be found, try again");
						JOptionPane.showMessageDialog(null, "Sorry record cound not be found, try again", "Login Status", JOptionPane.INFORMATION_MESSAGE);
						// Goes here if the credentails do not match with a record from the database
					}
					
					if(action.equalsIgnoreCase("Add Customer"))
					{
						Boolean flag = (Boolean) objectInputStream.readObject();
						
						if(flag == true)
						{
							JOptionPane.showMessageDialog(null, "You have been successfully added", "Customer Status", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Customer added successfully");
							Login.SignIn();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Could not add you to our database", "Customer Status", JOptionPane.INFORMATION_MESSAGE);
							System.err.println("Customer was not added successfully");
							Login.SignIn();
						}
					}
					
					if(action.equalsIgnoreCase("Make Complaint"))
					{
						Boolean flag = (Boolean) objectInputStream.readObject();
						
						if(flag == true)
						{
							JOptionPane.showMessageDialog(null, "Complaint added", "Complaint Status", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Complaint added");
							// Call Customer menu dash board
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Could not add your complaint", "Complaint Status", JOptionPane.INFORMATION_MESSAGE);
							System.err.println("Could not add your complaint");
							// Call Customer menu dash board
						}
					}
					
					if(action.equalsIgnoreCase("Veiw Customer Account"))
					{
						Boolean flag = (Boolean) objectInputStream.readObject();
						
						if(flag == true)
						{
							Customer customer = (Customer) objectInputStream.readObject();
							
							JOptionPane.showMessageDialog(null, customer, "Customer Detail", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("Customer Detail\n\n" + customer);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Cannot access your information", "Customer Detail", JOptionPane.INFORMATION_MESSAGE);
							System.err.println("Could not access the customer's information");
						}
					}
				}
			}
			catch(EOFException eofe)
			{
				eofe.printStackTrace();
			}
			catch(ClassCastException cce)
			{
				cce.printStackTrace();
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		public void sendAction(String action)
		{
			this.action = action;
			
			try
			{
				System.out.println("String - '" + action + "' sent to Server");
				objectOutputStream.writeObject(action);
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
	
		//Customer
		public void sendCustomer(Customer customer)
		{
			try
			{
				System.out.println("Customer object\n" + customer + "sent to Server");
				objectOutputStream.writeObject(customer);
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		public void sendStaff(Staff staff)
		{
			try
			{
				System.out.println("Object\n" + complaint + "sent to Server");
				objectOutputStream.writeObject(complaint);
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		public void sendInteger(int id)
		{
			try
			{
				System.out.println("ID# '" + id + "' sent to Server");
				objectOutputStream.writeObject(id);
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
	}
