package decathlon;

/**
 * An interface for a {@link Competitor} class.
 * @author t020543
 */
public interface ICompetitor {
	
	/**
	 *	The list of get() methods. <br>Reads the value of a variable.
	 * @return needed value (<i>IAthlete</i> object or <b>int</b> place)
	 */
	abstract public IAthlete getMan();
	abstract public int getPlace();
	
	/**
	 *	The list of set() methods. <br>Writes the value of a variable.
	 * @param input - needed value (<i>IAthlete</i> object or <b>int</b> place)
	 */
	abstract public void setMan(IAthlete man);	
	abstract public void setPlace(int place);
	
	/**
	 *Converts all values of a {@link Competitor} object to string.
	 * @return string
	 */
	abstract public String asString();
}
