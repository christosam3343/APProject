package server;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Customer;
import domain.Staff;


public class staffCrud extends server{
	
	public void addStaffToFile(Staff staff) {
		String sql = "INSERT INTO staff (staffID,staffFirstName,staffLastName,staffDob,staffAddress1,"
				+ "staffAddress2,staffPostOffice, staffParish,staffTelephone, staffEmail, staffPosition, staffStatus)"
				+ "VALUES ("+staff.getStaffID()+",'"+staff.getstaffFirstName()+"','"+staff.getstaffLastName()+"',"
				+ "'"+staff.getstaffDob()+"','"+staff.getstaffAddress1()+"','"+ staff.getstaffAddress2()+"'"
				+ ",'"+staff.getstaffPostOffice()+"','"+staff.getstaffParish()+"',"
				+ "'"+staff.getstaffTelephone()+"',"+staff.getstaffEmail()+","+staff.getstaffPosition()+","+staff.getstaffStatus()+")";
				
		try {		
				stmt = dBConn.createStatement();
					
				if ((stmt.executeUpdate(sql) == 1)) {
					objOs.writeObject (true);//Return true to client if successful
				} else {
					objOs.writeObject(false);
				   }				
			} catch (IOException ioe) {
				// Ideally you want to save errors to a log file
				
				ioe.printStackTrace();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public Staff findStaffById(int staffID) {
		Staff staffObj = new Staff();
		String sql = "Select * from customer "+"WHERE CustId ='"+staffID+"'";
		try {
			stmt = dBConn.createStatement();
			result = stmt.executeQuery(sql); 
			if (result.next()) {
				staffObj.setStaffID(result.getInt (1));
				staffObj.setstaffFirstName(result.getString(2));
				staffObj.setstaffLastName (result.getString(3)); 
				staffObj.setstaffDob (result.getDate(4));
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
		
		Statement ex = null;
		try {
			ex = dBConn.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteStaff(int StaffID)  {
		String sql = "DELETE from staff"+" WHERE StaffID="+"'"+StaffID+"'";
		Statement ex = null;
		try {
			ex = dBConn.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
