package generalinfo;

public class TripOrder 
{
	private String invoiceNo;
	private String company;
	private String sourceAddress;
	private String destinationAddress;
	private double rate;
    private String driver;
	private String billedBy;
	
	public TripOrder() {
		
	}

	    
	public TripOrder(String invoiceNo, String company, String sourceAddress, String destinationAddress, double rate, String driver, String billedBy) 
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

	    public String getDriver() 
	    {
	        return driver;
	    }

	    public String getBilledBy() 
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

	    public void setDriver(String driver) 
	    {
	        this.driver = driver;
	    }

	    public void setBilledBy(String billedBy) 
	    {
	        this.billedBy = billedBy;
	    }
	

	    
	    public void Display() 
	    {
	    	System.out.print("TripOrder: InvoiceNo: " + getInvoiceNo()+"\nCompany: " +
	    					getCompany()+"\nSource Address: "+ getSourceAddress()+""
	    					+ "\nDestination Address: "+ getDestinationAddress()+ 
	    					"\nRate: "+ getRate()+"\nDriver: " + getDriver() +"\nBilled By: " + getBilledBy());
	    }
	    
}
