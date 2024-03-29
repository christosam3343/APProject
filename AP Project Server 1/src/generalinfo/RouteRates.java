package generalinfo;

import java.io.Serializable;

public class RouteRates implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String routeName;
	private String source;
	private String destination;
	private Float rate;
	
	public RouteRates() {
		routeName = "";
		source = "";
		destination = "";
		rate = 0.0f;
	}
	
	public RouteRates(String routeName, String source, String destination, Float rate) {
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

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
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
