package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Client;
import generalinfo.GenerateReports;
import generalinfo.Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class FinalReportWindow extends JFrame implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declare text Fields for access by the clear button action
    private JTextField payIdField, staffIdField, startDateField, endDateField, contractorSalaryField, driverSalaryField, preparedByField;

    public FinalReportWindow() {
        super("Final Report Window");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(7, 2)); // Adjust grid layout for buttons
        
        // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
        Color inputFieldBorderColor = new Color(0, 0, 128); // A contrasting border color
        Color royalBlue = new Color(65, 105, 225);
        Color navyBlue = new Color(0, 0, 128);
        

        // Set background color to a light blue - skyBlue
        getContentPane().setBackground(skyBlue);

        
        
        // Initialize text Fields
        payIdField = new JTextField();
        payIdField.setEditable(false);
        staffIdField = new JTextField();
        staffIdField.setEditable(false);
        startDateField = new JTextField();
        startDateField.setEditable(false);
        endDateField = new JTextField();
        endDateField.setEditable(false);
        contractorSalaryField = new JTextField();
        contractorSalaryField.setEditable(false);
        driverSalaryField = new JTextField();
        driverSalaryField.setEditable(false);
        preparedByField = new JTextField();
        preparedByField.setEditable(false);

        // Add labels and text Fields to the form
        add(new JLabel("Pay Id"));
        add(payIdField);

        add(new JLabel("Staff Id"));
        add(staffIdField);

        add(new JLabel("Start Date"));
        add(startDateField);
        
        add(new JLabel("End Date"));
        add(endDateField);

        add(new JLabel("Contractor Salary"));
        add(contractorSalaryField);

        add(new JLabel("Driver Salary"));
        add(driverSalaryField);
        
        add(new JLabel("Prepared By"));
        add(preparedByField);

      
        

//        add(getByID);
        pack(); // Adjusts window size to fit all cWomponents
        setVisible(true);
    }

    public static void main(String[] args) {
        new FinalReportWindow();
    }
}
