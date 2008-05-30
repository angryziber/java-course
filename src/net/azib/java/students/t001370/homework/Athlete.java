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
     * Athletes are compared according to their total score, name, 
     * birthday, country code and results 
     * 
     * @param compareToAthlere
     * @return -1, 0, 1 showing whether the current Athlete is 
     * greater, equal, or smaller than compareToAthlete
     * @throws NullPointerException in case compareToAthlete is null
     */
    public int compareTo(Athlete compareToAthlete){
    	
    	//check for difference in score
    	int compareResult = compareToAthlete.competitionResults.getTotalScore() -
    												this.competitionResults.getTotalScore();
    	if (compareResult != 0) {
    		return (int)Math.signum(compareResult);
		}
    	
    	//check for difference in name
    	compareResult = this.name.compareTo(compareToAthlete.getName());
    	if (compareResult != 0) {
    		return (int)Math.signum(compareResult);
		}

    	//check for difference in birthday
    	compareResult = this.name.compareTo(compareToAthlete.getName());
    	if (compareResult != 0) {
    		return (int)Math.signum(compareResult);
		}

    	//check for difference in country code
    	compareResult = this.countryCode.compareTo(compareToAthlete.getCountryCode());
    	if (compareResult != 0) {
    		return (int)Math.signum(compareResult);
		}

    	//check for difference in competition results. 
    	float compareCompResult = (this.competitionResults.getResult100mRace() +
    									this.competitionResults.getResult110mHurdles() +
    									this.competitionResults.getResult1500mRace() +
    									this.competitionResults.getResult400mSprint() +
    									this.competitionResults.getResultDiscusThrow() +
    									this.competitionResults.getResultHighJump() +
    									this.competitionResults.getResultJavelinThrow() +
    									this.competitionResults.getResultLongJump() +
    									this.competitionResults.getResultPoleVault() +
    									this.competitionResults.getResultShotPut()) -
    								(compareToAthlete.competitionResults.getResult100mRace() +
    									compareToAthlete.competitionResults.getResult110mHurdles() +
    									compareToAthlete.competitionResults.getResult1500mRace() +
    									compareToAthlete.competitionResults.getResult400mSprint() +
    									compareToAthlete.competitionResults.getResultDiscusThrow() +
    									compareToAthlete.competitionResults.getResultHighJump() +
    									compareToAthlete.competitionResults.getResultJavelinThrow() +
    									compareToAthlete.competitionResults.getResultLongJump() +
    									compareToAthlete.competitionResults.getResultPoleVault() +
    									compareToAthlete.competitionResults.getResultShotPut());
    	if (compareCompResult != 0) {
    		return (int)Math.signum(compareCompResult);
		}
    	
    	//if we get here then it is the same athlete with the same results
    	return 0;
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
