package generalinfo;

public class FinalReport 
{
	// Declaration of Variables
	int payId;
	int staffId;
	Date startDate;
	Date endDate;
	float contractorSalary;
	float driverSalary;
	String preparedBy;
	
	// Default Consturcotr for FinalReport class
	public FinalReport()
	{
		super();
		this.payId = 0;
		this.staffId = 0;
		this.startDate = new Date();
		this.endDate = new Date();
		this.contractorSalary = 0.0f;
		this.driverSalary = 0.0f;
		this.preparedBy = "";
	}
	
	// Primary Constructor for FinalReport class
	public FinalReport(int payId, int staffId, Date startDate, Date endDate, float contractorSalary, float driverSalary,
			String preparedBy) 
	{
		super();
		this.payId = payId;
		this.staffId = staffId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contractorSalary = contractorSalary;
		this.driverSalary = driverSalary;
		this.preparedBy = preparedBy;
	}

        // Setters and getting for FinalReport class
	public int getPayId() 
	{
		return payId;
	}

	public void setPayId(int payId) 
	{
		this.payId = payId;
	}

	public int getStaffId() 
	{
		return staffId;
	}

	public void setStaffId(int staffId) 
	{
		this.staffId = staffId;
	}

	public Date getStartDate() 
	{
		return startDate;
	}

	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}

	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	public float getContractorSalary() 
	{
		return contractorSalary;
	}

	public void setContractorSalary(float contractorSalary) 
	{
		this.contractorSalary = contractorSalary;
	}

	public float getDriverSalary() 
	{
		return driverSalary;
	}

	public void setDriverSalary(float driverSalary) 
	{
		this.driverSalary = driverSalary;
	}

	public String getPreparedBy() 
	{
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) 
	{
		this.preparedBy = preparedBy;
	}

        // toString method to convert FinalReport object to string
	@Override
	public String toString() 
	{
		return "FinalReport [payId=" + payId + ", staffId=" + staffId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", contractorSalary=" + contractorSalary + ", driverSalary=" + driverSalary
				+ ", preparedBy=" + preparedBy + "]";
	}
	
}
