package generalinfo;

import java.io.Serializable;
import java.util.Date;

public class TripOrder implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String invoiceNo;
	private String routeName;
	private String company;
	private String sourceAddress;
	private String destinationAddress;
	private Float rate;
	private Date startDate;
	private Date endDate;
    private String driver;
	private String billedBy;
	
	public TripOrder() {
		
	}

	    
	public TripOrder(String invoiceNo, String routeName, String company, String sourceAddress, String destinationAddress, Float rate, Date startDate, Date endDate, String driver, String billedBy) 
	{
	    this.invoiceNo = invoiceNo;
	    this.routeName = routeName;
	    this.company = company;
	    this.sourceAddress = sourceAddress;
	    this.destinationAddress = destinationAddress;
	    this.rate = rate;
	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.driver = driver;
	    this.billedBy = billedBy;
	 }

	    //Getters
	    public String getInvoiceNo() 
	    {
	        return invoiceNo;
	    }
	    
	    public String getRouteNo() 
	    {
	        return routeName;
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

	    public Float getRate() 
	    {
	        return rate;
	    }
	    
	    public Date getStartDate() {
			return startDate;
		}


		public Date getEndDate() {
			return endDate;
		}

		
	    public String getDriver() 
	    {
	        return driver;
	    }

	    public String getBilledBy() 
	    {
	        return billedBy;
	    }
	    
	    public String getRouteName() 
	    {
	        return routeName;
	    }

	    // Setters
	    public void setInvoiceNo(String invoiceNo) 
	    {
	        this.invoiceNo = invoiceNo;
	    }
	    
	    public void setRouteName(String routeName) 
	    {
	        this.routeName = routeName;
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

	    public void setRate(Float rate) 
	    {
	        this.rate = rate;
	    }

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
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
	    					"\nRate: "+ getRate()+"\nstartDate: "+ getStartDate()+"\nendDate: " + getEndDate()+ "\nDriver: " + getDriver() + "\nBilled By: " + getBilledBy());
	    }
}
