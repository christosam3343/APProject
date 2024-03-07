package generalinfo;

public class Date 
{
	private int staffDobDay;
	private int staffDobMonth;
	private int staffDobYear;
		
		
	public Date() 
	{	
		staffDobDay=0;
		staffDobMonth = 0;
		staffDobYear = 0;
	}


	public Date(int staffDobDay, int staffDobMonth, int staffDobYear) 
	{
		this.staffDobDay = staffDobDay;
		this.staffDobMonth = staffDobMonth;
		this.staffDobYear = staffDobYear;
	}
		
	public Date(Date date) 
	{
		staffDobDay= date.staffDobDay;
		staffDobMonth = date.staffDobMonth;
		staffDobYear = date.staffDobYear;
	}


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


	@Override
	public String toString() 
	{
		return  staffDobDay + "/" + staffDobMonth + "/" + staffDobYear;
	}
		
}
