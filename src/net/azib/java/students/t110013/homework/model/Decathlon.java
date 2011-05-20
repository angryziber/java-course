package net.azib.java.students.t110013.homework.model;

/**
 * Stores data about decathlon events along their special parameter values (a, b, c) used in calculation of event scores.
 * Each decathlon event is able to calculate an appropriate score from a performance result.
 * @author Vadim
 */
public enum Decathlon {
    SPRINT_100M     (0,     "100m sprint",      25.4347,   18,     1.81) {
        @Override
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    },
    LONG_JUMP       (1,     "Long jump",        0.14354,   220,    1.4) {
        @Override
        public int calculateEventScore(double result) {
            return calculateJumpScore(result);
        }
    },
    SHOT_PUT        (2,     "Shot put",         51.39,     1.5,    1.05) {
        @Override
        public int calculateEventScore(double result) {
            return calculateThrowScore(result);
        }
    },
    HIGH_JUMP       (3,     "High jump",        0.8465,    75,     1.42) {
        @Override
        public int calculateEventScore(double result) {
            return calculateJumpScore(result);
        }
    },
    SPRINT_400M     (4,     "400m sprint",      1.53775,   82,     1.81) {
        @Override
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    },
    HURDLES_110M    (5,     "110m hurdles",     5.74352,   28.5,   1.92) {
        @Override
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    },
    DISCUS_THROW    (6,     "Discus throw",     12.91,     4,      1.1) {
        @Override
        public int calculateEventScore(double result) {
            return calculateThrowScore(result);
        }
    },
    POLE_VAULT      (7,     "Pole vault",       0.2797,    100,    1.35) {
        @Override
        public int calculateEventScore(double result) {
            return calculateJumpScore(result);
        }
    },
    JAVELIN_THROW   (8,     "Javelin throw",    10.14,     7,      1.08) {
        @Override
        public int calculateEventScore(double result) {
            return calculateThrowScore(result);
        }
    },
    RACE_1500M      (9,     "1500m race",       0.03768,   480,    1.85) {
        @Override
        public int calculateEventScore(double result) {
            return calculateTrackEventScore(result);
        }
    };

    private static final int CM_IN_METER = 100;

    private final int index;
    private final String name;
    private final double a;
    private final double b;
    private final double c;

    Decathlon(int index, String name, double a, double b, double c) {
        this.index = index;
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

	/**
	 * Returns the index of this event in the order of decathlon events.
	 * @return an index of the event
	 */
    public int getIndex() {
        return index;
    }

	/**
	 * Returns the name of this decathlon event in a format ready for pretty-printing.
	 * @return a String representation of the name
	 */
    public String getName() {
        return name;
    }

	/**
	 * An abstract method for calculation of the event score. Decathlon events override this method in order to provide
	 * one convenient way to calculate a correct score depending on the event type.
	 * @param result a double value representing a performance result
	 * @return an int value of the score
	 */
    public abstract int calculateEventScore(double result);

    int calculateTrackEventScore(double result) {
        Double temp = a * Math.pow(b - result, c);
        return temp.intValue();
    }

    int calculateJumpScore(double result) {
        return calculateThrowScore(result * CM_IN_METER);
    }

    int calculateThrowScore(double result) {
        Double temp = a * Math.pow(result - b, c);
        return temp.intValue();
    }
}

