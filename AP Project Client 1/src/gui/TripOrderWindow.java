package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.Client;
import generalinfo.Customer;
import generalinfo.RouteRates;
import generalinfo.TripOrder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class TripOrderWindow extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declare text fields for access by the clear button action
	private final Logger logger = LogManager.getLogger(TripOrderWindow.class);
    private JTextField invoiceNoField, companyField, sourceAddressField, destinationAddressField, rateField, driverField, billedByField;
    private JComboBox<String> routeNameDropdown;
    private RouteRates[] routeList = {};

    public TripOrderWindow() {
        super("Trip Order Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(11, 2)); // Adjust grid layout for buttons
        
        // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
        Color Red = new Color(255, 0, 0);
        Color inputFieldBorderColor = new Color(0, 0, 128); // A contrasting border color
        Color royalBlue = new Color(65, 105, 225);
        Color navyBlue = new Color(0, 0, 128);
        
        String[] routeStrings = {};
        // get the routes
        try {
        	getRouteRates();
        	String tmp = "";
        	
        	for(RouteRates route : routeList) {
        		tmp += route.getrouteName() + "\n";
        	}
        	
        	routeStrings = tmp.split("\n");
        }
        catch(Exception e) {
        	logger.error("Error: " + e.getMessage());
        }
        
        // Set background color to a light blue - skyBlue
        getContentPane().setBackground(skyBlue);

        // Initialize text fields
        invoiceNoField = new JTextField(10);
        companyField = new JTextField(10);
        sourceAddressField = new JTextField(10);
        sourceAddressField.setEditable(false);
        destinationAddressField = new JTextField(10);
        destinationAddressField.setEditable(false);
        rateField = new JTextField(10);
        rateField.setEditable(false);
        driverField = new JTextField(10);
        billedByField = new JTextField(10);
        routeNameDropdown = new JComboBox<String>(routeStrings);
        routeNameDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Handle submission logic here
//            	JComboBox<String> cb = (JComboBox<String>)e.getSource();
                String rName = (String) routeNameDropdown.getSelectedItem();
                
                for(RouteRates r: routeList) {
                	if(r.getrouteName().equals(rName)) {
                		// populate the fields
                		sourceAddressField.setText(r.getSource());
                		destinationAddressField.setText(r.getDestination());
                		rateField.setText("" + r.getRate());
                		break;
                	}
                }
            }
        });
        
        // populate default dropdown options
//        if(routeList.length > 0) {
//        	sourceAddressField.setText(routeList[0].getSource());
//    		destinationAddressField.setText(routeList[0].getDestination());
//    		rateField.setText("" + routeList[0].getRate());
//        }

        // Add labels and text fields to the form
        add(new JLabel("Invoice No"));
        add(invoiceNoField);
        
        add(new JLabel("Route Name"));
//        add(routeNamefield);
        add(routeNameDropdown);

        add(new JLabel("Company"));
        add(companyField);

        add(new JLabel("Source Address"));
        add(sourceAddressField);

        add(new JLabel("Destination Address"));
        add(destinationAddressField);

        add(new JLabel("Rate"));
        add(rateField);

        add(new JLabel("Driver"));
        add(driverField);
        
        add(new JLabel("Billed By"));
        add(billedByField);       
    
        // Create submit button
        JButton addButton = new JButton("Add");
        addButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Handle submission logic here
            	
            	TripOrder obj1 = new TripOrder();//Imported from generalinfo 	
            	Client client = new Client();
            
            	//Send to server
            	// Added
            
            	obj1.setInvoiceNo(invoiceNoField.getText());
            	obj1.setRouteName((String) routeNameDropdown.getSelectedItem());
            	obj1.setCompany(companyField.getText());
            	obj1.setSourceAddress(sourceAddressField.getText());
            	obj1.setDestinationAddress(destinationAddressField.getText());
            	float rate = Float.parseFloat(rateField.getText());
            	obj1.setRate(rate);
            	obj1.setDriver(driverField.getText());
            	obj1.setBilledBy(billedByField.getText());

            	            	
            	client.sendAction("Add Trip Order");
            	client.sendTripOrder(obj1);
            	boolean added = client.addedSuccessful();
            	
            	if(added) {
            		JOptionPane.showMessageDialog(null, "Trip Order added Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Trip Order was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
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
            	invoiceNoField.setText("");
            	companyField.setText("");
            	sourceAddressField.setText("");
            	destinationAddressField.setText("");
            	rateField.setText("");
            	driverField.setText("");
            	billedByField.setText("");
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
            	TripOrder obj1 = new TripOrder();
            	
            	String invoiceNo = invoiceNoField.getText();
            	Client client = new Client();
            	client.sendAction("Find Trip Order");
            	client.sendRouteName(invoiceNo);
            	obj1 = (TripOrder) client.receiveResponse();
              
            	invoiceNoField.setText(obj1.getInvoiceNo());
            	routeNameDropdown.setSelectedItem(obj1.getRouteName());
            	companyField.setText(obj1.getCompany());
            	sourceAddressField.setText(obj1.getSourceAddress());
            	destinationAddressField.setText(obj1.getDestinationAddress());
            	rateField.setText(String.valueOf(obj1.getRate()));
            	driverField.setText(obj1.getDriver());
            	billedByField.setText(obj1.getBilledBy());
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
               
                String invoiceNo  =  invoiceNoField.getText() ;
                Client client = new Client();
                client.sendAction("Delete Trip Order");
                client.sendRouteName(invoiceNo);
                
                invoiceNoField.setText("");
                companyField.setText("");
                sourceAddressField.setText("");
                destinationAddressField.setText("");
                rateField.setText("");
                driverField.setText("");
                billedByField.setText("");
                
                JOptionPane.showMessageDialog(null, this, "Trip Order deleted successfully!", getDefaultCloseOperation());
              
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
            	TripOrder obj1 = new TripOrder();//Imported from generalinfo
           	 	Client client = new Client();
           	           	
           	
            obj1.setInvoiceNo(invoiceNoField.getText());       
            obj1.setRouteName((String) routeNameDropdown.getSelectedItem());
            obj1.setCompany(companyField.getText());
            obj1.setSourceAddress(sourceAddressField.getText());
            obj1.setDestinationAddress(destinationAddressField.getText());
//            obj1.setRate(rateField.getText());
            obj1.setDriver(driverField.getText());
            obj1.setBilledBy(billedByField.getText());
            
            float rate = Float.parseFloat(rateField.getText()); // convert text to float
           	obj1.setRate(rate);         
                  	
         
           	
           	client.sendAction("Update Trip Order");
           	client.sendTripOrder(obj1);
           	
           	boolean added = client.addedSuccessful();
           	
           	if(added) {
           		JOptionPane.showMessageDialog(null, "Trip Order added Updated Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
           	}
           	else {
           		JOptionPane.showMessageDialog(null, "Trip Order was not added Successful", "Error", JOptionPane.ERROR_MESSAGE);
           	}
               

//               JOptionPane.showMessageDialog(null, "Submission Successful!");
               client.closeConnection();
           }

			private boolean parseBoolean(String text) {
				// TODO Auto-generated method stub
				return false;
			}
			
       });
        
        add(addButton);
        add(updateButton);
        add(getByID);
        add(clearButton);
        add(deleteButton);
        
        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }
    
    void getRouteRates() {
    	Client client = new Client();
    	client.sendAction("Get Routes");
    	routeList = (RouteRates[])client.receiveResponse();
        System.out.println(routeList);
    }

    public static void main(String[] args) {
        new TripOrderWindow();
    }
}
