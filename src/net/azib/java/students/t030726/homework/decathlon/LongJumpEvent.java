package decathlon;

public class LongJumpEvent extends FieldDecathlonEvent {
	private final static double aParameter = 0.14354;
	private final static double bParameter = 220;
	private final static double cParameter = 1.40;
	
	public LongJumpEvent(double achievedResult) throws Exception {
		super(achievedResult, aParameter, bParameter, cParameter);
		//TODO: Check for meters / centimeters
	}

}
