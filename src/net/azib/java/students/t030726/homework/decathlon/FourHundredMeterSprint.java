package decathlon;

public class FourHundredMeterSprint extends RunnerDecathlonEvent {
	private final static double aParameter = 1.53775;
	private final static double bParameter = 82;
	private final static double cParameter = 1.81;
	private final static double handTime = 0.14;
	

	public FourHundredMeterSprint(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.setHandTime(handTime);
	}

	
}
