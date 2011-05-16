package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class HighJumpEvent implements Event {

    public HighJumpEvent(double performance) {
        this.performance = performance;
    }

    double A = 0.8465;
    double B = 75;
    double C = 1.42;
    double performance;


    @Override
    public double getPerformance() {
        return performance;
    }


    @Override
    public int getPoints() {
        return (int) (A * pow(performance - B, C));
    }

    @Override
    public String getEventName() {
        return "HighJump";
    }

    @Override
    public String getEventUnits() {
        return "m";
    }

  }



