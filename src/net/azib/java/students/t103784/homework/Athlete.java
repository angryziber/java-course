package net.azib.java.students.t103784.homework;

public class Athlete {

	private String name, birthDate, country, place;
	private String[] events = {"100 meter dash(s): ", "Long jump(m): ", "Shot Put(m): ", "High jump(m): ", "400 meter race(s): ", "110 meter hurdles(s): ", "Discus throw(m): ", "Pole vault(m): ", "Javelin throw(m): ", "1500 meter race(s): "};
	private Double hundredMeters, longJump, shotPut, highJump, fourHundredMeters, hurdles, discus, poleVault, javelin, race;
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

	public Double getHundredMeters() {return hundredMeters;}
	public void setHundredMeters(Double hundredMeters) {this.hundredMeters = hundredMeters;}

	public Double getLongJump() {return longJump;}
	public void setLongJump(Double longJump) {this.longJump = longJump;}

	public Double getShotPut() {return shotPut;}
	public void setShotPut(Double shotPut) {this.shotPut = shotPut;}

	public Double getHighJump() {return highJump;}
	public void setHighJump(Double highJump) {this.highJump = highJump;}

	public Double getFourHundredMeters() {return fourHundredMeters;}
	public void setFourHundredMeters(Double fourHundredMeters) {this.fourHundredMeters = fourHundredMeters;}

	public Double getHurdles() {return hurdles;}
	public void setHurdles(Double hurdles) {this.hurdles = hurdles;}

	public Double getDiscus() {return discus;}
	public void setDiscus(Double discus) {this.discus = discus;}

	public Double getPoleVault() {return poleVault;}
	public void setPoleVault(Double poleVault) {this.poleVault = poleVault;}

	public Double getJavelin() {return javelin;}
	public void setJavelin(Double javelin) {this.javelin = javelin;}

	public Double getRace() {return race;}
	public void setRace(Double race) {this.race = race;}
}
