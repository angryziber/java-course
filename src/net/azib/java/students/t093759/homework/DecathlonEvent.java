package net.azib.java.students.t093759.homework;

/**
 * @author dionis
 *         5/30/113:24 AM
 */
public enum DecathlonEvent {
	ONE_HUNDRED_METER_SPRINT(25.4347, 18.0, 1.81) {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		public String toString() {
			return "100 m sprint";
		}
	},
	LONG_JUMP(0.14354, 220.0, 1.4) {
		@Override
		Type typeOfEvent() {
			return Type.JUMPING;
		}

		@Override
		public String toString() {
			return "Long jump";
		}
	},
	SHOT_PUT(51.39, 1.5, 1.05) {
		@Override
		Type typeOfEvent() {
			return Type.THROWING;
		}

		@Override
		public String toString() {
			return "Shot put";
		}
	},
	HIGH_JUMP(0.8465, 75.0, 1.42) {
		@Override
		Type typeOfEvent() {
			return Type.JUMPING;
		}

		@Override
		public String toString() {
			return "High jump";
		}
	},
	FOUR_HUNDRED_METER_SPRINT(1.53775, 82.0, 1.81) {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		public String toString() {
			return "400 m sprint";
		}
	},
	ONE_HUNDRED_TEN_METER_HURDLES(5.74352, 28.5, 1.92) {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		public String toString() {
			return "110 m hurdles";
		}
	},
	DISCUS_THROW(12.91, 4.0, 1.1) {
		@Override
		Type typeOfEvent() {
			return Type.THROWING;
		}

		@Override
		public String toString() {
			return "Discus throw";
		}
	},
	POLE_VAULT(0.2797, 100.0, 1.35) {
		@Override
		Type typeOfEvent() {
			return Type.JUMPING;
		}

		@Override
		public String toString() {
			return "Pole vault";
		}
	},
	JAVELIN_THROW(10.14, 7.0, 1.08) {
		@Override
		Type typeOfEvent() {
			return Type.THROWING;
		}

		@Override
		public String toString() {
			return "Javelin throw";
		}
	},
	THOUSAND_FIVE_HUNDRED_METER_SPRINT(0.03768, 480.0, 1.85) {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		public String toString() {
			return "1500 m sprint";
		}
	};

	private double a;
	private double b;
	private double c;

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	private DecathlonEvent(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Compute points for particular type of event.
	 *
	 * @param p parameter
	 * @return computed result.
	 */
	public double compute(double p) {
		return typeOfEvent().compute(getA(), getB(), getC(), p);
	}

	abstract Type typeOfEvent();

	static enum Type {
		RUNNING {
			@Override
			int compute(double a, double b, double c, double p) {
				return (int) Math.round(Math.pow(b - p, c) * a);
			}
		},
		THROWING {
			@Override
			int compute(double a, double b, double c, double p) {
				return RUNNING.compute(a, p, c, b);
			}
		},
		JUMPING {
			@Override
			int compute(double a, double b, double c, double p) {
				return THROWING.compute(a, b, c, p);
			}
		};

		abstract int compute(double a, double b, double c, double p);
	}
}
