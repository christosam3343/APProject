package generalinfo;
import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable
{
	 private int staffID;
	 private String staffFirstName;
	 private String staffLastName;
	 private String staffDob; 
	 private String staffAddress1;
	 private String staffAddress2;
	 private String staffPostOffice;
	 private String staffParish;
	 private String staffTelephone;
	 private String staffEmail;
	 private String staffPosition;
	 private boolean staffStatus;


	 public Staff(int staffID, String staffFirstName, String staffLastName, String staffDob, String staffAddress1, String staffAddress2, String staffPostOffice, String staffParish, String staffTelephone, String staffEmail, String staffPosition, boolean staffStatus) 
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
	    this.staffDob = "";
	    this.staffAddress1 = "";
	    this.staffAddress2 = "";
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

	    public String getstaffDob() 
	    {
	        return staffDob;
	    }

	    public void setstaffDob(String staffDob) 
	    {
	        this.staffDob = staffDob;
	    }

	    public String getstaffAddress1() 
	    {
	        return staffAddress1;
	    }

	    public void setstaffAddress1(String staffAddress1) 
	    {
	        this.staffAddress1 = staffAddress1;
	    }

	    public String getstaffAddress2() 
	    {
	        return staffAddress2;
	    }

	    public void setstaffAddress2(String staffAddress2) 
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

	    
	    public void Display() 
	    {
	         System.out.println( "Staff: " +
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
	                "\nstaffStatus: " + staffStatus);   
	    }

}
