package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Client;
import generalinfo.Customer;
import generalinfo.RouteRates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class RouteWindow extends JFrame implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declare text fields for access by the clear button action
    private JTextField routeNameField, sourceField, destinationField, rateField;

    public RouteWindow() {
        super("Route Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(7, 2)); // Adjust grid layout for buttons
        
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
        routeNameField = new JTextField(10);
        sourceField = new JTextField(10);
        destinationField = new JTextField(10);
        rateField = new JTextField(10);

        // Add labels and text fields to the form
        add(new JLabel("Route Name"));
        add(routeNameField);

        add(new JLabel("Source"));
        add(sourceField);

        add(new JLabel("Destination"));
        add(destinationField);

        add(new JLabel("Rate"));
        add(rateField);

        // Create submit button
        JButton submitButton = new JButton("Add");
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
            	routeNameField.setText("");
            	sourceField.setText("");
            	destinationField.setText("");
            	rateField.setText("");
            }
        });
        
      //Retrieve 1
        JButton getByID = new JButton("Retrieve");
        getByID.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        getByID.setForeground(Color.WHITE); // Set text color to white
        getByID.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        getByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	RouteRates obj1 = new RouteRates();
            	
            	String routeName = routeNameField.getText();
            	Client client = new Client();
            	client.sendAction("Find Route and Rates");
            	client.sendRouteName1(routeName);
            	obj1 = client.receiveResponse3();
              
            	routeNameField.setText(obj1.getrouteName());
            	sourceField.setText(obj1.getSource());
            	destinationField.setText(obj1.getDestination());
            	rateField.setText(String.valueOf(obj1.getRate()));
            }
        });
        
      //Delete
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(Red); // Set button color to a darker blue - steelBlue
        deleteButton.setForeground(Color.WHITE); // Set text color to white
        deleteButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
               
                String routeName  =  routeNameField.getText() ;
                Client client = new Client();
                client.sendAction("Delete Route and Rates");
                client.sendRouteName1(routeName);
                
                routeNameField.setText("");
                sourceField.setText("");
                routeNameField.setText("");
                rateField.setText("");
                
                JOptionPane.showMessageDialog(routeNameField, this, "Route and Rates deleted successfully!", getDefaultCloseOperation());
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
            	RouteRates obj1 = new RouteRates();//Imported from generalinfo
           	 	Client client = new Client();
           	 

           	obj1.setrouteName(routeNameField.getText());
            obj1.setSource(sourceField.getText());            
            obj1.setDestination(routeNameField.getText());
            float rate = Float.parseFloat(rateField.getText()); // convert text to float
           	obj1.setRate(rate); 
            
           	client.sendAction("Update Route");
           	client.sendRouteRates(obj1);
           	
           	boolean added = client.addedSuccessful();
           	
           	if(added) {
           		JOptionPane.showMessageDialog(null, "Route and Rates added Updated Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
           	}
           	else {
           		JOptionPane.showMessageDialog(null, "Route and Rates was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
           	}
               

//               JOptionPane.showMessageDialog(null, "Submission Successful!");
               client.closeConnection();
           }

			
			
       });

        // Add buttons to the form
        add(submitButton);
        add(updateButton);
        add(getByID);
        add(clearButton);
        add(deleteButton);

        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }

    public static void main(String[] args) {
        new RouteWindow();
    }
}
