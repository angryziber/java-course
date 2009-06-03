package net.azib.java.students.t040750.homework.calculator;

import net.azib.java.students.t040750.homework.generic.Result;

/**
 * The {@link DecathlonPointsCalculator} class provides a method for
 * calculating the total points for decathlon.
 * 
 * @author Karpz
 *
 */
public class DecathlonPointsCalculator {
	
	/**
	 * Returns the total amount of points from the individual event results.
	 * All jump events are multiplied by 100 in order to provide the correct
	 * scale for the results to be used in the decathlon formula.
	 * 
	 * @param result - individual event results
	 * @return total points
	 */
	public static long calculateTotalPoints(Result result) {
		
		return 	DecathlonParameters.RUN_100M.trackPoints(result.getRun100m()) +
				DecathlonParameters.LONG_JUMP.fieldPoints(result.getLongJump()*100) +
				DecathlonParameters.SHOT_PUT.fieldPoints(result.getShotPut()) +
				DecathlonParameters.HIGH_JUMP.fieldPoints(result.getHighJump()*100) +
				DecathlonParameters.RUN_400M.trackPoints(result.getRun400m()) +
				DecathlonParameters.HURDLES_110M.trackPoints(result.getHurdles110m()) +
				DecathlonParameters.DISCUS.fieldPoints(result.getDiscus()) +
				DecathlonParameters.POLE_VAULT.fieldPoints(result.getPoleVault()*100) +
				DecathlonParameters.JAVELIN.fieldPoints(result.getJavelin()) +
				DecathlonParameters.RUN_1500M.trackPoints(result.getRun1500m());
	}
}
