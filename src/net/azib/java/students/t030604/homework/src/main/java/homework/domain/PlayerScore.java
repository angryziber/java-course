package net.azib.java.students.t030604.homework.src.main.java.homework.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PlayerScore {
	
	private String name;
	private Date birthDate;
	private String country;
	private float  sprint100;
	private float longJump;
	private float shotPut;
	private float highJump;
	private float sprint400;
	private float hurdles110;
	private float discusThrow;
	private float poleVault;
	private float javelinThrow;
	private float race1500;
	
	
	private List<String> validationErrors;
	
	

	/**
	 * tries to validate the object
	 * @return true IFF the object is valid
	 */
	public boolean validate() {
		//reset validationErrors
		validationErrors = new LinkedList<String>();
		boolean valid = true;
		//don't allow empty string names
		if (name == null || name.trim().length() == 0) {
			valid = false;
			validationErrors.add("name is an empty string");
		}
		// assuming that player cannot be born in the future.
		if (birthDate == null || birthDate.after(new Date())) {
			valid = false;
			validationErrors.add("invalid birthDate: " + birthDate);
		}
		//country sanity check
		if (country == null || country.length() != 2) {
			valid = false;
			validationErrors.add("invalid country: " + country);
		} else {
			boolean countryValid = false;
			for (String temp : Locale.getISOCountries()) {
				if (temp.equalsIgnoreCase(country)) {
					countryValid = true;
					break;
				}
			}
			if (!countryValid) {
				validationErrors.add("invalid country: " + country);
			}
		}
		//Some notes about result validation
		//0 cannot be considered a valid value for
		// running events, as it will give great boost
		// in the points. Field events can have
		// 0 as value, resulting in points to be negative
		
		//some tend to believe that human
		//100 m limit is somewhere around 9.6 seconds
		if (sprint100 <= 0F) {
			valid = false;
			validationErrors.add("sprint 100 result invalid: " + sprint100);
		}
		//no upper limit as well
		//personally I don't believe someone will 
		//ever do better than 100m ;) but who cares?
		if (longJump <= 0F) {
			valid = false;
			validationErrors.add("longJump result invalid: " + longJump);
		}
		//again, just limit negative values
		if (shotPut < 0F) {
			valid = false;
			validationErrors.add("shotPut result invalid: " + shotPut);
		}
		if (highJump < 0F) {
			valid = false;
			validationErrors.add("highJump result invalid: " + highJump);
		}
		//cant be zero
		if (sprint400 <= 0F) {
			valid = false;
			validationErrors.add("sprint 400 result invalid: " + sprint400);
		}
		//cant be zero
		if (hurdles110 <= 0F) {
			valid = false;
			validationErrors.add("hurdles 110 result invalid: " + hurdles110);
		}
		
		if (discusThrow < 0F) {
			valid = false;
			validationErrors.add("discus throw result invalid: " + discusThrow);
		}
		
		if (poleVault < 0F) {
			valid = false;
			validationErrors.add("pole vault result invalid: " + poleVault);
		}
		
		if (javelinThrow < 0F) {
			valid = false;
			validationErrors.add("javelin throw result invalid: " + javelinThrow);
		}
		
		if (race1500 <= 0F) {
			valid = false;
			validationErrors.add("race 1500 result invalid: " + race1500);
		}
		
		return valid;
	}

	/**
	 * returns list of fields, which failed validation
	 * @return
	 */
	public List<String> getValidationErrors() {
		return validationErrors;
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
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the sprint100
	 */
	public float getSprint100() {
		return sprint100;
	}

	/**
	 * @param sprint100 the sprint100 to set
	 */
	public void setSprint100(float sprint100) {
		this.sprint100 = sprint100;
	}

	/**
	 * @return the longJump
	 */
	public float getLongJump() {
		return longJump;
	}

	/**
	 * @param longJump the longJump to set
	 */
	public void setLongJump(float longJump) {
		this.longJump = longJump;
	}

	/**
	 * @return the shotPut
	 */
	public float getShotPut() {
		return shotPut;
	}

	/**
	 * @param shotPut the shotPut to set
	 */
	public void setShotPut(float shotPut) {
		this.shotPut = shotPut;
	}

	/**
	 * @return the highJump
	 */
	public float getHighJump() {
		return highJump;
	}

	/**
	 * @param highJump the highJump to set
	 */
	public void setHighJump(float highJump) {
		this.highJump = highJump;
	}

	/**
	 * @return the sprint400
	 */
	public float getSprint400() {
		return sprint400;
	}

	/**
	 * @param sprint400 the sprint400 to set
	 */
	public void setSprint400(float sprint400) {
		this.sprint400 = sprint400;
	}

	/**
	 * @return the hurdles110
	 */
	public float getHurdles110() {
		return hurdles110;
	}

	/**
	 * @param hurdles110 the hurdles110 to set
	 */
	public void setHurdles110(float hurdles110) {
		this.hurdles110 = hurdles110;
	}

	/**
	 * @return the discusThrow
	 */
	public float getDiscusThrow() {
		return discusThrow;
	}

	/**
	 * @param discusThrow the discusThrow to set
	 */
	public void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}

	/**
	 * @return the poleVault
	 */
	public float getPoleVault() {
		return poleVault;
	}

	/**
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(float poleVault) {
		this.poleVault = poleVault;
	}

	/**
	 * @return the javelinThrow
	 */
	public float getJavelinThrow() {
		return javelinThrow;
	}

	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	/**
	 * @return the race1500
	 */
	public float getRace1500() {
		return race1500;
	}

	/**
	 * @param race1500 the race1500 to set
	 */
	public void setRace1500(float race1500) {
		this.race1500 = race1500;
	}

}
