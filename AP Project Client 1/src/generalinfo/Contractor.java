package generalinfo;

// Contractor Class inheriting from the Staff class
class Contractor extends Staff {
    // Declaration of Variables
    private int tripsMade;
    private double earningsPerTrip;
    private boolean isAvailable;

    	// Primary constructor of Staff class implementation and Constructor class 
	public Contractor(int staffID, String staffFirstName, String staffLastName, Date staffDob, String staffAddress1, String staffAddress2, String staffPostOffice, String staffParish, String staffTelephone, String staffEmail, String staffPosition, boolean staffStatus, int tripsMade, double earningsPerTrip, boolean isAvailable) {
        super(); // Superclass Inheritance
        this.tripsMade = tripsMade;
        this.earningsPerTrip = earningsPerTrip;
        this.isAvailable = isAvailable;
    }

    // Setters and Getters for Constructor class
    public int getTripsMade() {
		return tripsMade;
	}


	public void setTripsMade(int tripsMade) {
		this.tripsMade = tripsMade;
	}


	public double getEarningsPerTrip() {
		return earningsPerTrip;
	}


	public void setEarningsPerTrip(double earningsPerTrip) {
		this.earningsPerTrip = earningsPerTrip;
	}


	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// Method to increment tripsMade by 1
	public void addTrip() {
        tripsMade++;
    }

    // Method to calculate total earnings based on trips made and earnings per trip
    public double calculateEarnings() {
        return tripsMade * earningsPerTrip;
    }

}