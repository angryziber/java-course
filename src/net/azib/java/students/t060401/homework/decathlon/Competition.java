package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.Utils;

import java.util.Date;

/**
 * Competition
 * 
 * Holds the data of a competition.
 *
 * @author t060401
 */
public class Competition {
	private Long id;

    private String countryCode;
    private String description;
    private Date date;

    public Competition() {}

    /**
     * @return returns competition ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id an ID of a competition to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return returns the date when competition took place
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date sets the date when competition took place
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return returns the country where the competition took place
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode sets the country where the competition took place
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    /**
     * @return returns the descriptive information of a competition
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description sets ve description data of a competition
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return Utils.getDateAsString(date)+" in "+countryCode;
    }
}
