package net.azib.java.students.t092877.homework;

public enum Event {
	
	SPRINT_ON_100_METERS (25.4347, 18, 1.81) {

		public String getName() {
			return "100m";
		}
		
		public String getType() {
			return "running";
		}
		
		public String getUnits() {
			return "seconds";
		}
		
		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	},
	
	LONG_JUMP (0.14354, 220, 1.4) {
		
		public String getName() {
			return "long jump";
		}
		
		public String getType() {
			return "jumping";
		}
		
		public String getUnits() {
			return "meters";
		}
		
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
	},
	
	SHOT_PUT (51.39, 1.5, 1.05) {
		
		public String getName() {
			return "shot put";
		}
		
		public String getType() {
			return "throwing";
		}
		
		public String getUnits() {
			return "meters";
		}
		
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
		
	},
	
	HIGH_JUMP (0.8465, 75, 1.42) {
		
		public String getName() {
			return "high jump";
		}
		
		public String getType() {
			return "jumping";
		}
		
		public String getUnits() {
			return "meters";
		}
		
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
		
	},
	
	SPRINT_ON_400_METERS (1.53775, 82, 1.81) {

		public String getName() {
			return "400m";
		}
		
		public String getType() {
			return "running";
		}
		
		public String getUnits() {
			return "seconds";
		}

		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	},

	HURDLES_ON_110_METERS (5.74352, 28.5, 1.92) {

		public String getName() {
			return "110m hurdles";
		}

		public String getType() {
			return "running";
		}

		public String getUnits() {
			return "seconds";
		}

		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	},

	DISCUS_THROW (12.91, 4, 1.1) {

		public String getName() {
			return "discus throw";
		}

		public String getType() {
			return "throwing";
		}

		public String getUnits() {
			return "meters";
		}

		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
	},

	POLE_VAULT (0.2797, 100, 1.35) {

		public String getName() {
			return "pole vault";
		}

		public String getType() {
			return "jumping";
		}

		public String getUnits() {
			return "meters";
		}

		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
	},

	JAVELIN_THROW (10.14, 7, 1.08) {

		public String getName() {
			return "javelin throw";
		}

		public String getType() {
			return "throwing";
		}

		public String getUnits() {
			return "meters";
		}

		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}

	},

	RACE_ON_1500_METERS (0.03768, 480, 1.85) {

		public String getName() {
			return "1500m";
		}

		public String getType() {
			return "running";
		}

		public String getUnits() {
			return "seconds";
		}
		
		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	};
	
	private final double a;
	private final double b;
	private final double c;
	
	private Event(double a, double b, double c) {
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double a() { return a; }
	public double b() { return b; }
	public double c() { return c; }
	
	public abstract String getName();
	public abstract String getType();
	public abstract String getUnits();
	public abstract int getScore(double rawResult);
	
	protected int getScoreForTrackEvent(double rawResult) {
		return (int)(a * Math.pow(b - rawResult, c));
	}
	
	protected int getScoreForNonTrackEvent(double rawResult) {
		return (int)(a * Math.pow(rawResult - b, c));
	}
}	