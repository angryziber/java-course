package net.azib.java.students.t110013.homework.model;

/**
 * //TODO class description
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
	 * //TODO method description
	 * @return  A
	 */
    public int getIndex() {
        return index;
    }

	/**
	 * //TODO method description
	 * @return  A
	 */
    public String getName() {
        return name;
    }

	/**
	 * //TODO method description
	 * @param result  A
	 * @return  A
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

