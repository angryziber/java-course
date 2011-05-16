package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class FourHundredMetersEvent implements Event{

    public FourHundredMetersEvent(double performance) {
        this.performance = performance;
    }

    double A = 1.53775;
    double B = 82;
    double C = 1.81;
    double performance;

    @Override
    public int getPoints() {
        return (int)(A*pow(B-performance,C));
    }

    @Override
    public double getPerformance() {
        return performance;
    }

    @Override
    public String getEventName() {
        return "FourHundredMeters";
    }

    @Override
    public String getEventUnits() {
        return "sec";
    }


}
