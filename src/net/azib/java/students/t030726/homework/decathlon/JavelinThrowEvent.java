package net.azib.java.students.t030726.homework.decathlon;
/**
 * Represents a javeling throwing event. Has constants initialized to correct values for this event
 * @author Deniss Nikiforov
 *
 */
public class JavelinThrowEvent extends FieldDecathlonEvent {
//	Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 10.14;
	public final static double bParameter = 7.0;
	public final static double cParameter = 1.08;

	public JavelinThrowEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.saveRawResult(String.valueOf(achievedResult));
	}

}
