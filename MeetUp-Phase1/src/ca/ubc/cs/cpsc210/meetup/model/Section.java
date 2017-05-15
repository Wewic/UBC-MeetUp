package ca.ubc.cs.cpsc210.meetup.model;

import ca.ubc.cs.cpsc210.meetup.exceptions.IllegalCourseTimeException;
import ca.ubc.cs.cpsc210.meetup.exceptions.IllegalSectionInitialization;
import ca.ubc.cs.cpsc210.meetup.util.CourseTime;

/**
 * Represent a section for a course
 */
public class Section implements Comparable<Section> {

	// TODO: Add necessary fields
	
	// Time of course is provided to implement comparable
	private CourseTime timeOfCourse;
	
	protected Course course;
	
	protected String name;
	protected String day;
	protected String startTime;
	protected String endTime;
	protected Building building;

	/**
	 * Constructor 
	 * REQUIRES: name is not null, day is "MWF" or "TR", startTime
	 *   is before endTime and building is not null 
	 * EFFECTS: object is initialized
	 *   or the exception IllegalSectionInitialization has occurred
	 * @throws IllegalSectionInitialization 
	 */
	public Section(String name, String day, String startTime, String endTime,
			Building building) throws IllegalSectionInitialization {
		// TODO: Complete implementation of this constructor
		int indexOfStartColon = startTime.indexOf(":");
		int startHours = Integer.parseInt(startTime.substring(0, indexOfStartColon));
		int startMinutes = Integer.parseInt(startTime.substring(indexOfStartColon + 1,
				startTime.length()));
		int indexOfEndColon = endTime.indexOf(":");
		int endHours = Integer.parseInt(endTime.substring(0, indexOfEndColon));
		int endMinutes = Integer.parseInt(endTime.substring(indexOfEndColon + 1,
				endTime.length()));
		
		if (name == null) {
			throw new IllegalSectionInitialization("Invalid name");
		}
		if (!day.equals("MWF") && !day.equals("TR")) {
			throw new IllegalSectionInitialization("Invalid day");
		}
		if (building == null) {
			throw new IllegalSectionInitialization("Invalid building");
		}
		if (startHours > endHours)
			throw new IllegalSectionInitialization(
					"Start time must be less than end time.");
		else if (startHours == endHours && startMinutes > endMinutes)
			throw new IllegalSectionInitialization(
					"Start time must be less than end time.");
		this.name = name;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.building = building;
	}

	// TODO: Add necessary methods
	public String getName() {
		return name;
	}
	
	public String getDay(){
		return day;
	}
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	@Override
	public int compareTo(Section o) {
		return timeOfCourse.compareTo(o.timeOfCourse);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((timeOfCourse == null) ? 0 : timeOfCourse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (timeOfCourse == null) {
			if (other.timeOfCourse != null)
				return false;
		} else if (!timeOfCourse.equals(other.timeOfCourse))
			return false;
		return true;
	}

}
