package server;

import java.sql.SQLException;

import generalinfo.Customer;
import generalinfo.logins;

public class loginCrud extends server{
	
	public logins checkLogin(String userName) {
		logins loginObj = new logins();
		String sql = "Select * from logins "+"WHERE userName ='"+userName+"'";
		try {
			stmt = dBConn.createStatement();
			result = stmt.executeQuery(sql); 
			
			if (result.next()) {
				loginObj.setUserName(result.getString (1));
				loginObj.setPassword (result.getString(2));	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return loginObj;	
	}

}
