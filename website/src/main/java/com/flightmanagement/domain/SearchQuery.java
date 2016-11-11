package com.flightmanagement.domain;
 

public class SearchQuery {
	String origin;
	String destination;
	String flightDate;

	public SearchQuery() {
		super();
	}

	@Override
	public String toString() {
		return String.format("SearchQuery [origin=%s, destination=%s, flightDate=%s]", origin, destination, flightDate);
	}

	public SearchQuery(String origin, String destination, String flightDate) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
	}

	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	
	
}