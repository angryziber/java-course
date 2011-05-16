package net.azib.java.students.t092877.homework;

import java.util.ArrayList;
import java.util.List;


public class Competition {

	private String name;
	private String location;
	private String date;
	private List<Athlete> athletesList = new ArrayList<Athlete>();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Athlete> getAthletesList() {
		return athletesList;
	}
	public void setAthletesList(List<Athlete> athletesList) {
		this.athletesList = athletesList;
	}
}

