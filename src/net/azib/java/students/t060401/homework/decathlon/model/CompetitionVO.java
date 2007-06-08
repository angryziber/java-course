package net.azib.java.students.t060401.homework.decathlon.model;

import net.azib.java.students.t060401.homework.util.DateUtil;

import java.util.Date;

/**
 * @hibernate.class table="COMPETITION"
 */
public class CompetitionVO {
	
	/**
	 * @hibernate.property column ="ID"
	 */
	private Long id;
	/**
	 * @hibernate.property column ="COUNTRY_CODE"
	 */
    private String countryCode;
    /**
	 * @hibernate.property column ="DESCRIPTION"
	 */
    private String description;
    /**
	 * @hibernate.property column ="DATE"
	 */
    private Date date;

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
     * @return returns descriptive information of a competition
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description sets the description data of a competition
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
    	String str = getDescription();
    	if (str == null || "".equals(str))
    	{
    		str = DateUtil.getDateAsString(date)+" "+countryCode;
    	}
        return str;
    }
}
