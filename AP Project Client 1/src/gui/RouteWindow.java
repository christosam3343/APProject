package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.Client;
import generalinfo.Customer;
import generalinfo.RouteRates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

// RouteWindow class extending JFrame and implementing Serializable
public class RouteWindow extends JFrame implements Serializable
	    // Serial version UID for serialization
{
	private static final long serialVersionUID = 1L;
	// Declare text fields for access by the clear button action
    private JTextField routeNameField, sourceField, destinationField, rateField;
	// Logger for logging messages
    private final Logger logger = LogManager.getLogger(RouteWindow.class);


        // Constructor for RouteWindow
	public RouteWindow() 
	{
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
        JButton addButton = new JButton("Add");
        addButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission logic here
		// Logging and validation
            	// Creating RouteRates object
            	RouteRates obj1 = new RouteRates(); //Imported from generalinfo 	
            	Client client = new Client();

		// Getting input from text fields
            	String routeName = routeNameField.getText();
            	String source = sourceField.getText();
            	String destination = destinationField.getText();
            	String rate1 = rateField.getText();
		    
            	// Validating input fields
                // Display error messages if input is invalid
            	if (!routeName.matches("[A-Z]-[A-Z]")) {
            	    JOptionPane.showMessageDialog(null, "Please Enter a Valid Route name in the format 'A-B'", "Message", JOptionPane.INFORMATION_MESSAGE);
            	    logger.info("User entered an invalid route name: " + routeName);
            	    return;
            	}
            	if(!(source.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Source Address", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid Source Address");
                	return;
                }
            	if(!(destination.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Destination Address", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid Destination Address");
                	return;
                }
            	if (!(rate1.matches("\\d+(\\.\\d+)?"))) {
                    JOptionPane.showMessageDialog(null, "Please Enter A Valid Rate", "Message", JOptionPane.INFORMATION_MESSAGE);
                    logger.info("User entered an rate");
                    return;
                }
            	
            	
            	// Set data to RouteRates object
            	obj1.setrouteName(routeNameField.getText());
            	obj1.setSource(sourceField.getText());
            	obj1.setDestination(destinationField.getText());
            	double rate = Double.parseDouble(rateField.getText());
            	obj1.setRate(rate);
            	
            	// Sending data to the server
		client.sendAction("Add Route");
            	client.sendRouteRates(obj1);
	
            	// Check if addition was successful
            	boolean added = client.addedSuccessful();
            	if(added) {
            		JOptionPane.showMessageDialog(null, "Route added Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Route was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            	
            	client.closeConnection(); // Close Connection
            }
            private boolean parseBoolean(String text) 
		{
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
            	routeNameField.setText("");
            	sourceField.setText("");
            	destinationField.setText("");
            	rateField.setText("");
            }
        });
        
        // Create retrieve button
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
            	client.sendAction("Find Route");
            	client.sendRouteName(routeName);
            	obj1 = (RouteRates) client.receiveResponse();
              
            	routeNameField.setText(obj1.getrouteName());
            	sourceField.setText(obj1.getSource());
            	destinationField.setText(obj1.getDestination());
            	rateField.setText(String.valueOf(obj1.getRate()));
            }
        });
        
        // Create delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(Red); // Set button color to a darker blue - steelBlue
        deleteButton.setForeground(Color.WHITE); // Set text color to white
        deleteButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        	 // Delete route and clear text fields

                String routeName  =  routeNameField.getText() ;
                Client client = new Client();
                client.sendAction("Delete Route");
                client.sendRouteName(routeName);
                
                routeNameField.setText("");
                sourceField.setText("");
                routeNameField.setText("");
                rateField.setText("");
                
                JOptionPane.showMessageDialog(routeNameField, this, "Route and Rates deleted successfully!", getDefaultCloseOperation());
            }
        });
        
	// Create update button
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
            obj1.setDestination(destinationField.getText());
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
               
               client.closeConnection(); // Close Connection
           }

			
			
       });

        // Add buttons to the form
        add(addButton);
        add(updateButton);
        add(getByID);
        add(clearButton);
        add(deleteButton);

        pack(); // Adjusts window size to fit all components
        setVisible(true); // Set window visibility
    }

        // Main method
	public static void main(String[] args) 
	{
        new RouteWindow(); // Create an instance of RouteWindow
    }
}
