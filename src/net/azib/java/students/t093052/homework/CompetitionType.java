package net.azib.java.students.t093052.homework;

/**
 * Class which holds kinds of sport
 * */
public enum CompetitionType {
	SPRINT_100M(true, 25.4347f, 18f, 1.81f, Measure.SECONDS, "sprint100m"),
	LONG_JUMP(false, 0.14354f, 220f, 1.4f, Measure.CENTIMETRES, "longJump"),
	SHOT_PUT(false, 51.39f, 1.5f, 1.05f, Measure.METRES, "shotPut"),
	HIGH_JUMP(false, 0.8465f, 75f, 1.42f, Measure.CENTIMETRES, "highJump"),
	SPRINT_400M(true, 1.53775f, 82f, 1.81f, Measure.SECONDS, "sprint400m"),
	HURDLES_110M(true, 5.74352f, 28.5f, 1.92f, Measure.SECONDS, "hurdles110m"),
	DISCUS_THROW(false, 12.91f, 4f, 1.1f, Measure.METRES, "discusThrow"),
	POLE_VAULT(false, 0.2797f, 100f, 1.35f, Measure.CENTIMETRES, "poleVault"),
	JAVELIN_THROW(false, 10.14f, 7f, 1.08f, Measure.METRES, "javelinThrow"),
	RACE_1500M(true, 0.03768f, 480f, 1.85f, Measure.SECONDS, "race1500m");
	
	private static final String DELIMITER = ":";
	
	private boolean timeType;
	private double a;
	private double b;
	private double c;
	private Measure measure;
	private String name;
	
	private CompetitionType(boolean timeType, double a, 
			double b, double c, Measure measure, String name) {
		this.timeType = timeType;
		this.a = a;
		this.b = b;
		this.c = c;
		this.measure = measure;
		this.name = name;
	}

	/**
	 * @return the name of kind of sport
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Calculates the points of each sport's kind
	 * @return the count of points
	 */
	public int calculatePoints(String stringResult) {
		Double result = convert(stringResult);
		if (isTimeType()) {
			result = b - result;
		} else {
			result -= b;
		}
		return (int) Math.abs(a * Math.pow(result, c));
	}
	
	private boolean isTimeType() {
		return timeType;
	}
	
	private double convert(String stringResult) {
		if (Measure.SECONDS.equals(measure)) {
			double result = 0.0;
			int index = stringResult.indexOf(DELIMITER);
			if (index != -1) {
				result = Integer.valueOf(stringResult.substring(0, index));
				stringResult = stringResult.substring(1 + index);
			}
			return measure.convert(result) + Double.valueOf(stringResult);
		} else {
			return measure.convert(Double.valueOf(stringResult));
		}
	}
}
