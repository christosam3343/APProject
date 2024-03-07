package generalinfo;

import java.util.Date;

public class Staff 
{
	 private int staffID;
	 private String staffFirstName;
	 private String staffLastName;
	 private Date staffDob; 
	 private Address staffAddress1;
	 private Address staffAddress2;
	 private String staffPostOffice;
	 private String staffParish;
	 private String staffTelephone;
	 private String staffEmail;
	 private String staffPosition;
	 private boolean staffStatus;


	 public Staff(int staffID, String staffFirstName, String staffLastName, Date staffDob, Address staffAddress1, Address staffAddress2, String staffPostOffice, String staffParish, String staffTelephone, String staffEmail, String staffPosition, boolean staffStatus) 
	 {
	   this.staffID = staffID;
	   this.staffFirstName = staffFirstName;
	   this.staffLastName = staffLastName;
	   this.staffDob = staffDob;
	   this.staffAddress1 = staffAddress1;
	   this.staffAddress2 = staffAddress2;
	   this.staffPostOffice = staffPostOffice;
	   this.staffParish = staffParish;
	   this.staffTelephone = staffTelephone;
	   this.staffEmail = staffEmail;
	   this.staffPosition = staffPosition;
	   this.staffStatus = staffStatus;
	  }
	    
	  public Staff() 
	  {
	    this.staffID = 0;
	    this.staffFirstName = "";
	    this.staffLastName = "";
	    this.staffDob = new Date();
	    this.staffAddress1 = new Address();
	    this.staffAddress2 = new Address();
	    this.staffPostOffice = "";
	    this.staffParish = "";
	    this.staffTelephone = "000-000-0000";
	    this.staffEmail = "";
	    this.staffPosition = "";
	    this.staffStatus = false;
	    	
	    }
	    
	    public Staff(Staff staff) 
	    {
	    	 this.staffID = staff.staffID;
	         this.staffFirstName = staff.staffFirstName;
	         this.staffLastName = staff.staffLastName;
	         this.staffDob = staff.staffDob;
	         this.staffAddress1 = staff.staffAddress1;
	         this.staffAddress2 = staff.staffAddress2;
	         this.staffPostOffice = staff.staffPostOffice;
	         this.staffParish = staff.staffParish;
	         this.staffTelephone = staff.staffTelephone;
	         this.staffEmail = staff.staffEmail;
	         this.staffPosition = staff.staffPosition;
	         this.staffStatus = staff.staffStatus;
	    }
	    
	    public int getStaffID() 
	    {
	        return staffID;
	    }

	    public void setStaffID(int staffID) 
	    {
	        this.staffID = staffID;
	    }

	    public String getstaffFirstName() 
	    {
	        return staffFirstName;
	    }

	    public void setstaffFirstName(String staffFirstName) 
	    {
	        this.staffFirstName = staffFirstName;
	    }

	    public String getstaffLastName() 
	    {
	        return staffLastName;
	    }

	    public void setstaffLastName(String staffLastName) 
	    {
	        this.staffLastName = staffLastName;
	    }

	    public Date getstaffDob() 
	    {
	        return staffDob;
	    }

	    public void setstaffDob(Date staffDob) 
	    {
	        this.staffDob = staffDob;
	    }

	    public Address getstaffAddress1() 
	    {
	        return staffAddress1;
	    }

	    public void setstaffAddress1(Address staffAddress1) 
	    {
	        this.staffAddress1 = staffAddress1;
	    }

	    public Address getstaffAddress2() 
	    {
	        return staffAddress2;
	    }

	    public void setstaffAddress2(Address staffAddress2) 
	    {
	        this.staffAddress2 = staffAddress2;
	    }

	    public String getstaffPostOffice() {
	        return staffPostOffice;
	    }

	    public void setstaffPostOffice(String staffPostOffice) 
	    {
	        this.staffPostOffice = staffPostOffice;
	    }

	    public String getstaffParish() 
	    {
	        return staffParish;
	    }

	    public void setstaffParish(String staffParish) 
	    {
	        this.staffParish = staffParish;
	    }

	    public String getstaffTelephone() 
	    {
	        return staffTelephone;
	    }

	    public void setstaffTelephone(String staffTelephone) 
	    {
	        this.staffTelephone = staffTelephone;
	    }

	    public String getstaffEmail() 
	    {
	        return staffEmail;
	    }

	    public void setstaffEmail(String staffEmail) 
	    {
	        this.staffEmail = staffEmail;
	    }

	    public String getstaffPosition() 
	    {
	        return staffPosition;
	    }

	    public void setstaffPosition(String staffPosition) 
	    {
	        this.staffPosition = staffPosition;
	    }

	    public boolean getstaffStatus() 
	    {
	        return staffStatus;
	    }

	    public void setstaffStatus(boolean staffStatus) 
	    {
	        this.staffStatus = staffStatus;
	    }

	    
	    @Override
	    public String toString() 
	    {
	        return "Staff: " +
	                "\nStaffID: " + staffID +
	                "\nstaffFirstName: " + staffFirstName  +
	                "\nstaffLastName: " + staffLastName  +
	                "\nstaffDob: " + staffDob +
	                "\nstaffAddress1: " + staffAddress1  +
	                "\nstaffAddress2: " + staffAddress2  +
	                "\nstaffPostOffice: " + staffPostOffice  +
	                "\nstaffParish: " + staffParish  +
	                "\nstaffTelephone: " + staffTelephone  +
	                "\nstaffEmail: " + staffEmail  +
	                "\nstaffPosition: " + staffPosition  +
	                "\nstaffStatus: " + staffStatus;   
	    }
	public void calculateSalary(){
		
	}
}
