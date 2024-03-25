package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateReportWindow extends JFrame {
    // Declare text Fields for access by the clear button action
    private JTextField invoiceNoField, companyField, sourceAddressField, destinationAddressField, rateField, driverField, billedByField;

    public GenerateReportWindow() {
        super("Generate Report Window");
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
        invoiceNoField = new JTextField();
        companyField = new JTextField();
        sourceAddressField = new JTextField();
        destinationAddressField = new JTextField();
        rateField = new JTextField();
        driverField = new JTextField();
        billedByField = new JTextField();

        // Add labels and text Fields to the form
        add(new JLabel("Invoice No"));
        add(invoiceNoField);

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
    
        pack(); // Adjusts window size to fit all components
        setVisible(true);
    }

    public static void main(String[] args) {
        new GenerateReportWindow();
    }
}
