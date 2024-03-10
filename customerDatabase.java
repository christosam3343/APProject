import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class customerDatabase {
	private Connection con;

	@SuppressWarnings("static-access")
	public customerDatabase() {
		databaseConnection gas = null;
		con = gas.getDatabaseConnection();
	}
	public void create(int CustId, String company, String contactPerson, String custAddress1, 
						String custAddress2, String custPostOffice, String custParish, String custTelephone,
						String custEmail, boolean custStatus)  {
		String sql = "INSERT INTO customer (CustId,company,contactPerson,custAddress1,custAddress2,"
											+ "custPostOffice,custParish, custTelephone,custEmail, custStatus)"
											+ "VALUES ("+CustId+",'"+company+"','"+contactPerson+"',"
											+ "'"+custAddress1+"','"+custAddress2+"','"+ custPostOffice+"'"
											+ ",'"+custParish+"','"+custTelephone+"',"
											+ "'"+custEmail+"',"+custStatus+")";
		Statement ex = null;
		try {
			ex = con.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void searchCustomer(int CustId)  {
		try {
			String sql = "Select * from customer "+"WHERE CustId ='"+CustId+"'";
			Statement ex = null;
			ResultSet set = null;
			
				ex = con.createStatement();
				set = ex.executeQuery(sql);
				
				while (set.next()) {
					int id= set.getInt("CustId");
					String company= set.getString("company");
					String contactPerson= set.getString("contactPerson");
					String custAddress1 = set.getString("custAddress1");
					String custAddress2 = set.getString("custAddress2");
					String custPostOffice = set.getString("custPostOffice");
					String custParish = set.getString("custParish");
					String custTelephone = set.getString("custTelephone");
					String custEmail = set.getString("custEmail");
					boolean custStatus = set.getBoolean("custStatus");
					
				
					
				System.out.print("ID is: "+id+"\nCompany: "+company+"\nContact Person: "
					           	+ ""+contactPerson+"\nAddress: "+custAddress1+" "+custAddress2+" "+ 
					           	custPostOffice+" "+custParish+"\nTelephone: "+custTelephone+"\nEmail:"
								+ " "+custEmail+"\nStatus: "+custStatus);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public void delete(int CustId)  {
		String sql = "DELETE from customer"+" WHERE CustID="+"'"+CustId+"'";
		Statement ex = null;
		try {
			ex = con.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
