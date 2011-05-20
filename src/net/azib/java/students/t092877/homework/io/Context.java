package net.azib.java.students.t092877.homework.io;

import net.azib.java.students.t092877.homework.model.Competition;

/**
 * Context.java
 * Purpose: provides context switching for various strategies
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class Context {

	private Strategy strategy;

	/**
	 * Creates a new Context instance from a specified Strategy instance.
	 *
	 * @param strategy specified Strategy instance
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Executes the corresponding method of specified strategy implementation.
	 *
	 * @param competition an instance of decathlon competition
	 */
	public void executeStrategy(Competition competition) {
		 strategy.execute(competition);
	}
}
