package net.azib.java.students.t093052.homework.action.input;

import java.util.Set;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.action.Action;

/**
 * This interface represents the common format of all input actions
 * */
public interface InputAction extends Action {
	/**
	 * Creates the list of all competition's participants
	 * @return the set of athletes
	 * */
	Set<Athlete> handleData() throws Exception;
}
