package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffWindow extends JFrame {
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
                // Handle submission logic here
            	
            	//Send to server
            	// Added
            	
            	// Fields:
            	
            	// staffIdField.setText("");
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
                // Clear all text fields
               
            	String[] person = {"7777", "JOhn", "Wick", "12/25/0000", "Pound Town","USA", "USA223", "Florida", "18007774463", "email.com", "Admin","active" };
                String id  =  staffIdField.getText() ;
              
                try {
                	int num_id= Integer.parseInt(id);
                	int check_id = Integer.parseInt(person[0]);
                	if(num_id == check_id ) {
                		staffIdField.setText(person[0]);
                        firstNameField.setText(person[1]);
                        lastNameField.setText(person[2]);
                        dobField.setText(person[3]);
                        address1Field.setText(person[4]);
                        address2Field.setText(person[5]);
                        postOfficeField.setText(person[6]);
                        parishField.setText(person[7]);
                        telephoneField.setText(person[8]);
                        emailField.setText(person[9]);
                        positionField.setText(person[10]);
                        statusField.setText(person[11]);
                	}
                	System.out.println("Get user #"+num_id);
                }catch (NumberFormatException err) {
                	JOptionPane.showMessageDialog(staffIdField, "Please Enter a vaild Id", "Number Format Error", getDefaultCloseOperation());
                	System.out.println("Number Format ERROR");
                	staffIdField.setText("");
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
               
                String id  =  staffIdField.getText() ;
              
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
        new StaffWindow();
    }
}