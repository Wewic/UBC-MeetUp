package ca.ubc.cs.cpsc210.meetup.model;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.cs.cpsc210.meetup.util.LatLon;

public class Place extends Location {

	protected String name;
	protected LatLon latlon;
	protected List<String> tags = new ArrayList<String>();
	
	public Place (String name, LatLon latlon) {
		this.name = name;
		this.latlon = latlon;
	}
	
	public Place (String name) {
		this.name = name;
	}
	
	public LatLon getLatLon() {
		return latlon;
	}
	
	public void addTag(String tag){
		tags.add(tag);
	}
	
	public boolean containsTag(String tag) {
		return tags.contains(tag);
	}
	
}
