package net.azib.java.students.t030620.homework.output;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;

import java.util.Collection;

/**
 * OutputProvider
 *
 * @author Maksim Konstantinov 030620
 */
public interface OutputProvider {
	
	public void output(Collection<DecathleteScoreKeeper> scores, Object param) throws Exception;

}
