package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Client;
import generalinfo.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declare text fields for access by the clear button action
    private JTextField custIdField, companyField, contactPersonField, address1Field, address2Field, postOfficeField, parishField, telephoneField, emailField, balanceField, statusField;
    

    public CustomerWindow() {
        super("Customer Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(14, 2)); // Adjust grid layout for buttons
        
        // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
        Color Red = new Color(255, 0, 0);
        Color inputFieldBorderColor = new Color(0, 0, 128); // A contrasting border color
        Color royalBlue = new Color(65, 105, 225);
        Color navyBlue = new Color(0, 0, 128);
        

        // Set background color to a light blue - skyBlue
        getContentPane().setBackground(skyBlue);

        // Initialize text fields
        custIdField = new JTextField(10);
        companyField = new JTextField(10);
        contactPersonField = new JTextField(10);
        address1Field = new JTextField(10);
        address2Field = new JTextField(10);
        postOfficeField = new JTextField(10);
        parishField = new JTextField(10);
        telephoneField = new JTextField(10);
        emailField = new JTextField(10);
        balanceField = new JTextField(10);
        statusField = new JTextField(10);

        // Add labels and text fields to the form
        add(new JLabel("Customer ID"));
        add(custIdField);

        add(new JLabel("Company Name"));
        add(companyField);

        add(new JLabel("Contact Person"));
        add(contactPersonField);

        add(new JLabel("Address 1"));
        add(address1Field);

        add(new JLabel("Address 2"));
        add(address2Field);
        
        add(new JLabel("Post Office"));
        add(postOfficeField);
        
        add(new JLabel("Parish"));
        add(parishField);
        
        add(new JLabel("Telephone"));
        add(telephoneField);
        
        add(new JLabel("Email"));
        add(emailField);
        
        add(new JLabel("Balance"));
        add(balanceField);
        
        add(new JLabel("Status"));
        add(statusField);

        // Create submit button
        JButton addButton = new JButton("Add");
        addButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// Handle submission logic here
            	
            	Customer obj1 = new Customer();//Imported from generalinfo 	
            	Client client = new Client();
            
            	//Send to server
            	// Added
            
            	int custID = Integer.parseInt(custIdField.getText());//convert string to an integer
            	obj1.setCustId(custID);
            	obj1.setCompany(companyField.getText());
            	obj1.setContactPerson(contactPersonField.getText());
            	obj1.setCustAddress1(address1Field.getText());
            	obj1.setCustAddress2(address2Field.getText());
            	obj1.setCustPostOffice(postOfficeField.getText());
            	obj1.setCustParish(parishField.getText());
            	obj1.setCustTelephone(telephoneField.getText());
            	obj1.setCustEmail(emailField.getText());

            	float balance = Float.parseFloat(balanceField.getText());
            	obj1.setCustBalance(balance);
            	
            	boolean status = parseBoolean(statusField.getText()); // convert text to boolean
            	obj1.setCustStatus(status);
            	
            	client.sendAction("Add Customer");
            	client.sendCustomer(obj1);
            	
            	boolean added = client.addedSuccessful();
            	
            	if(added) {
            		JOptionPane.showMessageDialog(null, "Customer added Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Customer was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            	
            	client.closeConnection();
            }
            private boolean parseBoolean(String text) {
				// TODO Auto-generated method stub
				return false;
			}
        });

        // Create clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        clearButton.setForeground(Color.WHITE); // Set text color to white
        clearButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                custIdField.setText("");
                companyField.setText("");
                contactPersonField.setText("");
                address1Field.setText("");
                address2Field.setText("");
                postOfficeField.setText("");
                parishField.setText("");
                telephoneField.setText("");
                emailField.setText("");
                balanceField.setText("");
                statusField.setText("");
            }
        });
      //Update
        //Retrieve 1
        JButton getByID = new JButton("Retrieve");
        getByID.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        getByID.setForeground(Color.WHITE); // Set text color to white
        getByID.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        getByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Customer obj1 = new Customer();
            	
            	int custId = Integer.parseInt(custIdField.getText());
            	Client client = new Client();
            	client.sendAction("Find Customer");
            	client.sendCustomerId(custId);
            	obj1 = client.receiveResponse1();
              
        		custIdField.setText(String.valueOf(obj1.getCustId()));
                companyField.setText(obj1.getCompany());
                contactPersonField.setText(obj1.getContactPerson());
                address1Field.setText(obj1.getCustAddress1());
                address2Field.setText(obj1.getCustAddress2());
                postOfficeField.setText(obj1.getCustPostOffice());
                parishField.setText(obj1.getCustParish());
                telephoneField.setText(obj1.getCustTelephone());
                emailField.setText(obj1.getCustEmail());
                balanceField.setText(String.valueOf(obj1.getCustBalance()));
                statusField.setText(String.valueOf(obj1.getCustStatus()));
            }
        });
      //Retrieve all
        //Delete
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(Red); // Set button color to a darker blue - steelBlue
        deleteButton.setForeground(Color.WHITE); // Set text color to white
        deleteButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
               
                String id  =  custIdField.getText() ;
                Client client = new Client();
                client.sendAction("Delete Customer");
                client.sendCustomerId(Integer.parseInt(id));
                
                custIdField.setText("");
                companyField.setText("");
                contactPersonField.setText("");
                address1Field.setText("");
                address2Field.setText("");
                postOfficeField.setText("");
                parishField.setText("");
                telephoneField.setText("");
                emailField.setText("");
                statusField.setText("");
                
                JOptionPane.showMessageDialog(custIdField, this, "Customer deleted successfully!", getDefaultCloseOperation());
              
