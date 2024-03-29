package generalinfo;

import java.util.Date;

public class GenerateReports {
	// Declaration of Variables
	String driverName;
	Date startDate;
	Date endDate;
	float earnings;
	int totalNumOfOrders;
	
	// Primary Consturctor for GenerateReports class
	public GenerateReports(String driverName, Date startDate, Date endDate, float earnings, int totalNumOfOrders) {
		super();
		this.driverName = driverName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.earnings = earnings;
		this.totalNumOfOrders = totalNumOfOrders;
	}
		
	// Default Consturctor for GenerateReports class
	public GenerateReports() {
		super();
		this.driverName = "";
		this.startDate = new Date();
		this.endDate = new Date();
		this.earnings = 0.0f;
		this.totalNumOfOrders = 0;
	}

	// Setters and Getters for GenerateReports class
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getEarnings() {
		return earnings;
	}

	public void setEarnings(float earnings) {
		this.earnings = earnings;
	}

	public int getTotalNumOfOrders() {
		return totalNumOfOrders;
	}

	public void setTotalNumOfOrders(int totalNumOfOrders) {
		this.totalNumOfOrders = totalNumOfOrders;
	}

        // toString method to convert GenerateReports object to string
	@Override
	public String toString() {
		return "GenerateReports [driverName=" + driverName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", earnings=" + earnings + ", totalNumOfOrders=" + totalNumOfOrders + "]";
	}

}