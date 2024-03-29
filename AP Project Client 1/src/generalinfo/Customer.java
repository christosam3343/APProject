package generalinfo;

import java.io.Serializable;

// Customer class inheriting from the Serializable class
public class Customer implements Serializable 
{
        // Serial Version UID for serialization
	private static final long serialVersionUID = 1L;
	// Declaration of Variables
	private int CustId;
	private String company;
	private String contactPerson;
	private String custAddress1;
	private String custAddress2;
	private String custPostOffice;
	private String custParish;
	private String custTelephone;
	private String custEmail;
	private float custBalance;
	private boolean custStatus;
		
		// Default Constructor for Customer class
		public Customer() 
		{
			super();
			CustId = 0;
			this.company = "";
			this.contactPerson = "";
			this.custAddress1 = "";
			this.custAddress2 = "";
			this.custPostOffice = "";
			this.custParish = "";
			this.custTelephone = "";
			this.custEmail = "";
			this.custBalance = 0.00f;
			this.custStatus = false;
		}

		// Primary Constructor for the Customer class
		public Customer(int custId, String company, String contactPerson, String custAddress1, String custAddress2, String custPostOffice, String custParish, String custTelephone, String custEmail,float custBalance, boolean custStatus) 
		{
			super();
			CustId = custId;
			this.company = company;
			this.contactPerson = contactPerson;
			this.custAddress1 = custAddress1;
			this.custAddress2 = custAddress2;
			this.custPostOffice = custPostOffice;
			this.custParish = custParish;
			this.custTelephone = custTelephone;
			this.custEmail = custEmail;
			this.custBalance = custBalance;
			this.custStatus = custStatus;
		}
		
		// Setters and Getters for the Customer class
		public float getCustBalance() {
			return custBalance;
		}

		public void setCustBalance(float custBalance) {
			this.custBalance = custBalance;
		}

		public int getCustId() 
		{
			return CustId;
		}
		
		public void setCustId(int custId) 
		{
			CustId = custId;
		}
		
		public String getCompany() 
		{
			return company;
		}
		
		public void setCompany(String company) 
		{
			this.company = company;
		}
		
		public String getContactPerson() 
		{
			return contactPerson;
		}
		
		public void setContactPerson(String contactPerson) 
		{
			this.contactPerson = contactPerson;
		}
		
		public String getCustAddress1() 
		{
			return custAddress1;
		}
		
		public void setCustAddress1(String custAddress1) 
		{
			this.custAddress1 = custAddress1;
		}
		
		public String getCustAddress2() 
		{
			return custAddress2;
		}
		
		public void setCustAddress2(String custAddress2) 
		{
			this.custAddress2 = custAddress2;
		}
		
		public String getCustPostOffice() 
		{
			return custPostOffice;
		}
		
		public void setCustPostOffice(String custPostOffice) 
		{
			this.custPostOffice = custPostOffice;
		}
		public String getCustParish() 
		{
			return custParish;
		}
		public void setCustParish(String custParish) 
		{
			this.custParish = custParish;
		}
		public String getCustTelephone() 
		{
			return custTelephone;
		}
		
		public void setCustTelephone(String custTelephone) 
		{
			this.custTelephone = custTelephone;
		}
		
		public String getCustEmail() 
		{
			return custEmail;
		}
		
		public void setCustEmail(String custEmail) 
		{
			this.custEmail = custEmail;
		}
		
		public boolean getCustStatus() 
		{
			return custStatus;
		}
		
		public void setCustStatus(boolean custStatus) 
		{
			this.custStatus = custStatus;
		}
		
                // Display method to output customer information
		public void Display() {
			System.out.println( "Staff: " +
	                "\nCustomerID: " + CustId +
	                "\nCompanyName: " + company  +
	                "\nContactPersonName: " + contactPerson  +
	                "\nCustomerAddress1: " + custAddress1 +
	                "\nCustomerAddress2: " + custAddress2  +
	                "\nCustomerPostOffice: " + custPostOffice  +
	                "\nCutomerParish: " + custParish  +
	                "\nCustomerTelephone: " + custTelephone  +
	                "\nCustomerEmail: " + custEmail  +
	                "\nCustomerBalance: " + custBalance  +
	                "\nCustomerStatus: " + custStatus); 
			
		}
		
}
