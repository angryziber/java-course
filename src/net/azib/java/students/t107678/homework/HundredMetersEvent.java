package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class HundredMetersEvent implements Event{

    public HundredMetersEvent(double performance) {
        this.performance = performance;
    }

    double A = 25.4347;
    double B = 18;
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
        return "HundredMeters";
    }

    @Override
    public String getEventUnits() {
        return "sec";
    }
}


