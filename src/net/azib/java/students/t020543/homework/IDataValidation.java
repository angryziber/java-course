package decathlon;

/**
 * An interface for a {@link DataValidation} class.
 * @author t020543
 */
public interface IDataValidation {
	
	/**
	 * Checks single event result for being negative
	 * @param input - measurement (number)
	 * @return <b>true</b> - if input is negative
	 */
	public abstract boolean checkNegative(double input);
	
	/**
	 * Checks single athlete event measurements for being negative
	 * @param man - athlete (IAthete interface)
	 * @return <b>true</b> - if one of the measurements is negative
	 */
	public abstract boolean checkAllNegative(IAthlete man);
	
	/**
	 * Compares single athlete event measurements with current World Records<br>
	 * This method is used to generate warnings about enormous big/small input
	 * @param man - athlete (IAthlete interface)
	 * @return <b>true</b> - if one of the measurements is equal or greater than WR
	 */
	public abstract boolean checkWorldRecord(IAthlete man);
	
	
}
