package net.azib.java.students.t103640.homework;

import java.util.Date;

public class Athlete implements Comparable<Athlete>{
	/**
	 * This is a class for storing data about one athelte with its getters and setters.
	 */
    private String name;
    private Date birthday;
    private String country;
    private double hundredMSprint;
    private double longJump;
    private double shotPut;
    private double highJump;
    private double fourHundredMSprint;
    private double hundredAndTenHurdles;
    private double discusThrow;
    private double poleVault;
    private double javelinThrow;
    private double  kilometerAndHalfRace;
    private String place;
    private int score;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getHundredMSprint() {
        return hundredMSprint;
    }

    public void setHundredMSprint(double hundredMSprint) {
        this.hundredMSprint = hundredMSprint;
    }

    public double getLongJump() {
        return longJump;
    }

    public void setLongJump(double longJump) {
        this.longJump = longJump;
    }

    public double getShotPut() {
        return shotPut;
    }

    public void setShotPut(double shotPut) {
        this.shotPut = shotPut;
    }

    public double getHighJump() {
        return highJump;
    }

    public void setHighJump(double highJump) {
        this.highJump = highJump;
    }

    public double getFourHundredMSprint() {
        return fourHundredMSprint;

    }

    public void setFourHundredMSprint(double fourHundredMSprint) {
        this.fourHundredMSprint = fourHundredMSprint;
    }

    public double getHundredAndTenHurdles() {
        return hundredAndTenHurdles;
    }

    public void setHundredAndTenHurdles(double hundredAndTenHurdles) {
        this.hundredAndTenHurdles = hundredAndTenHurdles;
    }

    public double getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(double discusThrow) {
        this.discusThrow = discusThrow;
    }

    public double getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(double poleVault) {
        this.poleVault = poleVault;
    }

    public double getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(double javelinThrow) {
        this.javelinThrow = javelinThrow;
    }

    public double getKilometerAndHalfRace() {
        return kilometerAndHalfRace;
    }

    public void setKilometerAndHalfRace(double kilometerAndHalfRace) {
        this.kilometerAndHalfRace = kilometerAndHalfRace;
    }




    @Override
    public int compareTo(Athlete athlete) {
          if(this.score == athlete.score) return 0;
            else if(this.score > athlete.score) return 1;
        else return -1;
    }
}
