package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.action.Action;

import java.io.IOException;
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
	 * @throws IOException 
	 * */
	public void addToOutput(String placeInterval, 
			List<Athlete> athletes) throws IOException;
	/**
	 * Ends the output action when output data is ready
	 * @throws IOException 
	 * */
	public void finishOutput() throws IOException;
}
