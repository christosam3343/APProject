package gui;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MainAppFrame Extends JFrame
public class MainAppFrame extends JFrame {

    // Constructor for MainAppFrame
    public MainAppFrame(int admin_check) {
    	
	// Check the role of the user based on admin_check parameter
    	if (admin_check==1) {
    		System.out.println("Admin"); // Print admin role 	
		}else if (admin_check==2) {
                System.out.println("Contractor"); // Print contractor role
		}else if (admin_check==3) {
                System.out.println("SuperAdmin"); // Print super admin role
		}	
		else {
                JOptionPane.showMessageDialog(this, "No Valid User ROLE WAS FOUND"); // Show error message for invalid role
		 return;
		}
    	
    	
        // Set up the main frame
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
        
        // Create and configure the title label
	JLabel titleLabel = new JLabel("Welcome to JAVA Haulage and Trucking!!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        titleLabel.setPreferredSize(new Dimension(400, 30));
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setLayout(null);
        buttonPanel.setLayout(new FlowLayout());
	        
	// Add "Staff Panel" button for SuperAdmin
        if(admin_check ==3) {
	        JButton staffButton = new JButton("Staff Panel");
	        staffButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
	        staffButton.setForeground(Color.WHITE); // Set text color to white
	        
	        
	        staffButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                openStaffWindow(); // Open the staff window
	            }
	        });
        
        	buttonPanel.add(staffButton);
        }

        // Add "Customer Panel" button for Admin and SuperAdmin
        if(admin_check == 3 || admin_check == 1) {
        JButton customerButton = new JButton("Customer Panel");
        customerButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        customerButton.setForeground(Color.WHITE); // Set text color to white
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerWindow(); // Open the customer window
            }
        });
        buttonPanel.add(customerButton);
        }
        
        // Add "Trip/Order Panel" button
        JButton tripOrderButton = new JButton("Trip/Order Panel");
        tripOrderButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        tripOrderButton.setForeground(Color.WHITE); // Set text color to white
        tripOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTripOrderWindow(); // Open the staff window
            }
        });
        buttonPanel.add(tripOrderButton);
        
        // Add "Route Panel" button
        JButton routeButton = new JButton("Route Panel");
        routeButton.setBounds(153, 115, 79, 21);
        routeButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        routeButton.setForeground(Color.WHITE); // Set text color to white
        routeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRouteWindow(); // Open the customer window
            }
        });
        buttonPanel.add(routeButton);
        
        // Add "Generate Report" button
        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBounds(233, 116, 107, 21);
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
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame
    }
	
    private void JTableHeader(String string) 
	{
		
	}
	
	// Method to open staff window
	private void openStaffWindow() 
	{
        StaffWindow staffWindow = new StaffWindow();
        staffWindow.setVisible(true);
        }

	// Method to open Calculate payroll window
	private void calculatePayroll() 
	{
    	PayRollWindow payRoll = new PayRollWindow();
        }
	
        // Method to open customer window
        private void openCustomerWindow() 
	{
        CustomerWindow customerWindow = new CustomerWindow();
	customerWindow.setVisible(true);
        }
    
    private void editCustomerWindow() {
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
        // call method to edit
    }
    
    private void deleteCustomerWindow() {
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
        // call method to delete
    }
    
    
    // Method to open trip/order windoW
    private void openTripOrderWindow() {
        TripOrderWindow tripOrderWindow = new TripOrderWindow();
        tripOrderWindow.setVisible(true);
    }

    // Method to open route window
    private void openRouteWindow() {
        RouteWindow routeWindow = new RouteWindow();
        routeWindow.setVisible(true);
    }

    // Method to open generate report window
    private void generateReportWindow() {
    	GenerateReportWindow generateReportWindow = new GenerateReportWindow();
    	generateReportWindow.setVisible(true);
    }
}
