package net.azib.java.students.t090437.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Competitor
 * 
 * Class for storing data and results of the competitor. Contains methods for 
 * calculating the score of the competitor.
 *
 * @author Ronald
 */
public class Competitor implements Comparable<Competitor> {
	private static String dateStrFormat = "dd.MM.yyyy";
	
	private String name;
	private Date birthday;	
	private String country;
	
	private MyDouble long_jump_m;
	private MyDouble shot_put_m;
	private MyDouble high_jump_m;
	private MyDouble discus;
	private MyDouble pole_vault;
	private MyDouble javelin_throw;
	
	private MyTime sprint_100m_s;
	private MyTime sprint_400m_m_s;
	private MyTime hurdles_s;
	private MyTime race_1500m_m_s;
	
	private int score = 0;
	
	private Position position;
	
	/**
	 * Calculates the competitors score according to formula at 
	 * http://en.wikipedia.org/wiki/Decathlon#Points_system
	 */
	public void calcScore() {
		setScore(0);
		if(getSprint_100m_s() != null) {
			setScore(getScore() + ((int)(25.4347*Math.pow(18.0 - getSprint_100m_s().getSec(), 1.81)))); // Points for 100m sprint
		}
		if(getLong_jump_m() != null) {
			setScore(getScore() + ((int)(0.14354*Math.pow(getLong_jump_m().getValue()*100.0 - 220.0, 1.4)))); // Points for Long Jump
		}
		if(getShot_put_m() != null) { 
			setScore(getScore() + ((int)(51.39*Math.pow(getShot_put_m().getValue() - 1.5, 1.05)))); // Points for Shot Put
		}
		if(getHigh_jump_m() != null) {
			setScore(getScore() + ((int)(0.8465*Math.pow(getHigh_jump_m().getValue()*100.0 - 75.0, 1.42)))); // Points for High Jump
		}
		if(getSprint_400m_m_s() != null) {
			setScore(getScore() + ((int)(1.53775*Math.pow(82.0 - getSprint_400m_m_s().getSec(), 1.81)))); // Points for 400m sprint
		}
		if(getHurdles_s() != null) {
			setScore(getScore() + ((int)(5.74352*Math.pow(28.5 - getHurdles_s().getSec(), 1.92)))); // Points for 110m hurdles
		}
		if(getDiscus() != null) {
			setScore(getScore() + ((int)(12.91*Math.pow(getDiscus().getValue() - 4.0, 1.1)))); // Points for Discus Throw
		}
		if(getPole_vault() != null) {
			setScore(getScore() + ((int)(0.2797*Math.pow(getPole_vault().getValue()*100.0 - 100.0, 1.35)))); // Points for Pole Vault
		}
		if(getJavelin_throw() != null) {
			setScore(getScore() + ((int)(10.14*Math.pow(getJavelin_throw().getValue() - 7.0, 1.08)))); // Points for Javelin Throw
		}
		if(getRace_1500m_m_s() != null) {
			setScore(getScore() + ((int)(0.03768*Math.pow(480 - getRace_1500m_m_s().getSec(), 1.85)))); // Points for 1500m race
		}
	}
	
	/**
	 * This function is necessary for storing Competitor 
	 * objects in TreeSet. If the scores of the competitors 
	 * are equal, then the comparison of competitor names is 
	 * returned. Hopefully this will keep the set ordered the 
	 * correct way and also allow to store two objects with 
	 * the same score.
	 */
	@Override
	public int compareTo(Competitor arg0) {
		int diff = arg0.getScore() - getScore();
		if(diff != 0) {
			return diff;
		} else {
			return getName().compareTo(arg0.getName());
		}
	}
	
	/**
	 * Tells if the competitor names and birthdays are equal.
	 */
	@Override
	public boolean equals(Object o) {
		Competitor c = (Competitor)o;
		return name.equals(c.getName()) && birthday.equals(c.getBirthday());
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	public String getBirthdayStr() {
		return new SimpleDateFormat(dateStrFormat).format(birthday);
	}

	/**
	 * @param country the country to set
	 * @throws BadDataFormatException 
	 */
	public void setCountry(String country) throws BadDataFormatException {
		if(country.length() != 2 && country.charAt(0) >= 'A' 
			&& country.charAt(0) <= 'Z' && country.charAt(1) >= 'A'
				&& country.charAt(1) <= 'Z') {
			throw new BadDataFormatException("Bad country code format : " + country);
		}
		this.country = country;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param sprint_100m_s the sprint_100m_s to set
	 */
	public void setSprint_100m_s(MyTime sprint_100m_s) {
		this.sprint_100m_s = sprint_100m_s;
	}

	/**
	 * @return the sprint_100m_s
	 */
	public MyTime getSprint_100m_s() {
		return sprint_100m_s;
	}

	/**
	 * @param sprint_400m_m_s the sprint_400m_m_s to set
	 */
	public void setSprint_400m_m_s(MyTime sprint_400m_m_s) {
		this.sprint_400m_m_s = sprint_400m_m_s;
	}

	/**
	 * @return the sprint_400m_m_s
	 */
	public MyTime getSprint_400m_m_s() {
		return sprint_400m_m_s;
	}

	/**
	 * @param hurdles_s the hurdles_s to set
	 */
	public void setHurdles_s(MyTime hurdles_s) {
		this.hurdles_s = hurdles_s;
	}

	/**
	 * @return the hurdles_s
	 */
	public MyTime getHurdles_s() {
		return hurdles_s;
	}

	/**
	 * @param race_1500m_m_s the race_1500m_m_s to set
	 */
	public void setRace_1500m_m_s(MyTime race_1500m_m_s) {
		this.race_1500m_m_s = race_1500m_m_s;
	}

	/**
	 * @return the race_1500m_m_s
	 */
	public MyTime getRace_1500m_m_s() {
		return race_1500m_m_s;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param long_jump_m the long_jump_m to set
	 */
	public void setLong_jump_m(MyDouble long_jump_m) {
		this.long_jump_m = long_jump_m;
	}

	/**
	 * @return the long_jump_m
	 */
	public MyDouble getLong_jump_m() {
		return long_jump_m;
	}

	/**
	 * @param shot_put_m the shot_put_m to set
	 */
	public void setShot_put_m(MyDouble shot_put_m) {
		this.shot_put_m = shot_put_m;
	}

	/**
	 * @return the shot_put_m
	 */
	public MyDouble getShot_put_m() {
		return shot_put_m;
	}

	/**
	 * @param high_jump_m the high_jump_m to set
	 */
	public void setHigh_jump_m(MyDouble high_jump_m) {
		this.high_jump_m = high_jump_m;
	}

	/**
	 * @return the high_jump_m
	 */
	public MyDouble getHigh_jump_m() {
		return high_jump_m;
	}

	/**
	 * @param discus the discus to set
	 */
	public void setDiscus(MyDouble discus) {
		this.discus = discus;
	}

	/**
	 * @return the discus
	 */
	public MyDouble getDiscus() {
		return discus;
	}

	/**
	 * @param pole_vault the pole_vault to set
	 */
	public void setPole_vault(MyDouble pole_vault) {
		this.pole_vault = pole_vault;
	}

	/**
	 * @return the pole_vault
	 */
	public MyDouble getPole_vault() {
		return pole_vault;
	}

	/**
	 * @param javelin_throw the javelin_throw to set
	 */
	public void setJavelin_throw(MyDouble javelin_throw) {
		this.javelin_throw = javelin_throw;
	}

	/**
	 * @return the javelin_throw
	 */
	public MyDouble getJavelin_throw() {
		return javelin_throw;
	}
}
