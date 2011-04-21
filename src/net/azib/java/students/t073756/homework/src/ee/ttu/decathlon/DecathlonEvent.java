package ee.ttu.decathlon;

import ee.ttu.decathlon.util.EventResultConverter;

import static ee.ttu.decathlon.DecathlonEvent.MeasureUnit.*;

public enum DecathlonEvent {

    M_100(SECONDS, 25.4347f, 18, 1.81f),
    LONG_JUMP(CENTIMETERS, 0.14354f, 220, 1.4f),
    SHOT_PUT(METRES, 51.39f, 1.5f, 1.05f),
    HIGH_JUMP(CENTIMETERS, 0.8465f, 75, 1.42f),
    M_400(SECONDS, 1.53775f, 82, 1.81f),
    HURDLES_110(SECONDS, 5.74352f, 28.5f, 1.92f),
    DISCUS_THROW(METRES, 12.91f, 4, 1.1f),
    POLE_VAULT(CENTIMETERS, 0.2797f, 100, 1.35f),
    JAVELIN_THROW(METRES, 10.14f, 7, 1.08f),
    M_1500(SECONDS, 0.03768f, 480, 1.85f);

    private final float A, B, C;
    private final MeasureUnit measureUnit;

    DecathlonEvent(MeasureUnit measureUnit, float a, float b, float c) {
        A = a;
        B = b;
        C = c;
        this.measureUnit = measureUnit;
    }

    public int calculateScore(String result) {
        double convertedResult = convertResult(result);
        return (int) (A * Math.pow(((measureUnit != SECONDS) ? convertedResult - B : B - convertedResult), C));
    }

    private double convertResult(String result) {
        switch (measureUnit) {
            case CENTIMETERS:
                return EventResultConverter.convertJumpingResults(result);
            case SECONDS:
                return EventResultConverter.convertRunningResults(result);
            default:
                return Double.parseDouble(result);
        }
    }

    enum MeasureUnit {
        METRES, CENTIMETERS, SECONDS
    }
}