//                try {
//                	int num_id= Integer.parseInt(id);
//                	System.out.println("Deleted cust #"+num_id);
//                	custIdField.setText("");
//                }catch (NumberFormatException err) {
//                	JOptionPane.showMessageDialog(custIdField, this, "Please Enter a vaild Id", getDefaultCloseOperation());
//                	System.out.println("Number Format ERROR");
//                	custIdField.setText("");
//                }catch(Exception err) {
//            		err.getMessage();
//            	}
            	
            	//Send to server
            	// ID
            	// Deleted
            	
            	// clearButton.action(null, deleteButton)
            }
        });
        
      //Update
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        updateButton.setForeground(Color.WHITE); // Set text color to white
        updateButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Customer obj1 = new Customer();//Imported from generalinfo
           	 	Client client = new Client();
           	 
           	int custID = Integer.parseInt(custIdField.getText());//convert string to an integer
           	obj1.setCustId(custID);
           	
            obj1.setCompany(companyField.getText());            
            obj1.setContactPerson(contactPersonField.getText());
            obj1.setCustAddress1(address1Field.getText());
            obj1.setCustAddress2(address2Field.getText());
            obj1.setCustPostOffice(postOfficeField.getText());
            obj1.setCustParish(parishField.getText());
            obj1.setCustTelephone(telephoneField.getText());
            obj1.setCustEmail(emailField.getText());
            
            float balance = Float.parseFloat(balanceField.getText()); // convert text to float
           	obj1.setCustBalance(balance); 
            
            boolean status = parseBoolean(statusField.getText()); // convert text to boolean
           	obj1.setCustStatus(status);          	
         
           	
           	client.sendAction("Update Customer");
           	client.sendCustomer(obj1);
           	
           	boolean added = client.addedSuccessful();
           	
           	if(added) {
           		JOptionPane.showMessageDialog(null, "Customer added Updated Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
           	}
           	else {
           		JOptionPane.showMessageDialog(null, "Customer was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
           	}
               

//               JOptionPane.showMessageDialog(null, "Submission Successful!");
               client.closeConnection();
           }

			

			private boolean parseBoolean(String text) {
				// TODO Auto-generated method stub
				return false;
			}
			
       });
        

        // Add buttons to the form
        add(addButton);
        add(updateButton);
        add(getByID);
        add(clearButton);
        add(deleteButton);

        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerWindow();
    }
}