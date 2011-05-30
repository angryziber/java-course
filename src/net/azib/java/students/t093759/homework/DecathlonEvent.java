package net.azib.java.students.t093759.homework;

/**
 * @author dionis
 *         5/30/113:24 AM
 */
public enum DecathlonEvent {
	ONE_HUNDRED_METER_SPRINT {
		public double a() {
			return 25.4347;
		}

		public double b() {
			return 18.0;
		}

		public double c() {
			return 1.81;
		}

		@Override
		public String toString() {
			return "100 m spring";
		}
	},
	LONG_JUMP {
		public double a() {
			return 0.14354;
		}

		public double b() {
			return 220;
		}

		public double c() {
			return 1.4;
		}

		@Override
		public String toString() {
			return "Long jump";
		}
	},
	SHOT_PUT {
		public double a() {
			return 51.39;
		}

		public double b() {
			return 1.5;
		}

		public double c() {
			return 1.05;
		}

		@Override
		public String toString() {
			return "Shot put";
		}
	},
	HIGH_JUMP {
		public double a() {
			return 0.8465;
		}

		public double b() {
			return 75;
		}

		public double c() {
			return 1.42;
		}

		@Override
		public String toString() {
			return "High jump";
		}
	},
	FOUR_HUNDRED_METER_SPRINT {
		public double a() {
			return 1.53775;
		}

		public double b() {
			return 82;
		}

		public double c() {
			return 1.81;
		}

		@Override
		public String toString() {
			return "400 m sprint";
		}
	},
	ONE_HUNDRED_TEN_METER_HURDLES {
		public double a() {
			return 5.74352;
		}

		public double b() {
			return 28.5;
		}

		public double c() {
			return 1.92;
		}

		@Override
		public String toString() {
			return "110 m hurdles";
		}
	},
	DISCUS_THROW {
		public double a() {
			return 12.91;
		}

		public double b() {
			return 4;
		}

		public double c() {
			return 1.1;
		}

		@Override
		public String toString() {
			return "Discus throw";
		}
	},
	POLE_VAULT {
		public double a() {
			return 0.2797;
		}

		public double b() {
			return 100;
		}

		public double c() {
			return 1.35;
		}

		@Override
		public String toString() {
			return "Pole vault";
		}
	},
	JAVELIN_THROW {
		public double a() {
			return 10.14;
		}

		public double b() {
			return 7;
		}

		public double c() {
			return 1.08;
		}

		@Override
		public String toString() {
			return "Javelin throw";
		}
	},
	THOUSAND_FIVE_HUNDRED_METER_RACE {
		public double a() {
			return 0.03768;
		}

		public double b() {
			return 480;
		}

		public double c() {
			return 1.85;
		}

		@Override
		public String toString() {
			return "1500 m race";
		}
	}
}
