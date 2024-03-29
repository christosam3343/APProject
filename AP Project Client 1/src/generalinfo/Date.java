package generalinfo;

public class Date 
{
	// Declaration of Variables
	private int staffDobDay;
	private int staffDobMonth;
	private int staffDobYear;
	private int startDay;
	private int startMonth;
	private int startYear;
	private int endDay;
	private int endMonth;
	private int endYear;
		
	// Default Constructor for Date Class	
	public Date() 
	{	
		staffDobDay=0;
		staffDobMonth = 0;
		staffDobYear = 0;
		startDay = 0;
		startMonth = 0;
		startYear = 0;
		endDay = 0;
		endMonth = 0;
		endYear = 0;
	}

	// Primary Constructor for Date Class
	public Date(int staffDobDay, int staffDobMonth, int staffDobYear) 
	{
		this.staffDobDay = staffDobDay;
		this.staffDobMonth = staffDobMonth;
		this.staffDobYear = staffDobYear;
		this.startDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		this.endDay = endDay;
		this.endMonth = endMonth;
		this.endYear = endYear;
	}

        // Copy Constructor for Date Class
	public Date(Date date) 
	{
		staffDobDay= date.staffDobDay;
		staffDobMonth = date.staffDobMonth;
		staffDobYear = date.staffDobYear;
		startDay = date.startDay;
		startMonth = date.startMonth;
		startYear = date.startYear;
		endDay = date.endDay;
		endMonth = date.endMonth;
		endYear = date.endYear;
	}

	// Setters and Getters for Date class
	public int getstaffDobDay() 
	{
		return staffDobDay;
	}


	public void setstaffDobDay(int staffDobDay) 
	{
		this.staffDobDay = staffDobDay;
	}


	public int getstaffDobMonth() 
	{
		return staffDobMonth;
	}


	public void setstaffDobMonth(int staffDobMonth) 
	{
		this.staffDobMonth = staffDobMonth;
	}


	public int getstaffDobYear() 
	{
		return staffDobYear;
	}


	public void setstaffDobYear(int staffDobYear) 
	{
		this.staffDobYear = staffDobYear;
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


        // toString method to convert Date object to string
	@Override
	public String toString() {
		return "Date [staffDobDay=" + staffDobDay + ", staffDobMonth=" + staffDobMonth + ", staffDobYear="
				+ staffDobYear + ", startDay=" + startDay + ", startMonth=" + startMonth + ", startYear=" + startYear
				+ ", endDay=" + endDay + ", endMonth=" + endMonth + ", endYear=" + endYear + "]";
	}


	
		
}