package net.azib.java.students.t104971.homework.athletics.dto;

/**
 * @author Jaroslav Judin
 */
public enum ResultType {

    RACE_100_METERS(25.4347, 18, 1.81) {
        @Override
        public int countScore(double result) {
            return countTrackEvent(result);
        }

        @Override
        public String getUnit() {
            return "seconds";
        }
    },
    LONG_JUMP(0.14354, 220, 1.4) {
        @Override
        public int countScore(double result) {
            return countJumpEvent(result);
        }
    },
    SHOT_PUT(51.39, 1.5, 1.05),
    HIGH_JUMP(0.8465, 75, 1.42) {
        @Override
        public int countScore(double result) {
            return countJumpEvent(result);
        }
    },
    RACE_400_METERS(1.53775, 82, 1.81) {
        @Override
        public int countScore(double result) {
            return countTrackEvent(result);
        }

        @Override
        public String getUnit() {
            return "seconds";
        }
    },
    RACE_110_METERS_HURDLES(5.74352, 28.5, 1.92) {
        @Override
        public int countScore(double result) {
            return countTrackEvent(result);
        }

        @Override
        public String getUnit() {
            return "seconds";
        }
    },
    DISCUS_THROW(12.91, 4, 1.1),
    POLE_VAULT(0.2797, 100, 1.35) {
        @Override
        public int countScore(double result) {
            return countJumpEvent(result);
        }
    },
    JAVELIN_THROW(10.14, 7, 1.08),
    RACE_1500_METERS(0.03768, 480, 1.85) {
        @Override
        public int countScore(double result) {
            return countTrackEvent(result);
        }

        @Override
        public String getUnit() {
            return "seconds";
        }
    };

    private Parameter parameter;

    ResultType(double a, double b, double c) {
        parameter = new Parameter(a, b, c);
    }

    public String getUnit() {
        return "meters";
    }

    /**
     * counter for trowing events : Unit - m
     *
     * @return
     */
    public int countScore(double result) {
        return (int) (parameter.getA() * Math.pow((result - parameter.getB()), parameter.getC()));
    }

    /**
     * counter for jumping events : Unit - m
     *
     * @return
     */
    public int countJumpEvent(double result) {
        return (int) (parameter.getA() * Math.pow((100 * result - parameter.getB()), parameter.getC()));
    }

    /**
     * counter for track events : Unit - sec
     *
     * @return
     */
    public int countTrackEvent(double result) {
        return (int) (parameter.getA() * Math.pow((parameter.getB() - result), parameter.getC()));
    }

    public static ResultType getResultType(int i) {
        switch (i) {
            case 0:
                return RACE_100_METERS;
            case 1:
                return LONG_JUMP;
            case 2:
                return SHOT_PUT;
            case 3:
                return HIGH_JUMP;
            case 4:
                return RACE_400_METERS;
            case 5:
                return RACE_110_METERS_HURDLES;
            case 6:
                return DISCUS_THROW;
            case 7:
                return POLE_VAULT;
            case 8:
                return JAVELIN_THROW;
            case 9:
                return RACE_1500_METERS;
            default:
                return null;
        }
    }
}
