package gui;

import javax.swing.*;

public class PayRollWindow 
{
    // Main method
    public static void main(String[] args) 
    {
        // Create the frame and panel
        JFrame frame = new JFrame("PayRoll Application"); // Create a frame with a title
        JPanel panel = new JPanel(); // Create a panel to hold components

        // Create buttons
        JButton adminButton = new JButton("Calculate payroll for Administrative Workers");
        JButton mainteButton = new JButton("Calculate payroll for Maintenance Workers");
        JButton driverButton = new JButton("Calculate payroll for Drivers");

        // Add buttons to panel
        panel.add(adminButton); // Add admin payroll button to the panel
        panel.add(mainteButton); // Add maintenance payroll button to the panel
        panel.add(driverButton); // Add driver payroll button to the panel

        // Add panel to frame
        frame.add(panel); // Add the panel containing buttons to the frame

       // Set frame attributes
        frame.setSize(400, 200); // Set frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setVisible(true); // Make the frame visible
    }
}
