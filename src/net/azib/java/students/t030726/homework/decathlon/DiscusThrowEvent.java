package net.azib.java.students.t030726.homework.decathlon;

/**
 * A discus throw event representation. Has constants, that describe formula parameters for this type of event
 * @author Deniss Nikiforov
 *
 */
public class DiscusThrowEvent extends FieldDecathlonEvent{
	//Implemented for convenience and possibility to access in other places statically
	public final static double aParameter = 12.91;
	public final static double bParameter = 4.0;
	public final static double cParameter = 1.1;

	public DiscusThrowEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.saveRawResult(String.valueOf(achievedResult));
	}

}
