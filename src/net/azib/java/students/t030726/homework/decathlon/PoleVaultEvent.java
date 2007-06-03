package decathlon;

public class PoleVaultEvent extends FieldDecathlonEvent {
	private final static double aParameter = 0.2797;
	private final static double bParameter = 100;
	private final static double cParameter = 1.35;

	public PoleVaultEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		// TODO Check measurements
	}

}
