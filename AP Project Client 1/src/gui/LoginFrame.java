package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// class LoginFrame extends JFrame and implements ActionListener interface
public class LoginFrame extends JFrame implements ActionListener 
{
    // Declaration of Variables
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constructor for LoginFrame
    public LoginFrame() 
    {
        setTitle("Login Form");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        
        
        
        // Define custom colors
        Color skyBlue = new Color(135, 206, 235);
        Color steelBlue = new Color(70, 130, 180);
        Color inputFieldBorderColor = new Color(30, 144, 255); // A contrasting border color
        Color royalBlue = new Color(65, 105, 225);
        Color navyBlue = new Color(0, 0, 128);

        // Set background color to a light blue - skyBlue
        getContentPane().setBackground(skyBlue);

        // Create a JPanel for holding components and set it to be transparent
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false); // Make panel transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4); // External padding of components

        // Create labels for username field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Open Sans", Font.PLAIN, 12));
        usernameField.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        usernameField.setPreferredSize(new Dimension(usernameField.getWidth(), 30)); // Increase field height
        
        // Create labels for password field
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Open Sans", Font.PLAIN, 12));
        passwordField.setBorder(new LineBorder(inputFieldBorderColor, 2)); // Set a contrasting border
        passwordField.setPreferredSize(new Dimension(passwordField.getWidth(), 30)); // Increase field height

        // Create login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Roboto", Font.BOLD, 14));
        loginButton.setBackground(steelBlue); // Set button color to a darker blue - steelBlue
        loginButton.setForeground(Color.WHITE); // Set text color to white
        loginButton.addActionListener(this);
        
        // Add a hover effect to change the button's color when the mouse is over it
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(0, 0, 128)); // Darker shade when hovered
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(steelBlue); // Original color
            }
        });

        // Add components to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        // Add panel to the frame and center the frame
        add(panel);
        setLocationRelativeTo(null); // Center the frame
    }

    // Action performed method for handling button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredUsername = usernameField.getText();
        char[] enteredPassword = passwordField.getPassword();

        // Hardcoded valid credentials
        String validAdminUsername = "admin";
        String validAdminPassword = "admin";
                
        String validSuperAdminUsername = "superadmin";
        String validSuperAdminPassword = "superadmin";
        
        // Check if entered credentials match valid credentials
        if (enteredUsername.equals(validAdminUsername) && new String(enteredPassword).equals(validAdminPassword)) {
            JOptionPane.showMessageDialog(this, "Admin Login successful!");
         // Open the new window (MainAppFrame) on successful login
            MainAppFrame mainAppFrame = new MainAppFrame(1);
            mainAppFrame.setVisible(true);
            dispose(); // Close the login window

        } else if (enteredUsername.equals(validSuperAdminUsername) && new String(enteredPassword).equals(validSuperAdminPassword)){
        	JOptionPane.showMessageDialog(this, "SuperAdmin Login successful!");
               // Open the new window (MainAppFrame) on successful login
               MainAppFrame mainAppFrame = new MainAppFrame(3);
               mainAppFrame.setVisible(true);
               dispose(); // Close the login window
        } 
        else {
        	JOptionPane.showMessageDialog(this, "Incorrect username or password");
        }
    }

    // Main method to launch the application
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
