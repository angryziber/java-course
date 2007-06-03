package decathlon;

public class FifteenHundredMeterRunEvent extends RunnerDecathlonEvent {
	private final static double aParameter = 0.03768;
	private final static double bParameter = 480;
	private final static double cParameter = 1.85;

	public FifteenHundredMeterRunEvent(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
	}

}
