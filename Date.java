package generalinfo;

public class Date 
{
	private int dobDay;
	private int dobMonth;
	private int dobYear;
		
		
	public Date() 
	{	
		dobDay=0;
		dobMonth = 0;
		dobYear = 0;
	}


	public Date(int dobDay, int dobMonth, int dobYear) 
	{
		this.dobDay = dobDay;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
	}
		
	public Date(Date date) 
	{
		dobDay= date.dobDay;
		dobMonth = date.dobMonth;
		dobYear = date.dobYear;
	}


	public int getDobDay() 
	{
		return dobDay;
	}


	public void setDobDay(int dobDay) 
	{
		this.dobDay = dobDay;
	}


	public int getDobMonth() 
	{
		return dobMonth;
	}


	public void setDobMonth(int dobMonth) 
	{
		this.dobMonth = dobMonth;
	}


	public int getDobYear() 
	{
		return dobYear;
	}


	public void setDobYear(int dobYear) 
	{
		this.dobYear = dobYear;
	}


	@Override
	public String toString() 
	{
		return  dobDay + "/" + dobMonth + "/" + dobYear;
	}
		
}
