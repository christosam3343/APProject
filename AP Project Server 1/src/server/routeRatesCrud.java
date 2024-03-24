package server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generalinfo.Customer;
import generalinfo.TripOrder;
import generalinfo.routeRates;

public class routeRatesCrud extends server {
	
	public void createRoute(String routeName, String source, String destination, double rate)  {
		String sql = "INSERT INTO routerates (routeName,source,destination,rate)"
					+ "VALUES ("+routeName+",'"+source+"','"+destination+"'," +rate+")";
		
		Statement ex = null;
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
		
		public routeRates searchRoute(String routeName)  {
			routeRates routeObj = new routeRates();
			try {
				String sql = "Select * from routerates "+"WHERE routeName ='"+routeName+"'";
				Statement ex = null;
				ResultSet set = null;
				
					ex = dBConn.createStatement();
					set = ex.executeQuery(sql);
					
					if (set.next()) {
						routeObj.setRouteName(set.getString(1));
						routeObj.setSource (set.getString(2));
						routeObj.setDestination(set.getString(3)); 
						routeObj.setRate(set.getDouble(4));							
					}	
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			return routeObj;
			
			
		}
		
		
		
		public void deleteRoute(int routenumber)  {
			String sql = "DELETE from routerates"+" WHERE routenumber="+"'"+routenumber+"'";
			Statement ex = null;
			try {
				ex = dBConn.createStatement();
			
				ex.executeUpdate(sql);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

}
