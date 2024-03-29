package generalinfo;

import java.io.Serializable;

public class RouteRates implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public String getrouteName() {
		return routeName;
	}

	public void setrouteName(String routeName) {
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

	public void Display() 
	{
		System.out.println("Route Name: " + routeName + 
				" \nSource: " + source + 
				" \nDestination: " + destination + 
				" \nRate: " + rate);
	}

	

}
