package net.azib.java.students.t103784.homework;

public class Athlete {

	private String name, birthDate, country, place;
	private String[] events = {"100 meter dash(s): ", "Long jump(m): ", "Shot Put(m): ", "High jump(m): ", "400 meter race(s): ", "110 meter hurdles(s): ", "Discus throw(m): ", "Pole vault(m): ", "Javelin throw(m): ", "1500 meter race(s): "};
	private double[] performance = {0,0,0,0,0,0,0,0,0,0};
	private int score;

	public String getEvents(int i) {return events[i];}

	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}

	public String getPlace() {return place;}
	public void setPlace(String place) {this.place = place;}

	public double getPerformance(int i) {return performance[i];}
	public void setPerformance(int i, Double performance) {this.performance[i] = performance;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getBirthDate() {return birthDate;}
	public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
}
