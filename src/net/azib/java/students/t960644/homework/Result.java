package net.azib.java.students.t960644.homework;

/**
 * Result
 * 
 * @author Lembit
 */
public class Result implements Comparable<Result>{
	private Athlete athlete;
	private double race100;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double race400;
	private double hurdles110;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double race1500;
	private int id;
	private String position;
	
	/*public Result() {
		
	}
	
	public Result(double race100,double longJump,double shotPut,double highJump,double race400,double hurdles110,
			double discusThrow,double poleVault,double javelinThrow,double race1500,int id) {
		
	}*/

	/**
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/**
	 * @param athlete the athlete to set
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	/**
	 * @return the race100
	 */
	public double getRace100() {
		return race100;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @param race100 the race100 to set
	 */
	public void setRace100(double race100) {
		this.race100 = race100;
	}

	/**
	 * @return the longJump
	 */
	public double getLongJump() {
		return longJump;
	}

	/**
	 * @param longJump the longJump to set
	 */
	public void setLongJump(double longJump) {
		this.longJump = longJump;
	}

	/**
	 * @return the shotPut
	 */
	public double getShotPut() {
		return shotPut;
	}

	/**
	 * @param shotPut the shotPut to set
	 */
	public void setShotPut(double shotPut) {
		this.shotPut = shotPut;
	}

	/**
	 * @return the highJump
	 */
	public double getHighJump() {
		return highJump;
	}

	/**
	 * @param highJump the highJump to set
	 */
	public void setHighJump(double highJump) {
		this.highJump = highJump;
	}

	/**
	 * @return the race400
	 */
	public double getRace400() {
		return race400;
	}

	/**
	 * @param race400 the race400 to set
	 */
	public void setRace400(double race400) {
		this.race400 = race400;
	}

	/**
	 * @return the hurdles110
	 */
	public double getHurdles110() {
		return hurdles110;
	}

	/**
	 * @param hurdles110 the hurdles110 to set
	 */
	public void setHurdles110(double hurdles110) {
		this.hurdles110 = hurdles110;
	}

	/**
	 * @return the discusThrow
	 */
	public double getDiscusThrow() {
		return discusThrow;
	}

	/**
	 * @param discusThrow the discusThrow to set
	 */
	public void setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
	}

	/**
	 * @return the poleVault
	 */
	public double getPoleVault() {
		return poleVault;
	}

	/**
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(double poleVault) {
		this.poleVault = poleVault;
	}

	/**
	 * @return the javelinThrow
	 */
	public double getJavelinThrow() {
		return javelinThrow;
	}

	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	/**
	 * @return the race1500
	 */
	public double getRace1500() {
		return race1500;
	}

	/**
	 * @param race1500 the race1500 to set
	 */
	public void setRace1500(double race1500) {
		this.race1500 = race1500;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Calculates and returns Decathlon Score based on individual events.
	 */
	public int calcResult() {
		int result = DecathlonEvent.RACE_100M.eventScore(race100);
		result += DecathlonEvent.LONG_JUMP.eventScore(longJump);
		result += DecathlonEvent.SHOT_PUT.eventScore(shotPut);
		result += DecathlonEvent.HIGH_JUMP.eventScore(highJump);
		result += DecathlonEvent.RACE_400M.eventScore(race400);
		result += DecathlonEvent.HURDLES_110M.eventScore(hurdles110);
		result += DecathlonEvent.DISCUS_THROW.eventScore(discusThrow);
		result += DecathlonEvent.POLE_VAULT.eventScore(poleVault);
		result += DecathlonEvent.JAVELIN_THROW.eventScore(javelinThrow);
		result += DecathlonEvent.RACE_1500M.eventScore(race1500);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Result o) {
		// TODO Auto-generated method stub
		return o.calcResult()-this.calcResult();
	}
}
