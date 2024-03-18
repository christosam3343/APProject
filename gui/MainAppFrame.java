//Add Staff, Add Customer, Manage Customer(Edit Customer, Delete Customer, 
//Calculate Payroll), Manage Order/Trips(Add Routes/Rates, Add Order), Generate Reports(Create a form)


package gui;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAppFrame extends JFrame {
    public MainAppFrame() {
        setTitle("Main Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
        Color inputFieldBorderColor = new Color(30, 144, 255); // A contrasting border color
        Color royalBlue = new Color(65, 105, 225);
        Color navyBlue = new Color(0, 0, 128);
        
     // Set background color to a light blue - skyBlue
        getContentPane().setBackground(skyBlue);
        JPanel panel = new JPanel();
        panel.setOpaque(false); // Make panel transparent
        
        JLabel titleLabel = new JLabel("Welcome to JAVA Haulage and Trucking!!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        titleLabel.setPreferredSize(new Dimension(400, 30));
        add(titleLabel, BorderLayout.NORTH);
        
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        buttonPanel.setLayout(new FlowLayout());
        // Create the "Staff" button
        JButton staffButton = new JButton("Add Staff");
        staffButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        staffButton.setForeground(Color.WHITE); // Set text color to white
        
        
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStaffWindow(); // Open the staff window
            }
        });
        buttonPanel.add(staffButton);
        
     // Create the "Customer" button
        JButton calculatePayroll = new JButton("Calculate Payroll");
        calculatePayroll.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        calculatePayroll.setForeground(Color.WHITE); // Set text color to white
        calculatePayroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	calculatePayroll(); // Open the customer window
            }
        });
        buttonPanel.add(calculatePayroll);
        
        // Create the "Customer" button
        JButton customerButton = new JButton("Add Customer");
        customerButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        customerButton.setForeground(Color.WHITE); // Set text color to white
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerWindow(); // Open the customer window
            }
        });
        buttonPanel.add(customerButton);
        
        // Create the "Customer" button
        JButton editCustomerButton = new JButton("Edit Customer");
        editCustomerButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        editCustomerButton.setForeground(Color.WHITE); // Set text color to white
        editCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCustomerWindow(); // Open the customer window
            }
        });
        buttonPanel.add(editCustomerButton);
        
        // Create the "Customer" button
        JButton deleteCustomerButton = new JButton("Delete Customer");
        deleteCustomerButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        deleteCustomerButton.setForeground(Color.WHITE); // Set text color to white
        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCustomerWindow(); // Open the customer window
            }
        });
        buttonPanel.add(deleteCustomerButton);
        
     
        
        
        
//        JButton tripOrderButton = new JButton("Add Trip/Order");
//        tripOrderButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
//        tripOrderButton.setForeground(Color.WHITE); // Set text color to white
//        tripOrderButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                openTripOrderWindow(); // Open the staff window
//            }
//        });
//        buttonPanel.add(editTripOrderButton);
        
        // Create the "Route" button
        JButton routeButton = new JButton("Add Route");
        routeButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        routeButton.setForeground(Color.WHITE); // Set text color to white
        routeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRouteWindow(); // Open the customer window
            }
        });
        buttonPanel.add(routeButton);
        
        // Create the "Customer" button
        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        generateReportButton.setForeground(Color.WHITE); // Set text color to white
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	generateReportWindow(); // Open the customer window
            }
        });
        buttonPanel.add(generateReportButton);

        
        
        
        // Add the button panel to the main frame
        add(buttonPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame
    }
    private void JTableHeader(String string) {
		
	}
	private void openStaffWindow() {
        StaffWindow staffWindow = new StaffWindow();
        staffWindow.setVisible(true);
    }
	
	private void calculatePayroll() {
    	PayRollWindow payRoll = new PayRollWindow();
//    	payRoll.setVisible(true);
        //call method to calculate payroll
    }

    private void openCustomerWindow() {
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
    }
    
    private void editCustomerWindow() {
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
        //call method to edit
    }
    
    private void deleteCustomerWindow() {
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
        //call method to delete
    }
    
    
    
    private void openTripOrderWindow() {
        TripOrderWindow tripOrderWindow = new TripOrderWindow();
        tripOrderWindow.setVisible(true);
    }
    
    private void openRouteWindow() {
        RouteWindow routeWindow = new RouteWindow();
        routeWindow.setVisible(true);
    }
    
    private void generateReportWindow() {
    	GenerateReportWindow generateReportWindow = new GenerateReportWindow();
    	generateReportWindow.setVisible(true);
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainAppFrame().setVisible(true));
    }
}
