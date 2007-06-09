package net.azib.java.students.t030726.homework.decathlon;

/**
 * A representation of the 110m hurdles run. Has all relevant constants defined, that are relevant for the computation formula.
 * @author Deniss Nikiforov
 *
 */
public class HundredAndTenMeterHurdlesEvent extends RunnerDecathlonEvent {
//	Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 5.74352;
	public final static double bParameter = 28.5;
	public final static double cParameter = 1.92;
	public final static double handTime = 0.24;

	public HundredAndTenMeterHurdlesEvent(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.setHandTime(handTime);
	}

}
