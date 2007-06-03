package decathlon;

public class HundredMeterSprint extends RunnerDecathlonEvent {
	private final static double aParameter = 25.437;
	private final static double bParameter = 18.0;
	private final static double cParameter = 1.81;
	private final static double handTime = 0.24;
	
	public HundredMeterSprint(String achievedResult) throws Exception{
		super(achievedResult, aParameter, bParameter, cParameter);
		super.setHandTime(handTime);
	}
	

}
