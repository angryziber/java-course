package decathlon;

/**
 * An interface for an {@link StringConvertor} class.
 * @author t020543
 */
public interface IStringConvertor {
	
	/**
	 * Converts CSV string into {@link Athlete} class members<br>
	 * Communication using {@link IAthlete} interface
	 * 
	 * @param input - CSV string
	 * @param man	- new empty {@link Athlete}
	 * @return	Athlete with data
	 */
	public abstract IAthlete toAthlete(String input, IAthlete man);
}
