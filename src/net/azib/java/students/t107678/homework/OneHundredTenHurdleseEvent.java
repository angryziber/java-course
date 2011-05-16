package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class OneHundredTenHurdleseEvent implements Event {

    public OneHundredTenHurdleseEvent(double performance) {
        this.performance = performance;
    }

    double A = 5.74352;
    double B = 28.5;
    double C = 1.92;
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
        return "OneHundredTenHurdlese";
    }

    @Override
    public String getEventUnits() {
        return "sec";
    }

}
