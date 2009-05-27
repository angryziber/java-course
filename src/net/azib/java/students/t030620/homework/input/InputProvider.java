package net.azib.java.students.t030620.homework.input;


import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;

import java.util.Collection;

/**
 * InputProvider
 *
 * @author Lord HellBunny
 */
public interface InputProvider {
	
	public Collection<DecathleteScoreKeeper> getInput(Object param) throws Exception;

}
