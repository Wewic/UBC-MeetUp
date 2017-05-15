package ca.ubc.cs.cpsc210.meetup.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

	protected String code;
	protected int number;
	protected List<Section> sections = new ArrayList<Section>();

	public Course (String code, int number) {
		this.code = code;
		this.number = number;
	}

	public boolean isSectionInList (Section section) {
		for (Section s : sections) {
			if (s.equals(section)) {
				return true;
			}
		}
		return false;
	}

	public void addSection(Section section) {
		if(isSectionInList(section) == false) {
			sections.add(section);
		}
	}

	public Section getSection(String sectionId){
		Section sectionWithId = null;
		
		for (Section s : sections) {
			if (s.getName() == sectionId) {
				s = sectionWithId;
			}
		}
		return sectionWithId;
	}
	
	public int getNumber() {
		return this.number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + number;
		result = prime * result
				+ ((sections == null) ? 0 : sections.hashCode());
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
		Course other = (Course) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (number != other.number)
			return false;
		if (sections == null) {
			if (other.sections != null)
				return false;
		} else if (!sections.equals(other.sections))
			return false;
		return true;
	}
	
	
}

