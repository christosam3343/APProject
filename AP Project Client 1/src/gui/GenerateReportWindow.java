package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Client;
import generalinfo.GenerateReports;
import generalinfo.RouteRates;
import generalinfo.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;

// GenerateReportWindow class inheriting Serializable
public class GenerateReportWindow extends JFrame implements Serializable
{
    private static final long serialVersionUID = 1L;
    // Declare text Fields for access by the clear button action
    private JTextField startDateField, endDateField, earningsField, totalNumOfOrdersField;
    private JComboBox<String> driverNameDropdown;

        // Constructor for GenerateReportWindow
	public GenerateReportWindow() {
        super("Generate Report Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(4, 2)); // Adjust grid layout for buttons
        
        // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
        Color inputFieldBorderColor = new Color(0, 0, 128); // A contrasting border color
        Color royalBlue = new Color(65, 105, 225);
        Color navyBlue = new Color(0, 0, 128);
        

        // Set background color to a light blue - skyBlue
        getContentPane().setBackground(skyBlue);

        // Initialize text Fields
        driverNameDropdown = new JComboBox<String>(routeStrings);
        driverNameDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Handle submission logic here     
                String rName = (String) driverNameDropdown.getSelectedItem();
                
                for(RouteRates r: driverNameDropdown) {
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
        startDateField = new JTextField();
        endDateField = new JTextField();


        // Add labels and text Fields to the form
        add(new JLabel("Driver Name"));
        add(driverNameField);

        add(new JLabel("Start Date"));
        add(startDateField);

        add(new JLabel("End Date"));
        add(endDateField);
    
        // Create a button to retrieve based on ID
        JButton getByID = new JButton("Generate Report");
        getByID.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        getByID.setForeground(Color.WHITE); // Set text color to white
        getByID.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        getByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            	GenerateReports obj1 = new GenerateReports();
            	
       		client.sendAction("Find Staff");//Not sure
            	client.sendStaffId(staffID);//Not sure
            	obj1 = (GenerateReports) client.receiveResponse();
            }
        });

	// add ID retrieval button
        add(getByID);
        pack(); // Adjusts window size to fit all components
        setVisible(true); // Set window visible
    }

   	// Main method to start the GenerateReportWindow
	public static void main(String[] args) 
	{
        new GenerateReportWindow();
    }
}
