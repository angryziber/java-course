package net.azib.java.students.t093759.homework;

/**
 * @author dionis
 *         5/30/113:24 AM
 */
public enum DecathlonEvent {
	ONE_HUNDRED_METER_SPRINT {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		double a() {
			return 25.4347;
		}

		@Override
		double b() {
			return 18.0;
		}

		@Override
		double c() {
			return 1.81;
		}

		@Override
		public String toString() {
			return "100 m spring";
		}
	},
	LONG_JUMP {
		@Override
		Type typeOfEvent() {
			return Type.JUMPING;
		}

		@Override
		double a() {
			return 0.14354;
		}

		@Override
		double b() {
			return 220;
		}

		@Override
		double c() {
			return 1.4;
		}

		@Override
		public String toString() {
			return "Long jump";
		}
	},
	SHOT_PUT {
		@Override
		Type typeOfEvent() {
			return Type.THROWING;
		}

		@Override
		double a() {
			return 51.39;
		}

		@Override
		double b() {
			return 1.5;
		}

		@Override
		double c() {
			return 1.05;
		}

		@Override
		public String toString() {
			return "Shot put";
		}
	},
	HIGH_JUMP {
		@Override
		Type typeOfEvent() {
			return Type.JUMPING;
		}

		@Override
		double a() {
			return 0.8465;
		}

		@Override
		double b() {
			return 75.0;
		}

		@Override
		double c() {
			return 1.42;
		}

		@Override
		public String toString() {
			return "High jump";
		}
	},
	FOUR_HUNDRED_METER_SPRINT {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		double a() {
			return 1.53775;
		}

		@Override
		double b() {
			return 82;
		}

		@Override
		double c() {
			return 1.81;
		}

		@Override
		public String toString() {
			return "400 m sprint";
		}
	},
	ONE_HUNDRED_TEN_METER_HURDLES {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		double a() {
			return 5.74352;
		}

		@Override
		double b() {
			return 28.5;
		}

		@Override
		double c() {
			return 1.92;
		}

		@Override
		public String toString() {
			return "110 m hurdles";
		}
	},
	DISCUS_THROW {
		@Override
		Type typeOfEvent() {
			return Type.THROWING;
		}

		@Override
		double a() {
			return 12.91;
		}

		@Override
		double b() {
			return 4;
		}

		@Override
		double c() {
			return 1.1;
		}

		@Override
		public String toString() {
			return "Discus throw";
		}
	},
	POLE_VAULT {
		@Override
		Type typeOfEvent() {
			return Type.JUMPING;
		}

		@Override
		double a() {
			return 0.2797;
		}

		@Override
		double b() {
			return 100;
		}

		@Override
		double c() {
			return 1.35;
		}

		@Override
		public String toString() {
			return "Pole vault";
		}
	},
	JAVELIN_THROW {
		@Override
		Type typeOfEvent() {
			return Type.THROWING;
		}

		@Override
		double a() {
			return 10.14;
		}

		@Override
		double b() {
			return 7;
		}

		@Override
		double c() {
			return 1.08;
		}

		@Override
		public String toString() {
			return "Javelin throw";
		}
	},
	THOUSAND_FIVE_HUNDRED_METER_SPRINT {
		@Override
		Type typeOfEvent() {
			return Type.RUNNING;
		}

		@Override
		double a() {
			return 0.03768;
		}

		@Override
		double b() {
			return 480;
		}

		@Override
		double c() {
			return 1.85;
		}

		@Override
		public String toString() {
			return "1500 m sprint";
		}
	};


	abstract double a();

	abstract double b();

	abstract double c();

	/**
	 * Compute points for particular type of event.
	 *
	 * @param p parameter
	 * @return computed result.
	 */
	public double compute(double p) {
		return typeOfEvent().compute(a(), b(), c(), p);
	}

	abstract Type typeOfEvent();

	static enum Type {
		RUNNING {
			@Override
			double compute(double a, double b, double c, double p) {
				return Math.pow(b - p, c) * a;
			}
		},
		THROWING {
			@Override
			double compute(double a, double b, double c, double p) {
				return RUNNING.compute(a, p, c, b);
			}
		},
		JUMPING {
			@Override
			double compute(double a, double b, double c, double p) {
				return THROWING.compute(a, b, c, p);
			}
		};

		abstract double compute(double a, double b, double c, double p);
	}
}
