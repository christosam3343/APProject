package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

// Window class inherits JFrame
public class Window extends JFrame
{
	// Unique serialization UID
	private static final long serialVersionUID = 1L;
	
	// Declaration of Variables
	private JDesktopPane desktop;
	private JMenuBar menuBar;
	private MenuItem menuAbout;
	private MenuItem menuOpen;
	private MenuItem menuClose;
	private TrayIcon  trayIcon;
	private PopupMenu popup;
	private Toolkit toolKit = Toolkit.getDefaultToolkit();
	private Image image = toolKit.getImage("./images/app.png");
	
	// Constructor for the Window class
	public Window() 
	{
		initializeComponents();
		addMenuItemsToPopup();
		addMenuItemsToMenu();
		addMenusToMenuBar();
		addComponentsToWindow();
		setWindowProperties();
	}
	
	// Method to initialize all GUI components
	public void initializeComponents() {
		desktop = new JDesktopPane();
		menuBar = new JMenuBar();
		menuAbout = new MenuItem("About");
		menuOpen = new MenuItem("Open");
		menuClose = new MenuItem("Close");
		popup = new PopupMenu();
		trayIcon = new TrayIcon(image, "This is a tray icon");
		trayIcon.setPopupMenu(popup);	
	}

	// Method to add menu items to the popup menu
	public void addMenuItemsToPopup() {
		popup.add(menuAbout);
		popup.add(menuOpen);
		popup.add(menuClose);
	}

	// Method to add menu items to the menu
	public void addMenuItemsToMenu() {
		file.add(menuItemStaff);
		file.add(menuItemCustomer);
		edit.add(menuItemSave);
		edit.add(staffButton);
	}

	// Method to add menus to the menu bar
	public void addMenusToMenuBar() {
		menuBar.add(edit);
		menuBar.add(file);
	}

	// Method to add components to the window
	public void addComponentsToWindow() {
		this.add(desktop);
	}

	// Method to set properties for the window
	public void setWindowProperties() {
		this.setJMenuBar(menuBar);
		this.setSize(1020, 700);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
	
		// ActionListener for the "Close" menu item
		menuClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				System.exit(0);
				
			}
		});
		
		// ActionListener for the "About" menu item
		menuAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Info about awesome app");
				
			}
		});

		// ActionListener for the "Open" menu item
		menuOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 SystemTray.getSystemTray().remove(trayIcon); // Remove the system tray icon
                		 setVisible(true); // Set the window to be visible
				
			}
		});

		// WindowListener to handle events related to window state changes
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				try{
					SystemTray.getSystemTray().add(trayIcon);
				}catch(AWTException e1) {
					e1.printStackTrace();					
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
	}	

}
