package net.azib.java.students.t001370.homework;

/**
 * DecathlonFormulaArguments
 *
 * @author maksim
 */
public enum DecathlonFormulaArguments {
	                                  // A          B       C       Multiplier
	RUNNING_EVENT_100M_IN_SEC 			(25.437,	18.0, 	1.81,	1			),
	FIELD_EVENT_LONG_JUMP_IN_M 			(0.14354,	220, 	1.40,	100			),
	FIELD_EVENT_SHOT_PUT_IN_M 			(51.39,		1.5, 	1.05,	1			),
	FIELD_EVENT_HIGH_JUMP_IN_M			(0.8465,	75, 	1.42,	100			),
	RUNNING_EVENT_400M_IN_SEC			(1.53775,	82,		1.81,	1			),
	RUNNING_EVENT_110M_HURDLES_IN_SEC	(5.74352,	28.5,	1.92,	1			),
	FIELD_EVENT_DISCUS_THROW_IN_M 		(12.91,		4.0,	1.1,	1			),
	FIELD_EVENT_POLE_VAULT_IN_M 		(0.2797,	100,	1.35,	100			),
	FIELD_EVENT_JAVELIN_THROW_IN_M 		(10.14,		7.0,	1.08,	1			),
	RUNNING_EVENT_1500M_IN_SEC  		(0.03768,	480,	1.85,	1			);
	
	private final double argA;
	private final double argB;
	private final double argC;
	private final int resultMultiplier;
	
	DecathlonFormulaArguments(double argA, double argB, double argC, int multiplier){
		this.argA = argA;
		this.argB = argB;
		this.argC = argC;
		this.resultMultiplier = multiplier;
	}

	/**
	 * Calculate points for running event.
	 * Formula: Points = A*(B-P)^C,
	 * where P is your performance in the units described below and A, B, and C are constants
	 * 
	 * @param result - athlete result
	 * @return points for given running event
	 */
	public int getRunningEventResult(double result){
		int returnValue = 0;
		
		returnValue = (int)(argA * Math.pow(argB - (result * resultMultiplier), argC));
		
		return returnValue;
	}
	
	/**
	 * Calculate points for field event.
	 * Formula: Points = A*(P-B)^C,
	 * where P is your performance in the units described below and A, B, and C are constants
	 * 
	 * @param result - athlete result
	 * @return points for given field event
	 */
	public int getFieldEventResult(double result){
		int returnValue = 0;
		
		returnValue = (int)(argA * Math.pow((result * resultMultiplier) - argB, argC));
		
		return returnValue;
	}
}
