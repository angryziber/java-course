package decathlon;

public class JavelinThrowEvent extends FieldDecathlonEvent {
	private final static double aParameter = 10.14;
	private final static double bParameter = 7.0;
	private final static double cParameter = 1.08;

	public JavelinThrowEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		// TODO Check measurements
	}

}
