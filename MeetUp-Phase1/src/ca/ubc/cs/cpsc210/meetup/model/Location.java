package ca.ubc.cs.cpsc210.meetup.model;

import ca.ubc.cs.cpsc210.meetup.util.LatLon;

public class Location {
	
	LatLon latlon;
	String displayText;
	
	public Location(){
		this.latlon = null;
		this.displayText = null;
	}
	
	public void setLatLon(LatLon latlon) {
		this.latlon = latlon;
	}
	
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	
}
