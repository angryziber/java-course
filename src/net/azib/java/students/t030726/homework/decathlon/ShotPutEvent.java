package decathlon;

/**
 * A representation of the Shot Put event. Has constants initialized to correct values for this event
 * @author Deniss Nikiforov
 *
 */
public class ShotPutEvent extends FieldDecathlonEvent {
	private final static double aParameter = 51.39;
	private final static double bParameter = 1.5;
	private final static double cParameter = 1.05;

	public ShotPutEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
	}

}
