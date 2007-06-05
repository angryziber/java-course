package net.azib.java.students.t030726.homework.decathlon;

/**
 * A 1500m run event. Has constants, that are relevant for the formula for this type of event
 * @author Deniss Nikiforov
 *
 */
public class FifteenHundredMeterRunEvent extends RunnerDecathlonEvent {
	private final static double aParameter = 0.03768;
	private final static double bParameter = 480;
	private final static double cParameter = 1.85;

	public FifteenHundredMeterRunEvent(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
	}

}
