package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouteWindow extends JFrame {
    // Declare text fields for access by the clear button action
    private JTextField staffIdField, firstNameField, lastNameField, dobField, address1Field, address2Field, postOfficeField, parishField, telephoneField, emailField, positionField, statusField;

    public RouteWindow() {
        super("Route Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(13, 2)); // Adjust grid layout for buttons
        
     // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
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

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        submitButton.setForeground(Color.WHITE); // Set text color to white
        submitButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        // Add buttons to the form
        add(submitButton);
        add(clearButton);

        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }

    public static void main(String[] args) {
        new RouteWindow();
    }
}
