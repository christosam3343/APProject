package generalinfo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer")
public class Customer implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int CustId;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "contactPerson")
	private String contactPerson;
	
	@Column(name = "custAddress1")
	private String custAddress1;
	
	@Column(name = "custAddress2")
	private String custAddress2;
	
	@Column(name = "custPostOffice")
	private String custPostOffice;
	
	@Column(name = "custParish")
	private String custParish;
	
	@Column(name = "custTelephone")
	private String custTelephone;
	
	@Column(name = "custEmail")
	private String custEmail;
	
	@Column(name = "custBalance")
	private float custBalance;
	
	@Column(name = "custStatus")
	private boolean custStatus;
		
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
		
		public boolean isCustStatus() 
		{
			return custStatus;
		}
		
		public void setCustStatus(boolean custStatus) 
		{
			this.custStatus = custStatus;
		}
		
		
		public void Display() 
		{
			System.out.println("Customer ID: " + CustId + 
					" \nCompany Name: " + company + 
					" \nContact Person: " + contactPerson + 
					" \nCustomer Address 1: " + custAddress1 + 
					" \nCustomer Address 2: " + custAddress2 + 
					" \nCustomer Post Office: " + custPostOffice + 
					" \nCustomer Parish: " + custParish + 
					" \nCustomer Telephone: " + custTelephone + 
					" \nCustomer Email: " + custEmail + 
					" \nCustomer Status: " + custStatus +
					" \nCustomer Balnce: " + custBalance);
		}
		
}
