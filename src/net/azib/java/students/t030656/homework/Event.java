package net.azib.java.students.t030656.homework;
/**
 * This Enum is made for separating different events in the decathlon.  
 *<br>
 * It can calculate points for each event.
 * @author Sprot
 */

public enum Event {
	/**
	 * Decathlon event: 100 m run.<br> Result in sec
	 */
	RUN100 (25.437, 18.0, 1.81, 1, true),
	/**
	 * Decathlon event: Long jump.<br> Result in formula cm.
	 * Input is in m. Constant = 0.01.  
	 */
	LONGJUMP (0.14354, 220, 1.40, 0.01,false),
	/**
	 * Decathlon event: Shot Put.<br> Result in m
	 */
	SHOTPUT (51.39, 1.5, 1.05, 1, false),
	/**
	 * Decathlon event: High Jump.<br> Result in cm
	 * Input is in m. Constant = 0.01.
	 */
	HIGHJUMP (0.8465, 75, 1.42, 0.01, false),
	/**
	 * Decathlon event: run 400 m.<br> Result in sec
	 */
	RUN400 (1.53775, 82, 1.81, 1, true),
	/**
	 * Decathlon event: run 110 m Hurdles.<br> Result in sec
	 */
	RUNHURDLES (5.74352, 28.5, 1.92, 1, true),
	/**
	 * Decathlon event: Discus throw.<br> Result in m
	 */
	DISCUSTHROW (12.91, 4.0, 1.1, 1, false),
	/**
	 * Decathlon event: Pole Vault.<br> Result in cm
	 * Input is in m. Constant = 0.01.
	 */
	POLEVAULT (0.2797, 100, 1.35, 0.01, false),
	/**
	 * Decathlon event: Javelin Throw<br> Result in m
	 */
	JAVELINTHROW ( 10.14, 7.0, 1.08, 1, false),
	/**
	 * Decathlon event: run 1500 m.<br> Result in sec
	 */
	RUN1500 (0.03768, 480, 1.85, 1,true);
	
	private final double dA;
	private final double dB;
	private final double dC;
	private final double dConst;
	/**
	 * if bRun is true the event is running event. if false the event is field event
	 */
	private final boolean bRun;
	/**
	 * 
	 * @param (double) dP - current result of the sportsman
	 * @param (double) dA
	 * @param (double) dB
	 * @param (double) dC
	 * @return (double) points
	 */
	private Event(double dA, double dB, double dC, double dConst, boolean bRun)
	{
		this.dA = dA;
		this.dB = dB;
		this.dC = dC;
		this.dConst = dConst;
		this.bRun = bRun;
	}
	
	private double calculateRun(double dEventResult)
	{
		return dA * Math.pow((dB - dEventResult), dC);	
	}
	/**
	 * 
	 * @param (double) dP - current result of the sportsman
	 * @param (double) dA
	 * @param (double) dB
	 * @param (double) dC
	 * @return (double) points
	 */
	private double calulateField(double dEventResult)
	{
		return dA * Math.pow(((dEventResult/dConst)-dB), dC);
	}
	/**
	 * Returns points according to the result and event
	 * @param double dEventResult
	 * @return int Points
	 */
	public int getPoints(double dEventResult)
	{
		if(bRun)
		{
			return (int)calculateRun(dEventResult);
		}
		else
		{
			return (int)calulateField(dEventResult);
		}
	}
}
