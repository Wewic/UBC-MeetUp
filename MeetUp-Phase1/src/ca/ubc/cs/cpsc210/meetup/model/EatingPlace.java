package ca.ubc.cs.cpsc210.meetup.model;

import ca.ubc.cs.cpsc210.meetup.util.LatLon;

public class EatingPlace extends Place {
	
	protected String tag;
	
	public EatingPlace(String name, LatLon latlon){
		super(name, latlon);
		this.tag = "food";
	}
	
	public EatingPlace(String name) {
		super(name);
		this.tag = "food";
	}

}
