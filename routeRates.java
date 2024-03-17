package domain;

public class routeRates {
	private int routeNumber;
	private String source;
	private String destination;
	private double rate;
	
	public routeRates() {
		routeNumber = 343;
		source = "";
		destination = "";
		rate = 465.00;
	}
	
	public routeRates(int routeNumber, String source, String destination, double rate) {
		super();
		this.routeNumber = routeNumber;
		this.source = source;
		this.destination = destination;
		this.rate = rate;
	}

	public int getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "routeRates [routeNumber=" + routeNumber + ", source=" + source + ", destination=" + destination
				+ ", rate=" + rate + "]";
	}
	

}
