package net.azib.java.students.t960644.homework;

import java.text.ParseException;

/**
 * Result
 * 
 * Class for storing performance results and calculating decathlon score.
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
	 * @return the race 100m result
	 */
	public double getRace100() {
		return race100;
	}

	/**
	 * @param race100 the race 100m result to set
	 */
	public void setRace100(double race100) {
		this.race100 = race100;
	}
	
	/**
	 * @return the long jump result
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
	 * @return the shot put result
	 */
	public double getShotPut() {
		return shotPut;
	}

	/**
	 * @param shotPut the shot put result to set
	 */
	public void setShotPut(double shotPut) {
		this.shotPut = shotPut;
	}

	/**
	 * @return the high jump result
	 */
	public double getHighJump() {
		return highJump;
	}

	/**
	 * @param highJump the high jump result to set
	 */
	public void setHighJump(double highJump) {
		this.highJump = highJump;
	}

	/**
	 * @return the race 400m result
	 */
	public double getRace400() {
		return race400;
	}

	/**
	 * @param race400 the race 400m result to set
	 */
	public void setRace400(double race400) {
		this.race400 = race400;
	}

	/**
	 * @return the hurdles 110m result
	 */
	public double getHurdles110() {
		return hurdles110;
	}

	/**
	 * @param hurdles110 the hurdles 110m result to set
	 */
	public void setHurdles110(double hurdles110) {
		this.hurdles110 = hurdles110;
	}

	/**
	 * @return the discus throw result
	 */
	public double getDiscusThrow() {
		return discusThrow;
	}

	/**
	 * @param discusThrow the discus throw result to set
	 */
	public void setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
	}

	/**
	 * @return the pole vault result
	 */
	public double getPoleVault() {
		return poleVault;
	}

	/**
	 * @param poleVault the pole vault result to set
	 */
	public void setPoleVault(double poleVault) {
		this.poleVault = poleVault;
	}

	/**
	 * @return the javelin throw result
	 */
	public double getJavelinThrow() {
		return javelinThrow;
	}

	/**
	 * @param javelinThrow the javelin throw result to set
	 */
	public void setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	/**
	 * @return the race 1500m result
	 */
	public double getRace1500() {
		return race1500;
	}

	/**
	 * @param race1500 the race 1500m result to set
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

	/**
	 * Compare method so that the List of Results in the Competition object can be sorted
	 * @param o another Result object to compare 
	 */
	@Override
	public int compareTo(Result o) {
		return o.calcResult()-this.calcResult();
	}
	public void setRace100(String race100) throws ParseException {
		setRace100(DecathlonEvent.RACE_100M.eventResultParse(race100));
	}
	public void setLongJump(String longJump) throws ParseException{
		setLongJump(DecathlonEvent.LONG_JUMP.eventResultParse(longJump));
	}
	public void setShotPut(String shotPut) throws ParseException {
		setShotPut(DecathlonEvent.SHOT_PUT.eventResultParse(shotPut));
	}
	public void setHighJump(String highJump) throws ParseException {
		setHighJump(DecathlonEvent.HIGH_JUMP.eventResultParse(highJump));
	}
	public void setRace400(String race400) throws ParseException {
		setRace400(DecathlonEvent.RACE_400M.eventResultParse(race400));
	}
	public void setHurdles110(String hurdles110) throws ParseException {
		setHurdles110(DecathlonEvent.HURDLES_110M.eventResultParse(hurdles110));
	}
	public void setDiscusThrow(String discusThrow) throws ParseException {
		setDiscusThrow(DecathlonEvent.DISCUS_THROW.eventResultParse(discusThrow));
	}
	public void setPoleVault(String poleVault) throws ParseException {
		setPoleVault(DecathlonEvent.POLE_VAULT.eventResultParse(poleVault));
	}
	public void setJavelinThrow(String javelinThrow) throws ParseException{
		setJavelinThrow(DecathlonEvent.JAVELIN_THROW.eventResultParse(javelinThrow));
	}
	public void setRace1500(String race1500) throws ParseException{
		setRace1500(DecathlonEvent.RACE_1500M.eventResultParse(race1500));
	}
	String getStringRace100(){
		return DecathlonEvent.RACE_100M.eventResultFormat(getRace100());
	}	
	String getStringLongJump(){
		return DecathlonEvent.LONG_JUMP.eventResultFormat(getLongJump());
	}
	String getStringShotPut(){
		return DecathlonEvent.SHOT_PUT.eventResultFormat(getShotPut());
	}
	String getStringHighJump(){
		return DecathlonEvent.HIGH_JUMP.eventResultFormat(getHighJump());
	}
	String getStringRace400(){
		return DecathlonEvent.RACE_400M.eventResultFormat(getRace400());
	}
	String getStringHurdles110(){
		return DecathlonEvent.HURDLES_110M.eventResultFormat(getHurdles110());
	}
	String getStringDiscusThrow(){
		return DecathlonEvent.DISCUS_THROW.eventResultFormat(getDiscusThrow());
	}
	String getStringPoleVault(){
		return DecathlonEvent.POLE_VAULT.eventResultFormat(getPoleVault());
	}
	String getStringJavelinThrow(){
		return DecathlonEvent.JAVELIN_THROW.eventResultFormat(getJavelinThrow());
	}
	String getStringRace1500(){
		return DecathlonEvent.RACE_1500M.eventResultFormat(getRace1500());	
	}
		
}
