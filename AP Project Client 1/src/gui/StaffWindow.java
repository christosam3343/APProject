package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Client;
import generalinfo.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaffWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declare text fields for access by the clear button action
    private JTextField staffIdField, firstNameField, lastNameField, dobField, address1Field, address2Field, postOfficeField, parishField, telephoneField, emailField, positionField, statusField;

    public StaffWindow() {
        super("Staff Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(15, 2)); // Adjust grid layout for buttons
        
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
        staffIdField = new JTextField(10);       
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        dobField = new JTextField(10);
        address1Field = new JTextField(10);
        address2Field = new JTextField(10);
        postOfficeField = new JTextField(10);
        parishField = new JTextField(10);
        telephoneField = new JTextField(10);
        emailField = new JTextField(10);
        positionField = new JTextField(10);
        statusField = new JTextField(10);

        // Add labels and text fields to the form
        add(new JLabel("Staff ID"));
        add(staffIdField);
        

        add(new JLabel("First Name"));
        add(firstNameField);

        add(new JLabel("Last Name"));
        add(lastNameField);

        add(new JLabel("DOB"));
        add(dobField);

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
        
        add(new JLabel("Position"));
        add(positionField);
        
        add(new JLabel("Status"));
        add(statusField);

        //Create
        // Create submit button
        JButton addButton = new JButton("Add");
        addButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Staff obj1 = new Staff();//Imported from generalinfo
            	 Client client = new Client();
            	 
            	int staffID = Integer.parseInt(staffIdField.getText());//convert string to an integer
            	obj1.setStaffID(staffID);
            	
            	obj1.setstaffFirstName(firstNameField.getText());
            	obj1.setstaffLastName(lastNameField.getText());
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
       
            	
            	String dateOfBirth = dobField.getText();
            	try{
 
            		obj1.setstaffDob(inputFormat.parse(dateOfBirth));
            		
            	}
            	catch(Exception e1 ) {
            		e1.printStackTrace();
            	}
            	
       
            	obj1.setstaffAddress1(address1Field.getText());
            	obj1.setstaffAddress2(address2Field.getText());
            	obj1.setstaffPostOffice(postOfficeField.getText());
            	obj1.setstaffParish(parishField.getText());
            	obj1.setstaffTelephone(telephoneField.getText());
            	obj1.setstaffEmail(emailField.getText());
            	obj1.setstaffPosition(positionField.getText());
            	
            	boolean status = parseBoolean(statusField.getText()); // convert text to boolean
            	obj1.setstaffStatus(status);
          
            	
            	client.sendAction("Add Staff");
            	client.sendStaff(obj1);
            	
            	boolean added = client.addedSuccessful();
            	
            	if(added) {
            		JOptionPane.showMessageDialog(null, "Staff added Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Staff was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
            	}
                

//                JOptionPane.showMessageDialog(null, "Submission Successful!");
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
                staffIdField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                dobField.setText("");
                address1Field.setText("");
                address2Field.setText("");
                postOfficeField.setText("");
                parishField.setText("");
                telephoneField.setText("");
                emailField.setText("");
                positionField.setText("");
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
            	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            	Staff obj1 = new Staff();
            	
            	int staffID = Integer.parseInt(staffIdField.getText());
            	Client client = new Client();
            	client.sendAction("Find Staff");
            	client.sendStaffId(staffID);
            	obj1 = client.receiveResponse();
            	
            	staffIdField.setText(String.valueOf(obj1.getStaffID()));
                firstNameField.setText(obj1.getstaffFirstName());
                lastNameField.setText(obj1.getstaffLastName());
            	dobField.setText(inputFormat.format(obj1.getstaffDob()));
                address1Field.setText(obj1.getstaffAddress1());
                address2Field.setText(obj1.getstaffAddress2());
                postOfficeField.setText(obj1.getstaffPostOffice());
                parishField.setText(obj1.getstaffParish());
                telephoneField.setText(obj1.getstaffTelephone());
                emailField.setText(obj1.getstaffEmail());
                positionField.setText(obj1.getstaffPosition());
                statusField.setText(String.valueOf(obj1.getstaffStatus()));
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
               
                String id  =  staffIdField.getText() ;
                Client client = new Client();
                client.sendAction("Delete Staff");
                client.sendStaffId(Integer.parseInt(id));
                
                staffIdField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                dobField.setText("");
                address1Field.setText("");
                address2Field.setText("");
                postOfficeField.setText("");
                parishField.setText("");
                telephoneField.setText("");
                emailField.setText("");
                positionField.setText("");
                statusField.setText("");
            
                
                JOptionPane.showMessageDialog(staffIdField, this, "Staff member deleted successfully!", getDefaultCloseOperation());
              /*
                try {
                	int num_id= Integer.parseInt(id);
                	System.out.println("Deleted user #"+num_id);
                	staffIdField.setText("");
                }catch (NumberFormatException err) {
                	JOptionPane.showMessageDialog(staffIdField, this, "Please Enter a vaild Id", getDefaultCloseOperation());
                	System.out.println("Number Format ERROR");
                	staffIdField.setText("");
                }catch(Exception err) {
            		err.getMessage();
            	}
            	
            	//Send to server
            	// ID
            	// Deleted */
            	
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
            	Staff obj1 = new Staff();//Imported from generalinfo
           	 	Client client = new Client();
           	 
           	int staffID = Integer.parseInt(staffIdField.getText());//convert string to an integer
           	obj1.setStaffID(staffID);
           	
           	obj1.setstaffFirstName(firstNameField.getText());
           	obj1.setstaffLastName(lastNameField.getText());
               SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
      
           	
           	String dateOfBirth = dobField.getText();
           	try{

           		obj1.setstaffDob(inputFormat.parse(dateOfBirth));
           		
           	}
           	catch(Exception e1 ) {
           		e1.printStackTrace();
           	}
           	
      
           	obj1.setstaffAddress1(address1Field.getText());
           	obj1.setstaffAddress2(address2Field.getText());
           	obj1.setstaffPostOffice(postOfficeField.getText());
           	obj1.setstaffParish(parishField.getText());
           	obj1.setstaffTelephone(telephoneField.getText());
           	obj1.setstaffEmail(emailField.getText());
           	obj1.setstaffPosition(positionField.getText());
           	
           	boolean status = parseBoolean(statusField.getText()); // convert text to boolean
           	obj1.setstaffStatus(status);
         
           	
           	client.sendAction("Update Staff");
           	client.sendStaff(obj1);
           	
           	boolean added = client.addedSuccessful();
           	
           	if(added) {
           		JOptionPane.showMessageDialog(null, "Staff added Updated Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
           	}
           	else {
           		JOptionPane.showMessageDialog(null, "Staff was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
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
        new StaffWindow();
    }
}