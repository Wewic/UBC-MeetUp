package ca.ubc.cs.cpsc210.meetup.model;

public class Student {
	
	protected String lastName;
	protected String firstName;
	protected int id;
	protected Schedule schedule;
	
	public Student(String lastName, String firstName, int id) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.schedule = new Schedule();
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(Schedule s) {
		this.schedule = s;
	}
}
