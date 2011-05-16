package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class JavelinThrowEvent implements Event{

    public JavelinThrowEvent(double performance) {

        this.performance = performance;
    }

    double A = 10.14;
    double B = 7;
    double C = 1.08;
    double performance;

    @Override
    public int getPoints() {
        return (int) (A * pow(performance - B, C));
    }

    @Override
    public double getPerformance() {
        return performance;
    }

    @Override
    public String getEventName() {
        return "JavelinThrow";
    }

    @Override
    public String getEventUnits() {
        return "m";
    }
}
