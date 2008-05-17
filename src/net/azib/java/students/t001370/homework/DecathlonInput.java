package net.azib.java.students.t001370.homework;

import java.util.Collection;

/**
 * DecathlonInput
 * Base class for all input methods
 * @author maksim
 */
public abstract class DecathlonInput {


	/**
	 * Abstract method for getting competition results from input
	 * @param inArg - input argument, could be database read condition, file path
	 * @return Collection of athletes
	 */
	public abstract Collection<Athlete> getData(String inArg);
}
