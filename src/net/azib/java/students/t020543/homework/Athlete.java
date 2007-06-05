package net.azib.java.students.t020543.homework;

/**
 * A class, which holds personal data of an athlete and  
 * his results in every decathlon event, as long as his score in a single competition.
 * <br><br>
 * Also it contains <i>get()</i> and <i>set()</i> methods, printing method 
 * and implements Comparable interface(<i>compares score</i>)
 * @author t020543
 */
public class Athlete  implements Comparable<Object>, IAthlete {
	
	private String name;
	private String birthday;
	private String country;
	private double sprint100; 		//sec
	private double longJump;		//m
	private double shotPut;			//m
	private double highJump; 		//m
	private double sprint400;		//sec
	private double hurdles110;		//sec
	private double discusThrow;		//m
	private double poleVault;		//m
	private double javelinThrow;	//m
	private double race1500;		//sec
	private int score;
		
	/**
	 * Compares athlete's score with score of an object. <br>
	 * Method is used for sorting athletes by their score.
	 * 	 
	 * @param o - an Object 
	 * @return <b>int</b> - the difference between scores of the Object and the current Athlete
	 */
	public int compareTo(Object o) throws ClassCastException {
		if (o instanceof Athlete)    {		
				return	((Athlete)o).score - this.score ;
		}
		else throw new ClassCastException("That's Not a Man");
		}
	
	
	/**
	 *	The list of get() and set() methods.
	 * <br>Reads or writes the value of a variable.
	 */
	public String getName(){
		return name;
	}
	public void setName(String s){
		this.name = s; 
	}
	
	public String getBirthday(){
		return birthday;
	}
	public void setBirthday(String s){
		this.birthday = s; 
	}
	
	public String getCountry(){
		return country;
	}
	public void setCountry(String s){
		this.country = s; 
	}
	
	// ---- Running Events ---------
	public double getSprint100(){
		return sprint100;
	}
	public void setSprint100(double sec){
		this.sprint100 = sec; 
	}
	
	public double getSprint400(){
		return sprint400;
	}
	public void setSprint400(double sec){
		this.sprint400 = sec; 
	}
	
	public double getHurdles110(){
		return hurdles110;
	}
	public void setHurdles110(double sec){
		this.hurdles110 = sec; 
	}
		
	public double getRace1500(){
		return race1500;
	}
	public void setRace1500(double sec){
		this.race1500 = sec; 
	}

	// ---- Field Events ---------
	public double getLongJump(){
		return longJump;
	}
	public void setLongJump(double m){
		this.longJump = m; 
	}

	public double getHighJump(){
		return highJump;
	}
	public void setHighJump(double m){
		this.highJump = m; 
	}
	
	public double getPoleVault(){
		return poleVault;
	}
	public void setPoleVault(double m){
		this.poleVault = m; 
	}

	public double getShotPut(){
		return shotPut;
	}
	public void setShotPut(double m){
		this.shotPut = m; 
	}

	public double getDiscusThrow(){
		return discusThrow;
	}
	public void setDiscusThrow(double m){
		this.discusThrow = m; 
	}
	
	public double getJavelinThrow(){
		return javelinThrow;
	}
	public void setJavelinThrow(double m){
		this.javelinThrow = m;
	}
	
	public int getScore(){
		return score;
	}
	public void setScore(int score){
		this.score = score;
	}
	
	/**
	 *	Writes an input as the decathlon event result. 
	 * <br>Needed event chosen by the numeric value (from 0 to 9)
	 * 
	 * @param i - number of an event (from 0 to 10)
	 * @param input - event raw result (measurement)
	 */
	public void set(int i, double input){
		switch (i) {
		case 0: setSprint100(input);
		case 1: setLongJump(input);
		case 2: setShotPut(input);
		case 3: setHighJump(input);
		case 4: setSprint400(input);
		case 5: setHurdles110(input);
		case 6:	setDiscusThrow(input);
		case 7: setPoleVault(input);
		case 8: setJavelinThrow(input);
		case 9:	setRace1500(input);
		}
	}
	
	/**
	 *Converts all values of an {@link Athlete} to string.
	 * @return CSV string
	 */
	public String asString()
	{
		String s = score + "," + name + "," + 
		birthday + "," + country + "," + 
		sprint100 + "," + longJump + "," + 
		shotPut + "," + highJump + "," + 
		sprint400 + "," +  	hurdles110 + "," + 
		discusThrow + "," + poleVault + "," + 
		javelinThrow + "," + race1500;
		
		return s;
	}
	
}
