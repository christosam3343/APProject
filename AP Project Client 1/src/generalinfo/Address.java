package generalinfo;

public class Address 
{
	// Declaration of Variables
	private String address1;
	private String address2;
	private String city;
	private String postalCode;
		
	// Default Constructor for the Address class
	public Address() 
	{	
		address1 = "";
		address2 = "";
		city = "";
		postalCode = "";
	}

	// Primary constructor for the Address class
	public Address(String address1, String address2, String city, String postalCode) 
	{
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postalCode = postalCode;
	}

	
	public Address(Address address) 
	{
		this.address1 = address.address1;
		this.address2 = address.address2;
		this.city = address.city;
		this.postalCode = address.postalCode;
	}
	
	// Setters and Getters for the Address class
	public String getAddress1() 
	{
		return address1;
	}


	public void setAddress1(String address1) 
	{
		this.address1 = address1;
	}


	public String getAddress2() 
	{
		return address2;
	}


	public void setAddress2(String address2) 
	{
		this.address2 = address2;
	}


	public String getCity() 
	{
		return city;
	}


	public void setCity(String city) 
	{
		this.city = city;
	}


	public String getPostalCode() 
	{
		return postalCode;
	}


	public void setPostalCode(String postalCode) 
	{
		this.postalCode = postalCode;
	}

	// To String Method for the address Class
	@Override
	public String toString() 
	{
		return "Address 1: " + address1 + 
			   "Address 2:" + address2 + 
			   "City: " + city + 
			   "Postal Code: " + postalCode;
	}
	
}
