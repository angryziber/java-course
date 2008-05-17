package net.azib.java.students.t001370.homework;

import java.util.Date;

/**
 * Athlet
 * Class for handling athlete data
 * @author maksim
 */
public class Athlete implements Comparable<Athlete>{
	
    private String name;
    private String countryCode;
    private Date birthday;
    public DecathlonResults competitionResults;
    
    public Athlete(){
    	
    	competitionResults = new DecathlonResults();
    }
    
    /**
     * Athletes are compared according to their total score
     * @param compareToAthlere
     * @return -1, 0, 1 showing whether the current Athlete is 
     * greater, equal, or smaller than compareToAthlete
     * @throws NullPointerException in case compareToAthlete is null
     */
    public int compareTo(Athlete compareToAthlete){
    	int totalScoreDifference = compareToAthlete.competitionResults.getTotalScore() -
    												this.competitionResults.getTotalScore();
    	
        return totalScoreDifference == 0 ? 1 : (int)Math.signum(totalScoreDifference);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this.getName().compareTo(((Athlete)obj).getName()) == 0 &&
    		this.getCountryCode().compareTo(((Athlete)obj).getCountryCode()) == 0 &&
            this.competitionResults.getTotalScore() == 
            			((Athlete)obj).competitionResults.getTotalScore()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    @Override
    public int hashCode() {
            return this.competitionResults.getTotalScore();
    }

    /**
     * Get athlete's name
     *
     * @return the name
     */
    public String getName() {
    	return name;
    }

    /**
     * Set athlete's name
     *
     * @param name the name to set
     */
    public void setName(String name) {
    	this.name = name;
    }

    /**
     * Get athlete's country code
     * @return the countryCode
     */
    public String getCountryCode() {
    	return countryCode;
    }

    /**
     * Set athlete's country code
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
    	this.countryCode = countryCode;
    }

    /**
     * Get athlete's birthday
     * @return the birthday
     */
    public Date getBirthday() {
    	return birthday;
    }

    /**
     * Set athlete's birthday
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
    	this.birthday = birthday;
    }
}
