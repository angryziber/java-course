package net.azib.java.students.t010687.homework;

import java.util.Date;

/**
 * Athlet
 *
 * @author Matu
 */
public class Athlet {
	private int id;
	private String name;
	private String DateOfBirth;//YYYY-MM-DD
	private String Country;
	
	public Athlet(){
		super();
	}
	/**
	 * @param name
	 * @param dateOfBirth
	 * @param country
	 */
	public Athlet(String name, String dateOfBirth, String country) {
		super();
		this.name = name;
		setDateOfBirth(dateOfBirth);
		Country = country;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		String dobData[] = dateOfBirth.split(".");
		System.out.println(dateOfBirth + dobData.length);
		if (dobData.length == 3){
			DateOfBirth = dobData[2] + "-" + dobData[1] + "-" + dobData[0];
		}
		else{
			DateOfBirth = dateOfBirth;
		}
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return Country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		Country = country;
	}
	
	/**
	 * @return the dob
	 *
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 *
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the country_code
	 *
	public String getCountry_code() {
		return country_code;
	}
	/**
	 * @param country_code the country_code to set
	 *
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	
	}*/
}
