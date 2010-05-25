package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.action.Action;

import java.util.List;

/**
 * This interface represents the common format of all output actions
 * */
public interface OutputAction extends Action {
	/**
	 * Adds the data into output
	 * @param placeInterval is the place interval between the athletes in list
	 * @param athletes is list of athletes, each of its elements holds the data 
	 * about athlete and his results in competition
	 * */
	public void addToOutput(String placeInterval, List<Athlete> athletes) throws Exception;
	/**
	 * Ends the output action when output data is ready
	 * */
	public void finishOutput() throws Exception;
}
