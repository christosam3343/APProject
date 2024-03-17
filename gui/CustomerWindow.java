package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerWindow extends JFrame {
    // Declare text fields for access by the clear button action
    private JTextField custIdField, companyField, contactPersonField, address1Field, address2Field, postOfficeField, parishField, telephoneField, emailField, statusField;

    public CustomerWindow() {
        super("Customer Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(11, 2)); // Adjust grid layout for buttons

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
        
        add(new JLabel("Status"));
        add(statusField);

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission logic here
                JOptionPane.showMessageDialog(null, "Submission Successful!");
            }
        });

        // Create clear button
        JButton clearButton = new JButton("Clear");
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

        // Add buttons to the form
        add(submitButton);
        add(clearButton);

        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerWindow();
    }
}