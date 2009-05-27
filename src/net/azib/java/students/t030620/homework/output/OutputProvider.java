package net.azib.java.students.t030620.homework.output;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;

import java.util.Collection;

/**
 * OutputProvider
 *
 * @author Lord HellBunny
 */
public interface OutputProvider {
	
	public void output(Collection<DecathleteScoreKeeper> scores, Object param) throws Exception;

}
