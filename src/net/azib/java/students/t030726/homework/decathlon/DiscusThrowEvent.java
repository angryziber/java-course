package decathlon;

/**
 * A discus throw event representation. Has constants, that describe formula parameters for this type of event
 * @author Deniss Nikiforov
 *
 */
public class DiscusThrowEvent extends FieldDecathlonEvent{
	private final static double aParameter = 12.91;
	private final static double bParameter = 4.0;
	private final static double cParameter = 1.1;

	public DiscusThrowEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
	}

}
