package generalinfo;

import java.io.Serializable;

public class TripOrder  implements Serializable
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
    private String driver;
	private String billedBy;
	
	public TripOrder() {
		
	}

	    
	public TripOrder(String invoiceNo, String routeName, String company, String sourceAddress, String destinationAddress, Float rate, String driver, String billedBy) 
	{
	    this.invoiceNo = invoiceNo;
	    this.routeName = routeName;
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
	    
	    public String getRouteName() 
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


		@Override
		public String toString() {
			return "TripOrder [invoiceNo=" + invoiceNo + ", routeName=" + routeName + ", company=" + company
					+ ", sourceAddress=" + sourceAddress + ", destinationAddress=" + destinationAddress + ", rate="
					+ rate + ", driver=" + driver + ", billedBy=" + billedBy + "]";
		}
	    
}
