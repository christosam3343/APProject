package server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import generalinfo.Customer;
import generalinfo.TripOrder;

public class OrderCrud extends Server{
	
	public void createOrder(TripOrder tripOrder)  {
		String sql = "INSERT INTO orders (invoiceNo,company,sourceAddress,destinationAddress,rate,"
					+ "driver,billedBy)"
					+ "VALUES ('"+tripOrder.getInvoiceNo()+"','"+tripOrder.getCompany()+"','"+tripOrder.getSourceAddress()+"',"
					+ "'"+tripOrder.getDestinationAddress()+"',"+tripOrder.getRate()+",'"+ tripOrder.getDriver()+"'"
					+ ",'"+tripOrder.getBilledBy()+"')";
		try {
			stmt = dBConn.createStatement();
			stmt.executeUpdate(sql);
			if ((stmt.executeUpdate(sql) == 1)) {
				objOs.writeObject (true);//Return true to client if successful
			} else {
				objOs.writeObject(false);
			}
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public TripOrder searchOrder(String invoiceNo)  {
		TripOrder tripObj = new TripOrder();
		try {
			String sql = "Select * from orders "+"WHERE invoiceNo ='"+invoiceNo+"'";
			Statement ex = null;
			ResultSet set = null;

			ex = dBConn.createStatement();
			set = ex.executeQuery(sql);


			if (set.next()) {
				tripObj.setInvoiceNo(set.getString(1));
				tripObj.setCompany (set.getString(2));
				tripObj.setSourceAddress(set.getString(3)); 
				tripObj.setDestinationAddress(set.getString(4));
				tripObj.setRate(set.getDouble(5));
				tripObj.setDriver (set.getString(6));
				tripObj.setBilledBy(set.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tripObj;	
	}
	
	public void updateOrder(TripOrder tripOrder) {
		
		String sql = "UPDATE customer SET company = '"+ tripOrder.getCompany()+"',sourceAddress = '"+tripOrder.getSourceAddress()+"',"
					+ "destinationAddress ='"+tripOrder.getDestinationAddress()+"', rate = "+tripOrder.getRate()+", driver = '"
					+ tripOrder.getDriver()+"',billedBy = '"+ tripOrder.getBilledBy()+"'"+"  WHERE invoiceNo = '"+ tripOrder.getInvoiceNo()+"'";
		Statement ex = null;
		try {
			ex = dBConn.createStatement();
		
			ex.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public void deleteOrder(String invoiceNo)  {
		String sql = "DELETE from orders"+" WHERE invoiceNo="+"'"+invoiceNo+"'";
		Statement ex = null;
		try {
			ex = dBConn.createStatement();

			ex.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
