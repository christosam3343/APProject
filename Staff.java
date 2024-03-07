package generalinfo;

import java.util.Date;

public class Staff 
{
	 	private int staffID;
	    private String firstName;
	    private String lastName;
	    private Date dob; 
	    private Address address1;
	    private Address address2;
	    private String postOffice;
	    private String parish;
	    private String telephone;
	    private String email;
	    private String position;
	    private boolean status;

	    // Constructor
	    public Staff(int staffID, String firstName, String lastName, Date dob, Address address1, Address address2, String postOffice, String parish, String telephone, String email, String position, boolean status) 
	    {
	        this.staffID = staffID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.dob = dob;
	        this.address1 = address1;
	        this.address2 = address2;
	        this.postOffice = postOffice;
	        this.parish = parish;
	        this.telephone = telephone;
	        this.email = email;
	        this.position = position;
	        this.status = status;
	    }
	    
	    public Staff() 
	    {
	        this.staffID = 0;
	        this.firstName = "";
	        this.lastName = "";
	        this.dob = new Date();
	        this.address1 = new Address();
	        this.address2 = new Address();
	        this.postOffice = "";
	        this.parish = "";
	        this.telephone = "000-000-0000";
	        this.email = "";
	        this.position = "";
	        this.status = false;
	    	
	    }
	    
	    public Staff(Staff staff) {
	    	 this.staffID = staff.staffID;
	         this.firstName = staff.firstName;
	         this.lastName = staff.lastName;
	         this.dob = staff.dob;
	         this.address1 = staff.address1;
	         this.address2 = staff.address2;
	         this.postOffice = staff.postOffice;
	         this.parish = staff.parish;
	         this.telephone = staff.telephone;
	         this.email = staff.email;
	         this.position = staff.position;
	         this.status = staff.status;
	    }
	    
	    // Getters and setters
	    public int getStaffID() {
	        return staffID;
	    }

	    public void setStaffID(int staffID) {
	        this.staffID = staffID;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public Date getDob() {
	        return dob;
	    }

	    public void setDob(Date dob) {
	        this.dob = dob;
	    }

	    public Address getAddress1() {
	        return address1;
	    }

	    public void setAddress1(Address address1) {
	        this.address1 = address1;
	    }

	    public Address getAddress2() {
	        return address2;
	    }

	    public void setAddress2(Address address2) {
	        this.address2 = address2;
	    }

	    public String getPostOffice() {
	        return postOffice;
	    }

	    public void setPostOffice(String postOffice) {
	        this.postOffice = postOffice;
	    }

	    public String getParish() {
	        return parish;
	    }

	    public void setParish(String parish) {
	        this.parish = parish;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPosition() {
	        return position;
	    }

	    public void setPosition(String position) {
	        this.position = position;
	    }

	    public boolean getStatus() {
	        return status;
	    }

	    public void setStatus(boolean status) {
	        this.status = status;
	    }

	    
	    @Override
	    public String toString() {
	        return "Staff:" +
	                "\nStaffID=" + staffID +
	                "\nFirstName='" + firstName  +
	                "\nLastName='" + lastName  +
	                "\nDob=" + dob +
	                "\nAddress1='" + address1  +
	                "\nAddress2='" + address2  +
	                "\nPostOffice='" + postOffice  +
	                "\nParish='" + parish  +
	                "\nTelephone='" + telephone  +
	                "\nEmail='" + email  +
	                "\nPosition='" + position  +
	                "\nStatus='" + status;   
	    }
}
