package net.azib.java.students.t092877.homework.model;

/**
 * Event.java
 * Purpose: models the events of decathlon competition
 *
 * @author Artjom Kruglenkov  / 092877
 * @version 1.0 20.05.2011
 */
public enum Event {
	
	SPRINT_ON_100_METERS (25.4347, 18, 1.81) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "100m";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "running";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "seconds";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	},
	
	LONG_JUMP (0.14354, 220, 1.4) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "long jump";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "jumping";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "meters";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
	},
	
	SHOT_PUT (51.39, 1.5, 1.05) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "shot put";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "throwing";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "meters";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
		
	},
	
	HIGH_JUMP (0.8465, 75, 1.42) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "high jump";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "jumping";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "meters";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
		
	},
	
	SPRINT_ON_400_METERS (1.53775, 82, 1.81) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "400m";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "running";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "minutes:seconds";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	},

	HURDLES_ON_110_METERS (5.74352, 28.5, 1.92) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "110m hurdles";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "running";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "seconds";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	},

	DISCUS_THROW (12.91, 4, 1.1) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "discus throw";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "throwing";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "meters";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
	},

	POLE_VAULT (0.2797, 100, 1.35) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "pole vault";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "jumping";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "meters";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}
	},

	JAVELIN_THROW (10.14, 7, 1.08) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "javelin throw";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "throwing";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "meters";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForNonTrackEvent(rawResult);
		}

	},

	RACE_ON_1500_METERS (0.03768, 480, 1.85) {

		/**
		 * {@inheritDoc}
		 */
		public String getName() {
			return "1500m";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getType() {
			return "running";
		}

		/**
		 * {@inheritDoc}
		 */
		public String getUnits() {
			return "minutes:seconds";
		}

		/**
		 * {@inheritDoc}
		 */
		public int getScore(double rawResult) {
			return getScoreForTrackEvent(rawResult);
		}
	};
	
	private final double a;
	private final double b;
	private final double c;

	/**
	 * Creates a new Event instance from A, B and C parameter values from decathlon scoring table.
	 *
	 * @param a parameter A value in the decathlon scoring table
	 * @param b parameter B value in the decathlon scoring table
	 * @param c parameter C value in the decathlon scoring table
	 */
	private Event(double a, double b, double c) {
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double a() { return a; }
	public double b() { return b; }
	public double c() { return c; }


	/**
	 * Returns the name of this event.
	 *
	 * @return the name of this event
	 */
	public abstract String getName();


	/**
	 * Returns the type of this event.
	 *
	 * @return the type of this event
	 */
	public abstract String getType();


	/**
	 * Returns the units for this event result value.
	 *
	 * @return the units for this event result value
	 */
	public abstract String getUnits();


	/**
	 * Returns the score for this event.
	 *
	 * @param rawResult the value of raw result
	 * @return the score for this event
	 */
	public abstract int getScore(double rawResult);


	/**
	 * Returns the score for a track event.
	 *
	 * @param rawResult the value of raw result
	 * @return the score for a track event
	 */
	protected int getScoreForTrackEvent(double rawResult) {
		return (int)(a * Math.pow(b - rawResult, c));
	}

	/**
	 * Returns the score for a non-track event.
	 *
	 * @param rawResult the value of raw result
	 * @return the score for a non-track event
	 */
	protected int getScoreForNonTrackEvent(double rawResult) {
		return (int)(a * Math.pow(rawResult - b, c));
	}
}