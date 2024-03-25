package server;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import generalinfo.Staff;


public class staffCrud extends server {
	
	
//	public static Connection getDatabaseConnection() {
//		if (dBConn == null) {
//			String url = "jdbc:mysql://localhost:3306/jhtdatabase";
//			try {
//				dBConn = DriverManager.getConnection(url,"root","");
//				JOptionPane.showMessageDialog(null, "DB Connection Established",
//						"Connection Status",JOptionPane.INFORMATION_MESSAGE);
//				
//			} catch (SQLException e) {
//				
//				JOptionPane.showMessageDialog(null, "Could not establish DB Connection ",
//						"Connection Failure",JOptionPane.INFORMATION_MESSAGE);
//			}
//		}
//		return dBConn;
//		
//	}
	
//	(staffID,staffFirstName,staffLastName,staffDob,staffAddress1,"
//			+ "staffAddress2,staffPostOffice, staffParish,staffTelephone, staffEmail, staffPosition, staffStatus)
//	
	public boolean addStaffToFile(Staff staff) {
		
		boolean saved = false;
		
		String sql = "INSERT INTO `staff`(`staffID`, `staffFirstName`, `staffLastName`, "
				+ "`staffDob`, `staffAddress1`, `staffAddress2`,"
				+ " `staffPostOffice`, `staffParish`, `staffTelephone`,"
				+ " `staffEmail`, `staffPosition`, `staffStatus`) "
				+ "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		try {	
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, staff.getStaffID());
			statement.setString(2, staff.getstaffFirstName());
			statement.setString(3, staff.getstaffLastName());
			
			statement.setString(4, staff.getstaffDob());
			statement.setString(5, staff.getstaffAddress1());
			statement.setString(6, staff.getstaffAddress2());
			
			statement.setString(7, staff.getstaffPostOffice());
			statement.setString(8, staff.getstaffParish());
			statement.setString(9, staff.getstaffTelephone());
			statement.setString(10, staff.getstaffEmail());
			
			statement.setString(11, staff.getstaffPosition());
			statement.setBoolean(12, staff.getstaffStatus());
					
			if ((statement.executeUpdate() == 1)) {
				saved = true; 
			}
				
		} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return saved; //Return true to client if successful
	}
	
	public Staff findStaffById(int staffID) {
		Staff staffObj = new Staff();
		String sql = "Select * from customer "+"WHERE CustId ='"+staffID+"'";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
			
			result = statement.executeQuery(sql); 
			if (result.next()) {
				staffObj.setStaffID(result.getInt (1));
				staffObj.setstaffFirstName(result.getString(2));
				staffObj.setstaffLastName (result.getString(3)); 
				staffObj.setstaffDob (result.getString(4));
				staffObj.setstaffAddress1 (result.getString(5));
				staffObj.setstaffAddress2 (result.getString(6));
				staffObj.setstaffPostOffice (result.getString(7));
				staffObj.setstaffParish (result.getString(8));
				staffObj.setstaffTelephone (result.getString(10));
				staffObj.setstaffEmail (result.getString(11));
				staffObj.setstaffPosition (result.getString(12));
				staffObj.setstaffStatus (result.getBoolean(13));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return staffObj;	
	}
	
	
	public void updateStaff(Staff staff) {
		
		String sql = "UPDATE staff SET staffFirstName = '"+ staff.getstaffFirstName()+"',staffLastName = '"+staff.getstaffLastName()+"',"
					+ "staffDob ='"+staff.getstaffDob()+"', staffAddress1 = '"+staff.getstaffAddress1()+"', staffAddress2 = '"
					+ staff.getstaffAddress2()+"',staffPostOffice = '"+ staff.getstaffPostOffice()+"', staffParish = '"+staff.getstaffParish()
					+"',staffTelephone = '"+ staff.getstaffTelephone()+"', staffEmail = "+staff.getstaffEmail()+", staffPosition = "
					+staff.getstaffPosition()+"' staffStaus = '"+staff.getstaffStatus()+"'"+" WHERE CustId = '"+ staff.getStaffID()+"'";
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteStaff(int StaffID)  {
		String sql = "DELETE from staff"+" WHERE StaffID="+"'"+StaffID+"'";
		Statement ex = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
