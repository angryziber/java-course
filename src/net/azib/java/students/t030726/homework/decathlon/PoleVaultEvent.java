package decathlon;

/**
 * Represents a pole vauld event. Result multiplied by 100 to provide cm. Has constants initialized to correct values for this event
 * @author Deniss Nikiforov
 *
 */
public class PoleVaultEvent extends FieldDecathlonEvent {
	private final static double aParameter = 0.2797;
	private final static double bParameter = 100;
	private final static double cParameter = 1.35;

	public PoleVaultEvent(double achievedResult) throws Exception {
		super((100*achievedResult), aParameter, bParameter, cParameter);
		super.saveRawResult(String.valueOf(achievedResult));
	}

}
