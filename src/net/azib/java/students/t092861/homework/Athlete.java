/**
 * 
 */
package net.azib.java.students.t092861.homework;

import java.util.Date;

/**
 * Model class that represents the information (the data).
 * 
 * @author Stanislav / 092861
 * 
 */
public class Athlete {

	private String name;
	private Date birthday;
	private String country;
	private float sprint100;
	private float longJump;
	private float shortPut;
	private float highJump;
	private float sprint400;
	private float hurdles;
	private float discusThrow;
	private float poleVault;
	private float javelinThrow;
	private float sprint1500;
	private int score;
	private String place;


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

	public float getSprint100() {
		return sprint100;
	}

	public void setSprint100(float sprint100) {
		this.sprint100 = sprint100;
	}

	public float getLongJump() {
		return longJump;
	}

	public void setLongJump(float longJump) {
		this.longJump = longJump;
	}

	public float getShortPut() {
		return shortPut;
	}

	public void setShortPut(float shortPut) {
		this.shortPut = shortPut;
	}

	public float getHighJump() {
		return highJump;
	}

	public void setHighJump(float highJump) {
		this.highJump = highJump;
	}

	public float getSprint400() {
		return sprint400;
	}

	public void setSprint400(float sprint400) {
		this.sprint400 = sprint400;
	}

	public float getHurdles() {
		return hurdles;
	}

	public void setHurdles(float hurdles) {
		this.hurdles = hurdles;
	}

	public float getDiscusThrow() {
		return discusThrow;
	}

	public void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}

	public float getPoleVault() {
		return poleVault;
	}

	public void setPoleVault(float poleVault) {
		this.poleVault = poleVault;
	}

	public float getJavelinThrow() {
		return javelinThrow;
	}

	public void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	public float getSprint1500() {
		return sprint1500;
	}

	public void setSprint1500(float race) {
		this.sprint1500 = race;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		String date = new IOconsole().convertDateDMY(getBirthday());
		return "\"" + getName() + "\"" + "," + date  + "," + getCountry();
	}
}
