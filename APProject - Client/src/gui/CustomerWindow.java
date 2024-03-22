package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Client;
import generalinfo.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerWindow extends JFrame {
    // Declare text fields for access by the clear button action
    private JTextField custIdField, companyField, contactPersonField, address1Field, address2Field, postOfficeField, parishField, telephoneField, emailField;
    private JRadioButton statusField;

    public CustomerWindow() {
        super("Customer Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(12, 2)); // Adjust grid layout for buttons
        
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
        statusField = new JRadioButton();

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
            	
            	Client client = new Client();            	
            	Customer customer = new Customer();
            
            	//Send to server
            	// Added
            
            	int id = Integer.parseInt( custIdField.getText());
            	customer.setCustId(id);
            	customer.setCompany(companyField.getText());
            	customer.setContactPerson(contactPersonField.getText());
            	customer.setCustAddress1(address1Field.getText());
            	customer.setCustAddress1(address2Field.getText());
            	customer.setCustPostOffice(postOfficeField.getText());
            	customer.setCustParish(parishField.getText());
            	customer.setCustTelephone(telephoneField.getText());
            	customer.setCustEmail(emailField.getText());
            	customer.setCustStatus(true);
            	
            	
//            	custIdField = new JTextField(10);
//                companyField = new JTextField(10);
//                contactPersonField = new JTextField(10);
//                address1Field = new JTextField(10);
//                address2Field = new JTextField(10);
//                postOfficeField = new JTextField(10);
//                parishField = new JTextField(10);
//                telephoneField = new JTextField(10);
//                emailField = new JTextField(10);
//                statusField = new JTextField(10);
            	
            	//name
            	//last name
            	
            	client.sendAction("Add Customer");
            	client.sendCustomer(customer);
            	
            	client.receiveResponse();            	
            	// firstNameField.setText("");
            	// lastNameField.setText("");
            	// dobField.setText("");
				// address1Field.setText("");
				// address2Field.setText("");
				// postOfficeField.setText("");
				// parishField.setText("");
				// telephoneField.setText("");
				// emailField.setText("");
				// positionField.setText("");
				// statusField.setText("");
                // Handle submission logic here
                JOptionPane.showMessageDialog(null, "Submission Successful!");
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
                // Clear all text fields
               
            	String[] person = {"6666", "USPS", "Chris", "Brookville Town", "USA", "Tampa", "Florida", "8763039148", "email.com", "active" };
                String id  =  custIdField.getText() ;
              
                try {
                	int num_id= Integer.parseInt(id);
                	int check_id = Integer.parseInt(person[0]);
                	if(num_id == check_id ) {
                		custIdField.setText(person[0]);
                        companyField.setText(person[1]);
                        contactPersonField.setText(person[2]);
                        address1Field.setText(person[3]);
                        address2Field.setText(person[4]);
                        postOfficeField.setText(person[5]);
                        parishField.setText(person[6]);
                        telephoneField.setText(person[7]);
                        emailField.setText(person[8]);
                        statusField.setText(person[9]);
                	}
                	System.out.println("Get cust #"+num_id);
                }catch (NumberFormatException err) {
                	JOptionPane.showMessageDialog(custIdField, "Please Enter a vaild Id", "Number Format Error", getDefaultCloseOperation());
                	System.out.println("Number Format ERROR");
                	custIdField.setText("");
                }catch(Exception err) {
            		err.getMessage();
            	}
            	
            	//Send to server
            	// ID
            	// Deleted
            	
            	// clearButton.action(null, deleteButton)
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
              
                try {
                	int num_id= Integer.parseInt(id);
                	System.out.println("Deleted cust #"+num_id);
                	custIdField.setText("");
                }catch (NumberFormatException err) {
                	JOptionPane.showMessageDialog(custIdField, this, "Please Enter a vaild Id", getDefaultCloseOperation());
                	System.out.println("Number Format ERROR");
                	custIdField.setText("");
                }catch(Exception err) {
            		err.getMessage();
            	}
            	
            	//Send to server
            	// ID
            	// Deleted
            	
            	// clearButton.action(null, deleteButton)
            }
        });
        

        // Add buttons to the form
        add(addButton);
        add(getByID);
        add(deleteButton);
        add(clearButton);

        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerWindow();
    }
}