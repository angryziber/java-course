package net.azib.java.students.t092855.homework;

/**
 * OutputStrategy
 * Interface of the output strategy
 *
 * @author t092855
 */
public interface OutputStrategy {
	/**
	 * Writes {@link Competition} data to output.
	 *
	 * @param competition data
	 * @param args if needed e.g. file name
	 */
	public void writeOutput(Competition competition, String... args);
}
