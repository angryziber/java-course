package net.azib.java.students.t030726.homework.decathlon;

/**
 * A representation of the Shot Put event. Has constants initialized to correct values for this event
 * @author Deniss Nikiforov
 *
 */
public class ShotPutEvent extends FieldDecathlonEvent {
//	Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 51.39;
	public final static double bParameter = 1.5;
	public final static double cParameter = 1.05;

	public ShotPutEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.saveRawResult(String.valueOf(achievedResult));
	}

}
