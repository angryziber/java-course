package net.azib.java.students.t030726.homework.decathlon;

/**
 * A 1500m run event. Has constants, that are relevant for the formula for this type of event
 * @author Deniss Nikiforov
 *
 */
public class FifteenHundredMeterRunEvent extends RunnerDecathlonEvent {
//	Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 0.03768;
	public final static double bParameter = 480;
	public final static double cParameter = 1.85;

	public FifteenHundredMeterRunEvent(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
	}

}
