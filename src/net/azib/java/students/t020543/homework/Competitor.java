package net.azib.java.students.t020543.homework;

/**
 * A class, which holds an athlete and his place in current competition.
 * <br><br>
 * Also contains <i>get()</i> and <i>set()</i> methods, printing method 
 * and implements Comparable interface.
 * @author t020543
 */
public class Competitor implements Comparable<Object>, ICompetitor  {

	private IAthlete man;
	private int place;
	
	/**
	 * Constructor for a {@link Competitor} object.
	 *@param man - athlete object(through the IAthlete interface)
	 */
	public Competitor(IAthlete man){
		this.man = man;
		}
	
	/**
	 * Constructor for a {@link Competitor} object.
	 *@param man - an athlete
	 *@param place - place of the athlete in the competition
	 */
	public Competitor(int place, IAthlete man){
		this.man = man;
		this.place = place;
	}
	
	/**
	 * Compares athlete's data with data of an object,
	 * using <i>string.equals()</i> method.<br><br>
	 * Method is needed for duplicate removing.
	 * 
	 * @param o - an {@link Object} 
	 * @return <b>int</b> - the difference between scores of the Object and the current Competitor
	 */
	public int compareTo(Object o) throws ClassCastException {
		if (o instanceof Competitor)    {			
			if  ( this.man.asString().equals(  ((Competitor)o).man.asString() ))
				return ((Competitor)o).man.getScore()- this.man.getScore() ; 
				// == return 0; if strings are equal
			
			else return 1;
		}
		else throw new ClassCastException("That's Not an Athlete!");
		}
	
	/**
	 *	The list of get() and set() methods.
	 * <br>Reads or writes the value of a variable.
	 */
	public IAthlete getMan(){
		return man;
	}
	public void setMan(IAthlete man){
		this.man = man;
	}
		
	public int getPlace(){
		return place;
	}
	public void setPlace(int place){
		this.place = place;
	}	
	
	/**
	 *Adds place to the athlete CSV string.
	 * @return CSV string
	 */
	public String asString()
	{
		String s = this.place + "," + this.man.asString();
		return s;
	}

	
}
