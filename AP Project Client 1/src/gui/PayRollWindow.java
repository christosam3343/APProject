package gui;

import javax.swing.*;

public class PayRollWindow {
    public static void main(String[] args) {
        // Create the frame and panel
        JFrame frame = new JFrame("PayRoll Application");
        JPanel panel = new JPanel();

        // Create buttons
        JButton adminButton = new JButton("Calculate payroll for Administrative Workers");
        JButton mainteButton = new JButton("Calculate payroll for Maintenance Workers");
        JButton driverButton = new JButton("Calculate payroll for Drivers");

        // Add buttons to panel
        panel.add(adminButton);
        panel.add(mainteButton);
        panel.add(driverButton);

        // Add panel to frame
        frame.add(panel);

        // Set frame attributes
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
