import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
	private static Connection myconn = null;
	private static String url = "jdbc:mysql://localhost:3306/jhtdatabase";
	
	public static Connection getDatabaseConnection()  {
			try {
				myconn = DriverManager.getConnection (url, "root","");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return myconn;
	}
}
