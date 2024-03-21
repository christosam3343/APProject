package server;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Customer;

public class customerCrud extends server{
	
	
	public void addCustomerToFile(Customer customer) {
		boolean stat = customer.isCustStatus();
		String sql = "INSERT INTO customer (CustId,company,contactPerson,custAddress1,custAddress2,"
				+ "custPostOffice,custParish, custTelephone,custEmail, balance, custStatus)"
				+ "VALUES ("+customer.getCustId()+",'"+customer.getCompany()+"','"+customer.getContactPerson()+"',"
				+ "'"+customer.getCustAddress1()+"','"+customer.getCustAddress2()+"','"+ customer.getCustPostOffice()+"'"
				+ ",'"+customer.getCustParish()+"','"+customer.getCustTelephone()+"',"
				+ "'"+customer.getCustEmail()+"',"+customer.getCustBalance()+","+customer.isCustStatus()+")";
				
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
	
	
	public Customer findCustomerById(int custId) {
		Customer custObj = new Customer();
		String sql = "Select * from customer "+"WHERE CustId ='"+custId+"'";
		try {
			stmt = dBConn.createStatement();
			result = stmt.executeQuery(sql); 
			if (result.next()) {
				custObj.setCustId(result.getInt (1));
				custObj.setCompany (result.getString(2));
				custObj.setContactPerson (result.getString(3)); 
				custObj.setCustAddress1 (result.getString(4));
				custObj.setCustAddress2 (result.getString(5));
				custObj.setCustPostOffice (result.getString(6));
				custObj.setCustParish (result.getString(7));
				custObj.setCustTelephone (result.getString(8));
				custObj.setCustEmail (result.getString(9));
				custObj.setCustBalance (result.getFloat(10));
				custObj.setCustStatus (result.getBoolean(11));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return custObj;	
	}
	
	
	
	public void updateCust(Customer customer) {
			
		String sql = "UPDATE customer SET company = '"+ customer.getCompany()+"',contactPerson = '"+customer.getContactPerson()+"',"
					+ "custAddress1 ='"+customer.getCustAddress1()+"', custAddress2 = '"+customer.getCustAddress2()+"', custPostOffice = '"
					+ customer.getCustPostOffice()+"',custParish = '"+ customer.getCustParish()+"', custTelephone = '"+customer.getCustTelephone()
					+"',custEmail = '"+ customer.getCustEmail()+"', balance = "+customer.getCustBalance()+", custStatus = "
					+customer.isCustStatus()+ " WHERE CustId = '"+ customer.getCustId()+"'";
		Statement ex = null;
		try {
			ex = dBConn.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteCust(int CustId)  {
		String sql = "DELETE from customer"+" WHERE CustID="+"'"+CustId+"'";
		Statement ex = null;
		try {
			ex = dBConn.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	
}
