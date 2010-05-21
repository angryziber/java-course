package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.action.Action;

/**
 * This interface represents the common format of all output actions
 * */
public interface OutputAction extends Action {
	/**
	 * Adds the data into output
	 * @param place is the place of the athlete
	 * @param athlete is data about athlete and his results in competition
	 * */
	public void addToOutput(int place, Athlete athlete) throws Exception;
	/**
	 * Ends the output action when output data is ready
	 * */
	public void finishOutput() throws Exception;
}
