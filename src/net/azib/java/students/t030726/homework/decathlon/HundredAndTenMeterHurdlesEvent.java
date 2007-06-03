package decathlon;

public class HundredAndTenMeterHurdlesEvent extends RunnerDecathlonEvent {
	private final static double aParameter = 5.74352;
	private final static double bParameter = 28.5;
	private final static double cParameter = 1.92;
	private final static double handTime = 0.24;

	public HundredAndTenMeterHurdlesEvent(String achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		super.setHandTime(handTime);
	}

}
