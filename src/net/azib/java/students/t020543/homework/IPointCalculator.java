package decathlon;

/**
 * An interface for a {@link PointCalculator} class.
 * @author t020543
 */
public interface IPointCalculator {
	
	/**
	 * Calculates points for an {@link Athlete}.
	 * @param man - single athlete interface
	 * @return <b>points</b> - calculated points(int)
	 */
	public abstract int calculatePoints (IAthlete man);
}
