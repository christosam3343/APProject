package generalinfo;
import java.util.*;

public class PayRoll 
{
	// Declaration of variables
	private int payID;
	private int staffID;
	private int startDay;
	private int startMonth;
	private int startYear;
	private int endDay;
	private int endMonth;
	private int endYear;
	private float salaryAdmin;
	private float salaryMaintenance;
	private float salaryDriver;
	private String preparedBy;
	
	// Primary Constructor for PayRoll class
	public PayRoll(int payID, int staffID, int startDay, int startMonth, int startYear, int endDay, int endMonth,
					int endYear, float salaryAdmin, float salaryMaintenance, float salaryDriver, String preparedBy) {
		this.payID = payID;
		this.staffID = staffID;
		this.startDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
		this.salaryAdmin = salaryAdmin;
		this.salaryMaintenance = salaryMaintenance;
		this.salaryDriver = salaryDriver;
		this.preparedBy = preparedBy;
	}
	
	// Default Constructor for PayRoll class
	public PayRoll() {
		staffID = 0;
		payID = 0;
		startDay = 0;
		startMonth = 0;
		startYear = 0;
		endDay = 0;
		endMonth = 0;
		endYear = 0;
		salaryAdmin = 0;
		salaryMaintenance = 0;
		salaryDriver = 0;
		preparedBy = "";
	}

	// Settters and getters for PayRoll Class
	public int getPayID() {
		return payID;
	}

	public void setPayID(int payID) {
		this.payID = payID;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public float getSalaryAdmin() {
		return salaryAdmin;
	}

	public void setSalaryAdmin(float salaryAdmin) {
		this.salaryAdmin = salaryAdmin;
	}

	public float getSalaryMaintenance() {
		return salaryMaintenance;
	}

	public void setSalaryMaintenance(float salaryMaintenance) {
		this.salaryMaintenance = salaryMaintenance;
	}

	public float getSalaryDriver() {
		return salaryDriver;
	}

	public void setSalaryDriver(float salaryDriver) {
		this.salaryDriver = salaryDriver;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	

        // toString method to represent PayRoll object as a string
	@Override
	public String toString() {
		return "PayRoll [payID=" + payID + ", staffID=" + staffID + ", startDay=" + startDay + ", startMonth="
				+ startMonth + ", startYear=" + startYear + ", endDay=" + endDay + ", endMonth=" + endMonth
				+ ", endYear=" + endYear + ", salaryAdmin=" + salaryAdmin + ", salaryMaintenance=" + salaryMaintenance
				+ ", salaryDriver=" + salaryDriver + ", preparedBy=" + preparedBy + "]";
	}

	// Method to calculate payroll for administrative staff
	public void payrollAdmins() {
		Scanner obj1 = new Scanner(System.in);
		System.out.println("Enter your ID Number: ");
		int read1 = obj1.nextInt();
		if (read1 < 6) {
			salaryAdmin = 50000.00f;
			System.out.println("Your salary is: "+salaryAdmin);
		}
	}

	// Method to calculate payroll for maintenance staff
	public void payrollMaintenance() {
		Scanner obj2 = new Scanner(System.in);
		System.out.println("Enter your ID Number: ");
		int read1 = obj2.nextInt();
		if (read1 > 5 && read1 < 15) {
			salaryMaintenance = 35000.00f;
			System.out.println("Your salary is: "+salaryMaintenance);
		}
	}

	// Method to calculate payroll for drivers
	public void payrollDriver() {
		Scanner obj3 = new Scanner(System.in);
		System.out.println("Enter your ID Number: ");
		int read1 = obj3.nextInt();
		if (read1 > 15 && read1 < 40) {
			
		}
	}	
	
}
