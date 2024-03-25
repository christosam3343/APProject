package generalinfo;

class Contractor extends Staff {
    private int tripsMade;
    private double earningsPerTrip;
    private boolean isAvailable;

    public Contractor(int staffID, String staffFirstName, String staffLastName, Date staffDob, String staffAddress1, String staffAddress2, String staffPostOffice, String staffParish, String staffTelephone, String staffEmail, String staffPosition, boolean staffStatus, int tripsMade, double earningsPerTrip, boolean isAvailable) {
        super();
        this.tripsMade = tripsMade;
        this.earningsPerTrip = earningsPerTrip;
        this.isAvailable = isAvailable;
    }


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

	public void addTrip() {
        tripsMade++;
    }

    public double calculateEarnings() {
        return tripsMade * earningsPerTrip;
    }

}