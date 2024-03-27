package server;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import generalinfo.Customer;

public class CustomerCrud extends Server implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



//	public void addCustomerToFile(Customer customer) {
//
//		boolean saved = false;
//		
//		String sql = "INSERT INTO customer (`CustId`, `company`, `contactPerson`, `custAddress1`, `custAddress2`,"
//				+ "`custPostOffice`, `custParish`, `custTelephone`, `custEmail`, `balance`, `custStatus`)"
//				+ "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//				
//		try {		
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
//			
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setLong(1, customer.getCustID());
//			statement.setString(2, customer.getcompany());
//			statement.setString(3, customer.getcontactPerson());
//			statement.setString(4, customer.getcustAddress1());
//			statement.setString(5, customer.getcustAddress2());
//			statement.setString(6, customer.getcustPostOffice());
//			statement.setString(7, customer.getcustParish());
//			statement.setString(8, customer.getcustTelephone());
//			statement.setString(9, customer.getcustEmail());
//			statement.setString(10, customer.getcustBalance());
//			statement.setString(11, customer.getcustStatus());
//			
//			
//			if ((statement.executeUpdate() == 1)) {
//					saved = true; 
//					System.out.print("SAVED STAFF");
//			}
//				
//		} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		return saved; //Return true to client if successful
//	}
	
	
//	public Customer findCustomerById(int custId) {
//		Customer custObj = new Customer();
//		String sql = "Select * from customer "+"WHERE CustId ='"+custId+"'";
//		try {
//			stmt = dBConn.createStatement();
//			result = stmt.executeQuery(sql); 
//			if (result.next()) {
//				custObj.setCustId(result.getInt (1));
//				custObj.setCompany (result.getString(2));
//				custObj.setContactPerson (result.getString(3)); 
//				custObj.setCustAddress1 (result.getString(4));
//				custObj.setCustAddress2 (result.getString(5));
//				custObj.setCustPostOffice (result.getString(6));
//				custObj.setCustParish (result.getString(7));
//				custObj.setCustTelephone (result.getString(8));
//				custObj.setCustEmail (result.getString(9));
//				custObj.setCustBalance (result.getFloat(10));
//				custObj.setCustStatus (result.getBoolean(11));
//				
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//		return custObj;	
//	}
//	
	
	
//	public void updateCust(Customer customer) {
//			
//		String sql = "UPDATE customer SET company = '"+ customer.getCompany()+"',contactPerson = '"+customer.getContactPerson()+"',"
//					+ "custAddress1 ='"+customer.getCustAddress1()+"', custAddress2 = '"+customer.getCustAddress2()+"', custPostOffice = '"
//					+ customer.getCustPostOffice()+"',custParish = '"+ customer.getCustParish()+"', custTelephone = '"+customer.getCustTelephone()
//					+"',custEmail = '"+ customer.getCustEmail()+"', balance = "+customer.getCustBalance()+", custStatus = "
//					+customer.isCustStatus()+ " WHERE CustId = '"+ customer.getCustId()+"'";
//		
//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jhtdatabase", "root", "");
//			PreparedStatement statement = connection.prepareStatement(sql);
//		
//			statement.executeUpdate(sql);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	
	
	public void deleteCust(int CustId)  {
		String sql = "DELETE from customer"+" WHERE CustID="+"'"+CustId+"'";
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
