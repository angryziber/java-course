package net.azib.java.students.t107678.homework;

import net.azib.java.students.t104948.Lion;

import static java.lang.Math.pow;

public class LongJumpEvent implements Event{

    public LongJumpEvent(double performance) {
        this.performance = performance;
    }

    double A = 0.14354;
    double B = 220;
    double C = 1.4;
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
        return "LongJump";
    }

    @Override
    public String getEventUnits() {
        return "m";
    }


}




