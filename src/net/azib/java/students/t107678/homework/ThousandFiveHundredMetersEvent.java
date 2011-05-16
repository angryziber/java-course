package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class ThousandFiveHundredMetersEvent implements Event {

    public ThousandFiveHundredMetersEvent(double performance) {
        this.performance = performance;
    }

    double A = 0.03768;
    double B = 480;
    double C = 1.85;
    double performance;

    @Override
    public int getPoints() {
        return (int) (A * pow(B - performance, C));
    }

    @Override
    public double getPerformance() {
        return performance;
    }

    @Override
    public String getEventName() {
        return "ThousandFiveHundredMeters";
    }

    @Override
    public String getEventUnits() {
        return "sec";
    }
}
