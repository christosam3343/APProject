package server;

import java.sql.SQLException;

import generalinfo.Customer;
import generalinfo.Logins;

public class LoginCrud extends Server{
	
	public Logins checkLogin(String userName) {
		Logins loginObj = new Logins();
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
