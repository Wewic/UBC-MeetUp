package ca.ubc.cs.cpsc210.meetup.parser;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import ca.ubc.cs.cpsc210.meetup.exceptions.IllegalStudentException;
import ca.ubc.cs.cpsc210.meetup.model.Section;
import ca.ubc.cs.cpsc210.meetup.model.Student;
import ca.ubc.cs.cpsc210.meetup.model.StudentManager;

/**
 * Parse XML of a schedule (Sax parser)
 */

public class ScheduleParser extends DefaultHandler {

	StudentManager manager;
	String lastName;
	String firstName;
	int id;
	int studentId;
	Section section;
	Student student;

	private StringBuffer accumulator;

	// TODO: Add necessary fields

	public ScheduleParser(StudentManager manager) {
		// TODO: Complete implementation of this constructor
		this.manager = manager;
	}

	/**
	 * Called at the start of the document (as the name suggests)
	 */
	@Override
	public void startDocument() {
		// TODO: Complete implementation of this method
		System.out.println("Starting document");
	}

	/**
	 * Called when the parsing of an element starts. (e.g., <book>)
	 * 
	 * Lookup documentation to learn meanings of parameters.
	 */
	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) {
		// TODO: Complete implementation of this method
		System.out.println("Starting element: " + qName);
		if (qName.toLowerCase().equals("lastname")) {
			lastName = null;
		}
		if (qName.toLowerCase().equals("firstname")) {
			firstName = null;
		}
		if (qName.toLowerCase().equals("id")) {
			id = 0;
		}
		if (qName.toLowerCase().equals("section")) {
			section = null;
		}
	}

	/**
	 * Called for values of elements
	 * 
	 * Lookup documentation to learn meanings of parameters.
	 */
	public void characters(char[] temp, int start, int length) {
		// Remember the value parsed
		accumulator.append(temp, start, length);
	}

	/**
	 * Called when the end of an element is seen. (e.g., </title>)
	 * 
	 * Lookup documentation to learn meanings of parameters.
	 */
	public void endElement(String uri, String localName, String qName) {
		// TODO: Complete implementation of this method
		
		System.out.println("Ending element: " + qName);
		if (qName.toLowerCase().equals("lastname")) {
			if (accumulator.toString().equals("")) {
				try {
					throw new IllegalStudentException("Student has no last name");
				} catch (IllegalStudentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			lastName = accumulator.toString();
		} else if (qName.toLowerCase().equals("firstname")) {
			if (accumulator.toString().equals("")) {
				try {
					throw new IllegalStudentException("Student has no first name");
				} catch (IllegalStudentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			firstName = accumulator.toString();
		} else if (qName.toLowerCase().equals("id")) {
			id = Integer.parseInt(accumulator.toString());;
		} else if (qName.toLowerCase().equals("student")) {
			student = new Student(lastName, firstName, id);
		} 		
		else if (qName.toLowerCase().equals("schedule")) {
			
		}
		accumulator.setLength(0);
	}

}
