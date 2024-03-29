package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import generalinfo.Date;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import client.Client;
import generalinfo.Customer;
import generalinfo.RouteRates;
import generalinfo.TripOrder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TripOrderWindow class inherits JFrame
public class TripOrderWindow extends JFrame
{
	// Unique Serialization UID
	private static final long serialVersionUID = 1L;
	// Declare text fields for access by the clear button action
	private final Logger logger = LogManager.getLogger(TripOrderWindow.class);
    private JTextField invoiceNoField, companyField, sourceAddressField, destinationAddressField, rateField, startDateField, endDateField, driverField, billedByField;
    private JComboBox<String> routeNameDropdown;
    private RouteRates[] routeList = {};

    	// Constructor for the TripOrderWindow class
	public TripOrderWindow() {
        super("Trip Order Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(13, 2)); // Adjust grid layout for buttons
        
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
        startDateField = new JTextField(10); 
        endDateField = new JTextField(10);
        driverField = new JTextField(10);
        billedByField = new JTextField(10);
        routeNameDropdown = new JComboBox<String>(routeStrings);
        routeNameDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Handle submission logic here
                String rName = (String) routeNameDropdown.getSelectedItem();
                
                for(RouteRates r: routeList) {
                	if(r.getrouteName().equals(rName)) {
                		// Populate the fields
                		sourceAddressField.setText(r.getSource());
                		destinationAddressField.setText(r.getDestination());
                		rateField.setText("" + r.getRate());
                		break;
                	}
                }
            }
        });

	    
        // Add labels and text fields to the form
        add(new JLabel("Invoice No"));
        add(invoiceNoField);
        
        add(new JLabel("Route Name"));
        add(routeNameDropdown);

        add(new JLabel("Company"));
        add(companyField);

        add(new JLabel("Source Address"));
        add(sourceAddressField);

        add(new JLabel("Destination Address"));
        add(destinationAddressField);

        add(new JLabel("Rate"));
        add(rateField);
        
        add(new JLabel("Start Date"));
        add(startDateField);
        
        add(new JLabel("End Date"));
        add(endDateField);

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
            	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            	// Regular expression pattern for the date format yyyy-MM-dd
            	String pattern = "\\d{4}-\\d{2}-\\d{2}";
            	// Compile the pattern into a regular expression
                Pattern regex = Pattern.compile(pattern);
            
        	// Get input values
            	String invoice = invoiceNoField.getText();
            	String company = companyField.getText();
            	String startDate = startDateField.getText();
            	String endDate = endDateField.getText();
            	String driver = driverField.getText();
            	String billed = billedByField.getText();

            	// Validating input
		if(!(invoice.matches("\\d.*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Invoice Number", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid Invoice Number");
                	return;
                }
            	if(!(company.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Company name", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid Company name");
                	return;
                }
            	// Create a Matcher object to match the pattern against the input string
                Matcher matcher = regex.matcher(startDate);
            	if(!(matcher.matches())) {
        			JOptionPane.showMessageDialog(null, "Please Enter in format yyyy-MM-dd", "Message", JOptionPane.INFORMATION_MESSAGE);
        			return;
        		}
            	// Create a Matcher object to match the pattern against the input string
                Matcher matcher1 = regex.matcher(endDate);
            	if(!(matcher1.matches())) {
        			JOptionPane.showMessageDialog(null, "Please Enter in format yyyy-MM-dd", "Message", JOptionPane.INFORMATION_MESSAGE);
        			return;
        		}
            	if(!(driver.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Driver name", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid Driver name");
                	return;
                }
            	if(!(billed.matches("[A-Za-z].*"))) {
                	JOptionPane.showMessageDialog(null, "Please Enter A Valid Billed By name", "Message", JOptionPane.INFORMATION_MESSAGE);
                	logger.info("User entered the invalid Billed By");
                	return;
                }
            	
            	
            	// Populate TripOrder object
            	obj1.setInvoiceNo(invoiceNoField.getText());
            	obj1.setRouteName((String) routeNameDropdown.getSelectedItem());
            	obj1.setCompany(companyField.getText());
            	obj1.setSourceAddress(sourceAddressField.getText());
            	obj1.setDestinationAddress(destinationAddressField.getText());
            	float rate = Float.parseFloat(rateField.getText());
            	obj1.setRate(rate);
            	
            	
            	try{            		
            		obj1.setStartDate(inputFormat.parse(startDate));
            	}
            	catch(Exception e1 ) {
            		logger.error("Error: " + e1.getMessage());
            		return;
            	}
            	
            	try{            		
            		obj1.setEndDate(inputFormat.parse(endDate));
            	}
            	catch(Exception e1 ) {
            		logger.error("Error: " + e1.getMessage());
            		return;
            	}
            	obj1.setDriver(driverField.getText());
            	obj1.setBilledBy(billedByField.getText());
            	
            	// Generate invoice
		generateInvoice(obj1);
            	            	
            	// Send TripOrder to server
		client.sendAction("Add Trip Order");
            	client.sendTripOrder(obj1);
            	boolean added = client.addedSuccessful();
            	
            	// Show results
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
            	startDateField.setText("");
            	endDateField.setText("");
            	driverField.setText("");
            	billedByField.setText("");
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
            	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            	TripOrder obj1 = new TripOrder();
            	
            	String invoiceNo = invoiceNoField.getText();
            	Client client = new Client();
            	client.sendAction("Find Trip Order");
            	client.sendRouteName(invoiceNo);
            	obj1 = (TripOrder) client.receiveResponse();
              
            	// Populate fields with retrieved data
		invoiceNoField.setText(obj1.getInvoiceNo());
            	routeNameDropdown.setSelectedItem(obj1.getRouteName());
            	companyField.setText(obj1.getCompany());
            	sourceAddressField.setText(obj1.getSourceAddress());
            	destinationAddressField.setText(obj1.getDestinationAddress());
            	rateField.setText(String.valueOf(obj1.getRate()));
            	startDateField.setText(inputFormat.format(obj1.getStartDate()));
            	endDateField.setText(inputFormat.format(obj1.getEndDate()));
            	driverField.setText(obj1.getDriver());
            	billedByField.setText(obj1.getBilledBy());
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
            	startDateField.setText("");
            	endDateField.setText("");
                driverField.setText("");
                billedByField.setText("");
                
                JOptionPane.showMessageDialog(null, this, "Trip Order deleted successfully!", getDefaultCloseOperation());
              
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
            	TripOrder obj1 = new TripOrder();//Imported from generalinfo
           	 	Client client = new Client();
           	           	
           	
            // Populate TripOrder object with updated data
	    obj1.setInvoiceNo(invoiceNoField.getText());       
            obj1.setRouteName((String) routeNameDropdown.getSelectedItem());
            obj1.setCompany(companyField.getText());
            obj1.setSourceAddress(sourceAddressField.getText());
            obj1.setDestinationAddress(destinationAddressField.getText());
            obj1.setDriver(driverField.getText());
            obj1.setBilledBy(billedByField.getText());
            
            float rate = Float.parseFloat(rateField.getText()); // convert text to float
           	obj1.setRate(rate);         
                  	
           	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
           	String startDate = startDateField.getText();
           	String endDate = endDateField.getText();
           	try{            		
        		obj1.setStartDate(inputFormat.parse(startDate));
        	}
        	catch(Exception e1 ) {
        		logger.error("Error: " + e1.getMessage());
        		return;
        	}
        	
        	try{            		
        		obj1.setEndDate(inputFormat.parse(endDate));
        	}
        	catch(Exception e1 ) {
        		logger.error("Error: " + e1.getMessage());
        		return;
        	}
           	
           	// Send updated TripOrder to server
		client.sendAction("Update Trip Order");
           	client.sendTripOrder(obj1);
           	
           	boolean added = client.addedSuccessful();
           	
           	// Show updated results
		if(added) {
           		JOptionPane.showMessageDialog(null, "Trip Order added Updated Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
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
        
        // Add buttons to the form
	add(addButton);
        add(updateButton);
        add(getByID);
        add(clearButton);
        add(deleteButton);
        
        pack(); // Adjusts window size to fit all components
        setVisible(true); // Set window visibility
    }
    
        // Method to retrieve route rates
	void getRouteRates() 
	{
    		Client client = new Client();
    		client.sendAction("Get Routes");
    		routeList = (RouteRates[])client.receiveResponse();
        	System.out.println(routeList);
        }

	
        // Method to generate invoice
	public void generateInvoice(TripOrder obj2) {
    	String invoiceCreation = "E:\\Notes & Lectures\\Year 4\\SEM 8\\APProject-main\\invoice.pdf";
    	Document obj1 = new Document();
    	try {
			PdfWriter.getInstance(obj1, new FileOutputStream(invoiceCreation));
			
			obj1.open();
			
			Paragraph para = new Paragraph("ODERINVOICE \nInvoiceNo: " + obj2.getInvoiceNo()+"\nRoute Name: "
					+ ""+ obj2.getRouteName()+"\nCompany: " + obj2.getCompany()+"\nSource Address: "+ obj2.getSourceAddress()+""
					+ "\nDestination Address: "+ obj2.getDestinationAddress()+"\nRate: "+ obj2.getRate()+"\nstartDate: "+
					obj2.getStartDate()+"\nendDate: " + obj2.getEndDate()+ "\nDriver: " + obj2.getDriver() + "\nBilled By: " 
					+ obj2.getBilledBy());
			
			obj1.add(para);
			
			try {
				obj1.add(Image.getInstance("E:\\Notes & Lectures\\Year 4\\SEM 8\\APProject-main\\truckpic.jpg"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			obj1.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
    }
    
        // Main method
	public static void main(String[] args) 
	{
       		new TripOrderWindow(); // Create new instance of TripOrder Window
	} 
}
