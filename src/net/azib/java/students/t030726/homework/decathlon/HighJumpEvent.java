package decathlon;

public class HighJumpEvent extends FieldDecathlonEvent {
	private final static double aParameter = 0.8465;
	private final static double bParameter = 75;
	private final static double cParameter = 1.42;

	public HighJumpEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		// TODO Check measurements
	}

}
