package generalinfo;

public class RouteRates {
	private String routeName;
	private String source;
	private String destination;
	private double rate;
	
	public RouteRates() {
		routeName = "";
		source = "";
		destination = "";
		rate = 465.00;
	}
	
	public RouteRates(String routeName, String source, String destination, double rate) {
		super();
		this.routeName = routeName;
		this.source = source;
		this.destination = destination;
		this.rate = rate;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
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
		return "routeRates [routeName=" + routeName + ", source=" + source + ", destination=" + destination
				+ ", rate=" + rate + "]";
	}
	

}
