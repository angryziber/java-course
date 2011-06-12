package net.azib.java.students.t100224.homework.model;

public class Decathlon {

	public static enum Event {
		race_100m(25.4347f, 18f, 1.81f),

		long_jump(0.14354f, 220f, 1.4f),

		shot_put(51.39f, 1.5f, 1.05f),

		high_jump(0.8465f, 75f, 1.42f),

		race_400m(1.53775f, 82f, 1.81f),

		hurdles_110m(5.74352f, 28.5f, 1.92f),

		discus_throw(12.91f, 4f, 1.1f),

		pole_vault(0.2797f, 100f, 1.35f),

		javelin_throw(10.14f, 7f, 1.08f),

		race_1500m(0.03768f, 480f, 1.85f);

		private final float A;

		private final float B;

		private final float C;

		Event(float A, float B, float C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}

	public static int countPoints(String eventName, float performance) {
		Event event = Event.valueOf(eventName);
		if (event.name().endsWith("m")) {
			return (int) (event.A * Math.pow(event.B - performance, event.C));
		} else
			return (int) (event.A * Math.pow(performance - event.B, event.C));
	}

}


