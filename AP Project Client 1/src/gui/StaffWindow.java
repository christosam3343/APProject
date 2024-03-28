package gui;
import javax.swing.*;
import java.util.regex.*;
import javax.swing.border.LineBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getLogger(StaffWindow.class);
    
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
        dobField.setText("yyyy-MM-dd");
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
            	// Check the Inputs
            	Staff obj1 = new Staff();//Imported from generalinfo
            	Client client = new Client();
            	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            	// Regular expression pattern for the date format yyyy-MM-dd
                String pattern = "\\d{4}-\\d{2}-\\d{2}";

                // Compile the pattern into a regular expression
                Pattern regex = Pattern.compile(pattern);

                String[] parishes = {
                        "Kingston", "St. Andrew", "St. Thomas", "Portland", "St. Mary",
                        "St. Ann", "Trelawny", "St. James", "Hanover", "Westmoreland",
                        "St. Elizabeth", "Manchester", "Clarendon", "St. Catherine"
                };
                
            	
            	int staffID;
                String fname = firstNameField.getText();
                String lname = lastNameField.getText(); 
            	String dateOfBirth = dobField.getText();
            	
                String address1 =address1Field.getText(); 
                String address2 =address2Field.getText(); 
                String post =postOfficeField.getText(); 
                String parish = parishField.getText(); 
                String telephone = telephoneField.getText(); 
                String email = emailField.getText(); 
                String position = positionField.getText();
                String status =  statusField.getText();
                int booleanCheck;
               
                try {
                	
                	staffID = Integer.parseInt(staffIdField.getText());
                	
                }
                catch(NumberFormatException err){
                	JOptionPane.showMessageDialog(null, "Please Enter A Vaild Id", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.error("User entered the invalid id: " + err.getMessage());
                	return;
                }
                
                if(!(fname.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A First name", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid id");
                	return;
                }
                if(!(lname.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Last name", "Message", JOptionPane.INFORMATION_MESSAGE);
                	return;
                }
                // Create a Matcher object to match the pattern against the input string
                Matcher matcher = regex.matcher(dateOfBirth);
            	if(!(matcher.matches())) {
        			JOptionPane.showMessageDialog(null, "Please Enter in format yyyy-MM-dd", "Message", JOptionPane.INFORMATION_MESSAGE);
        			return;
        		}
               if(address1.isEmpty()) {
            	   JOptionPane.showMessageDialog(null, "Please Enter an Address1", "Message", JOptionPane.INFORMATION_MESSAGE);
               	return;
               }
               if(address2.isEmpty()) {
            	   JOptionPane.showMessageDialog(null, "Please Enter an Address2", "Message", JOptionPane.INFORMATION_MESSAGE);
               	return;
               }
                if(!(post.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Postoffice", "Message", JOptionPane.INFORMATION_MESSAGE);
                	return;
                }
                // Flag to track if the string is found
                boolean found = false;
                
                // Iterate through the array to search for the string
                for (String parish_ : parishes) {
                    if (parish_.equals(parish)) {
                        found = true;
                        break; // Exit the loop once the string is found
                    }
                }
                if (!found) {
                	JOptionPane.showMessageDialog(null, "Please Enter a Vaild Parish", "Message", JOptionPane.INFORMATION_MESSAGE);
                	return;
                } 
                if(!(parish.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Vaild Parish", "Message", JOptionPane.INFORMATION_MESSAGE);
                	return;
                }
//                try {
//           
//                	int tele = Integer.parseInt(telephone);          
//                	System.out.print(tele);
//                }
//                catch(NumberFormatException err){
//                	JOptionPane.showMessageDialog(null, "Please Enter A Vaild Phone Number", "Message", JOptionPane.INFORMATION_MESSAGE);
//                	err.printStackTrace();
//                	return;
//                }catch(Exception e1 ) {
//            		JOptionPane.showMessageDialog(null, "Universal", "Message", JOptionPane.INFORMATION_MESSAGE);
//            		e1.printStackTrace();
//            		return;
//            	}
//                int length = telephone.length();
            	// Check if the length is either 10 or 7 digits
//                if(!telephone.matches("\\\\d+")) {
//                	JOptionPane.showMessageDialog(null, "Please Enter A Vaild Phone Number", "Message", JOptionPane.INFORMATION_MESSAGE);
//                }
////                if (!(telephone.length() == 7 || telephone.length() == 10)) {
////            		JOptionPane.showMessageDialog(null, "Please Enter A Vaild Phone Number", "Message", JOptionPane.INFORMATION_MESSAGE);
////                } 
//                if (!(telephone.length() == 7) || !(telephone.length() == 10)) {
//                	JOptionPane.showMessageDialog(null, "Please Enter 10 or 7 Digits", "Message", JOptionPane.INFORMATION_MESSAGE);
//                	return;
//                }
                
                String emailPattern = "^[A-Za-z][A-Za-z0-9_]*@[A-Za-z]+\\.com$";
                if(!(email.matches(emailPattern))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Vaild Email", "Message", JOptionPane.INFORMATION_MESSAGE);
                	return;
                }
                if(!(position.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Position", "Message", JOptionPane.INFORMATION_MESSAGE);
                	return;
                }
                           
                       
                try {
                	booleanCheck  = Integer.parseInt(statusField.getText());
                	
                	if (booleanCheck != 1 || booleanCheck != 0 ) {
                     	JOptionPane.showMessageDialog(null, "Please Enter 1 or 0 for True or False", "Message", JOptionPane.INFORMATION_MESSAGE);
                     	return;
                     }
                	
                }
                catch(NumberFormatException err){
                	logger.error("Error: " + err.getMessage());
                	err.printStackTrace();
                	return;
                }
                
                
                
                
            	obj1.setStaffID(Integer.parseInt(staffIdField.getText()));
            	obj1.setstaffFirstName(firstNameField.getText());
            	obj1.setstaffLastName(lastNameField.getText());
            	try{            		
            		obj1.setstaffDob(inputFormat.parse(dateOfBirth));
            	}
            	catch(Exception e1 ) {
            		logger.error("Error: " + e1.getMessage());
            		e1.printStackTrace();
            		return;
            	}
            	obj1.setstaffAddress1(address1Field.getText());
            	obj1.setstaffAddress2(address2Field.getText());
            	obj1.setstaffPostOffice(postOfficeField.getText());
            	obj1.setstaffParish(parishField.getText());
            	obj1.setstaffTelephone(telephoneField.getText());
            	obj1.setstaffEmail(emailField.getText());
            	obj1.setstaffPosition(positionField.getText());
            	
//            	boolean status = parseBoolean(statusField.getText()); // convert text to boolean
//            	if(sta)
            	obj1.setstaffStatus(Integer.parseInt(statusField.getText()));
          
            	
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
            	obj1 = (Staff) client.receiveResponse();
            	
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
           	obj1.setstaffStatus(Integer.parseInt(statusField.getText()));
         
           	
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