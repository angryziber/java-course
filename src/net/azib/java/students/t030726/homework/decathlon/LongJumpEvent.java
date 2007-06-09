package net.azib.java.students.t030726.homework.decathlon;

/**
 * Representation of the Long Jump event. Multiplies the result by 100 to provide cm.
 * Has constants initialized to correct values for this event
 * @author Deniss Nikiforov
 *
 */
public class LongJumpEvent extends FieldDecathlonEvent {
//	Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 0.14354;
	public final static double bParameter = 220;
	public final static double cParameter = 1.40;
	
	public LongJumpEvent(double achievedResult) throws Exception {
		super((100*achievedResult), aParameter, bParameter, cParameter);
		super.saveRawResult(String.valueOf(achievedResult));
	}

}
