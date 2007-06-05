package net.azib.java.students.t020543.homework;

/**
 * An interface for an {@link Athlete} class.
 * @author t020543
 */
public interface IAthlete {

	/**
	 *	The list of get() methods.
	 * <br>Reads the value of a variable.
	 * @return needed value
	 */
	abstract public String getName();	
	abstract public String getBirthday();
	abstract public String getCountry();
	abstract public double getSprint100();
	abstract public double getSprint400();
	abstract public double getHurdles110();
	abstract public double getRace1500();
	abstract public double getLongJump();
	abstract public double getHighJump();
	abstract public double getPoleVault();
	abstract public double getShotPut();
	abstract public double getDiscusThrow();
	abstract public double getJavelinThrow();
	abstract public int getScore();	
	
	/**
	 *	The list of set() methods.
	 * <br>Writes the value of a variable.
	 * @param input - needed value
	 */
	abstract public void setName(String s);	
	abstract public void setBirthday(String s);	
	abstract public void setCountry(String s);
	abstract public void setSprint100(double sec);
	abstract public void setSprint400(double sec);	
	abstract public void setHurdles110(double sec);	
	abstract public void setRace1500(double sec);
	abstract public void setLongJump(double m);
	abstract public void setHighJump(double m);
	abstract public void setPoleVault(double m);
	abstract public void setShotPut(double m);
	abstract public void setDiscusThrow(double m);	
	abstract public void setJavelinThrow(double m);
	abstract public void setScore(int score);
	abstract public void set(int i, double input);
	
	/**
	 *Converts all values of an {@link Athlete} object to string.
	 * @return string
	 */
	abstract public String asString();
}
