package generalinfo;

public class TripOrder 
{
	private String invoiceNo;
	private String company;
	private String sourceAddress;
	private String destinationAddress;
	private double rate;
    	private Contractor driver;
	private Admin billedBy;

	    
	public TripOrder(String invoiceNo, String company, String sourceAddress, String destinationAddress, double rate, Driver driver, Admin billedBy) 
	{
	    this.invoiceNo = invoiceNo;
	    this.company = company;
	    this.sourceAddress = sourceAddress;
	    this.destinationAddress = destinationAddress;
	    this.rate = rate;
	    this.driver = driver;
	    this.billedBy = billedBy;
	 }

	    //Getters
	    public String getInvoiceNo() 
	    {
	        return invoiceNo;
	    }

	    public String getCompany() 
	    {	
	        return company;
	    }

	    public String getSourceAddress() 
	    {
	        return sourceAddress;
	    }

	    public String getDestinationAddress() 
	    {
	        return destinationAddress;
	    }

	    public double getRate() 
	    {
	        return rate;
	    }

	    public Driver getDriver() 
	    {
	        return driver;
	    }

	    public Admin getBilledBy() 
	    {
	        return billedBy;
	    }

	    // Setters
	    public void setInvoiceNo(String invoiceNo) 
	    {
	        this.invoiceNo = invoiceNo;
	    }

	    public void setCompany(String company) 
	    {
	        this.company = company;
	    }

	    public void setSourceAddress(String sourceAddress) 
	    {
	        this.sourceAddress = sourceAddress;
	    }

	    public void setDestinationAddress(String destinationAddress) 
	    {
	        this.destinationAddress = destinationAddress;
	    }

	    public void setRate(double rate) 
	    {
	        this.rate = rate;
	    }

	    public void setDriver(Driver driver) 
	    {
	        this.driver = driver;
	    }

	    public void setBilledBy(Admin billedBy) 
	    {
	        this.billedBy = billedBy;
	    }
	

	    @Override
	    public String toString() 
	    {
	        return "TripOrder: " +
	                "\ninvoiceNo: " + invoiceNo +
	                "\ncompany: " + company +
	                "\n sourceAddress: " + sourceAddress +
	                "\ndestinationAddress: " + destinationAddress + 
	                "\nrate: " + rate +
	                "\ndriver: " + driver +
	                "\nbilledBy: " + billedBy;
	    }
	    
}
