package ca.ubc.cs.cpsc210.meetup.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.ubc.cs.cpsc210.meetup.util.LatLon;

/*
 * Provide a factory for places that have been "seen"
 */
public class PlaceFactory {

	// TODO: Complete the implementation of this class
	
	// NOTE: A place may not have a unique name. The combination
	// of name, lat and lon is unique.
	

	// Remember all the courses that have been defined. The key is the course code (e.g., all CPSC courses)
	//TODO
	private Map<String, Set<Place>> places;
	
	// Singleton pattern
	private static PlaceFactory instance = null;
	
	/**
	 * Return the factory instance
	 * EFFECTS: Returns a factory for looking up a course
	 */
	public static PlaceFactory getInstance() {
		if (instance == null)
			instance = new PlaceFactory();
		return instance;
	}
	
	/**
	 * Reset for testing
	 */
	public static void reset() {
		instance = null;
	}

	/**
	 * Constructor. Only the singleton needs to create.
	 */
	protected PlaceFactory() {
		places = new HashMap<String, Set<Place>>();
	}

	/**
	 * Retrieve a course, create the course if it hasn't been seen before
	 * REQUIRES: code != null and code.length() > 0 and number > 0
	 * MODIFIES: this
	 * EFFECTS: Returns a non-null course that this object will remember
	 */
	public Place getPlace(String name, LatLon latlon) {
		// Get the courses with a given code from the map
		Set<Place> placesWithLatLon = places.get(name);

		// The course doesn't exist, add it
		if (placesWithLatLon == null)
			return addPlace(name, latlon);
		
		// Is there a course with the given number?
		Place placeOfInterest = null;
		for (Place aPlace : placesWithLatLon) {
			if (aPlace.getLatLon() == latlon)
				placeOfInterest = aPlace;
		}

		if (placeOfInterest != null) {
			// There is a course, return it
			return placeOfInterest;
		} else {
			return addPlace(name, latlon);
		}

	}
	
	/**
	 * Helper method to add a course
	 */
	private Place addPlace(String name, LatLon latlon) {
		// Create the Course
		Place place = new Place(name, latlon);
		
		// See if we need to add it to the set of courses keyed only on four letter code
		if (places.containsKey(name)) {
			Set<Place> placeWithCode = places.get(name);
			placeWithCode.add(place);
		} else {
			Set<Place> placesWithCode = new HashSet<Place>();
			placesWithCode.add(place);
			places.put(name, placesWithCode);
		}
		return place;
	}


}
