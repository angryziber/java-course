package net.azib.java.students.t030726.homework.decathlon;

/**
 * A 100m sprint run. Has constants initialized for proper values for this event.
 * @author Deniss Nikiforov
 *
 */
public class HundredMeterSprint extends RunnerDecathlonEvent {
//	Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 25.437;
	public final static double bParameter = 18.0;
	public final static double cParameter = 1.81;
	public final static double handTime = 0.24;
	
	public HundredMeterSprint(String achievedResult) throws Exception{
		super(achievedResult, aParameter, bParameter, cParameter);
		super.setHandTime(handTime);
	}
	

}
