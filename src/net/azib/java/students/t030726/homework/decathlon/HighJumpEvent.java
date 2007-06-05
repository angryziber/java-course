package net.azib.java.students.t030726.homework.decathlon;

/**
 * A high jump representation. Has all constants defined which are relevant for the formula for this particular event.
 * The formula requires a cm input of the achieved result, but it is provided in metres, so it is multiplied by 100.
 * @author Deniss Nikiforov
 *
 */
public class HighJumpEvent extends FieldDecathlonEvent {
	private final static double aParameter = 0.8465;
	private final static double bParameter = 75;
	private final static double cParameter = 1.42;

	public HighJumpEvent(double achievedResult) throws Exception {
		//Multiply by 100 to comply with the formula.
		super((100*achievedResult), aParameter, bParameter, cParameter);
		super.saveRawResult(String.valueOf(achievedResult));
	}

}
