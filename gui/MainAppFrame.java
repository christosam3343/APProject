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
        
        JLabel titleLabel = new JLabel("Welcome to JAVA Haulage and Trucking!!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        titleLabel.setPreferredSize(new Dimension(400, 30));
        add(titleLabel, BorderLayout.NORTH);
        
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        buttonPanel.setLayout(new FlowLayout());
        // Create the "Staff" button
        JButton staffButton = new JButton("Staff");
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStaffWindow(); // Open the staff window
            }
        });
        buttonPanel.add(staffButton);
        // Create the "Customer" button
        JButton customerButton = new JButton("Customer");
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerWindow(); // Open the customer window
            }
        });
        buttonPanel.add(customerButton);
        JButton tripOrderButton = new JButton("Trip/Order");
        tripOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTripOrderWindow(); // Open the staff window
            }
        });
        buttonPanel.add(tripOrderButton);
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

    private void openCustomerWindow() {
        CustomerWindow customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
    }
    
    private void openTripOrderWindow() {
        TripOrderWindow tripOrderWindow = new TripOrderWindow();
        tripOrderWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainAppFrame().setVisible(true));
    }
}
