//Add Staff, Add Customer, Manage Customer(Edit Customer, Delete Customer, 
//Calculate Payroll), Manage Order/Trips(Add Routes/Rates, Add Order), Generate Reports(Create a form)


package gui;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAppFrame extends JFrame {
    public MainAppFrame(int admin_check) {
    	
    	if (admin_check==1) {
    		System.out.println("Admin");   	
		}else if (admin_check==2) {
			System.out.println("Contractor");   	
		}else if (admin_check==3) {
			System.out.println("SuperAdmin");   
		}	
		else {
			JOptionPane.showMessageDialog(this, "No Vaild User ROLE WAS FOUND");
			return;
		}
    	
    	
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
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setLayout(null);
        buttonPanel.setLayout(new FlowLayout());
        if(admin_check ==3) {
	        // Create the "Staff" button
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
        
     // Create the "Customer" button
        JButton calculatePayroll = new JButton("Calculate Payroll");
        calculatePayroll.setBounds(41, 115, 107, 21);
        calculatePayroll.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        calculatePayroll.setForeground(Color.WHITE); // Set text color to white
        calculatePayroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	calculatePayroll(); // Open the customer window
            }
        });
        buttonPanel.add(calculatePayroll);
        
        if(admin_check == 3 || admin_check == 1) {
        // Create the "Customer" button
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
//        // Create the "Customer" button
//        JButton editCustomerButton = new JButton("Edit Customer");
//        editCustomerButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
//        editCustomerButton.setForeground(Color.WHITE); // Set text color to white
//        editCustomerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                editCustomerWindow(); // Open the customer window
//            }
//        });
//        buttonPanel.add(editCustomerButton);
//        
//        // Create the "Customer" button
//        JButton deleteCustomerButton = new JButton("Delete Customer");
//        deleteCustomerButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
//        deleteCustomerButton.setForeground(Color.WHITE); // Set text color to white
//        deleteCustomerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                deleteCustomerWindow(); // Open the customer window
//            }
//        });
//        buttonPanel.add(deleteCustomerButton);
        
     
        
        
        
        JButton tripOrderButton = new JButton("Add Trip/Order");
        tripOrderButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        tripOrderButton.setForeground(Color.WHITE); // Set text color to white
        tripOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTripOrderWindow(); // Open the staff window
            }
        });
        buttonPanel.add(tripOrderButton);
        
        // Create the "Route" button
        JButton routeButton = new JButton("Add Route");
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
        
        // Create the "Customer" button
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
    
    

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new MainAppFrame().setVisible(true));
//    }
}
