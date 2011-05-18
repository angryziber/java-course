package net.azib.java.students.t092855.homework;

/**
 * InputStrategy
 * Interface of the input strategy
 *
 * @author t092855
 */
public interface InputStrategy {
	/**
	 * Gets data from source and puts it into a {@link Competition}
	 *
	 * @param arg String arguments when needed e.g. file name
	 * @return competition data
	 */
	public Competition getData(String... arg);
}
