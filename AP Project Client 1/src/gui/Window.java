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

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktop;
	private JMenuBar menuBar;
//	private JMenu file;
//	private JMenu edit;
//	private JButton staffButton;
//	private JMenuItem menuItemCustomer;
//	private JMenuItem menuItemStaff;
//	private JMenuItem menuItemSave;
	private MenuItem menuAbout;
	private MenuItem menuOpen;
	private MenuItem menuClose;
	private TrayIcon  trayIcon;
	private PopupMenu popup;
	private Toolkit toolKit = Toolkit.getDefaultToolkit();
	private Image image = toolKit.getImage("./images/app.png");
	
	public Window() {
		initializeComponents();
		addMenuItemsToPopup();
		addMenuItemsToMenu();
		addMenusToMenuBar();
		addComponentsToWindow();
		setWindowProperties();
	}
	
	public void initializeComponents() {
		desktop = new JDesktopPane();
		menuBar = new JMenuBar();
//		file = new JMenu("File");
//		file.setMnemonic('A');
//		edit = new JMenu("Edit");
//		edit.setMnemonic('S');
//		staffButton = new JButton("Staff");
//		menuItemCustomer = new JMenuItem("Customer");
//		menuItemStaff = new JMenuItem("Staff");
//		menuItemSave = new JMenuItem("Save");
//		menuItemSave.setToolTipText("Saves the active document");
		menuAbout = new MenuItem("About");
		menuOpen = new MenuItem("Open");
		menuClose = new MenuItem("Close");
		popup = new PopupMenu();
		trayIcon = new TrayIcon(image, "This is a tray icon");
		trayIcon.setPopupMenu(popup);	
	}
	public void addMenuItemsToPopup() {
		popup.add(menuAbout);
		popup.add(menuOpen);
		popup.add(menuClose);
	}
	public void addMenuItemsToMenu() {
//		file.add(menuItemStaff);
//		file.add(menuItemCustomer);
//		edit.add(menuItemSave);
//		edit.add(staffButton);
	}
	public void addMenusToMenuBar() {
//		menuBar.add(edit);
//		menuBar.add(file);
	}
	public void addComponentsToWindow() {
		this.add(desktop);
	}
	public void setWindowProperties() {
		this.setJMenuBar(menuBar);
		this.setSize(1020, 700);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
	
		menuClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				System.exit(0);
				
			}
		});
		menuAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Info about awesome app");
				
			}
		});
		menuOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemTray.getSystemTray().remove(trayIcon);
				setVisible(true);
				
			}
		});
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
