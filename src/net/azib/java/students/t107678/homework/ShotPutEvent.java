package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class ShotPutEvent implements Event{

    public ShotPutEvent(double performance) {
        this.performance = performance;
    }

    double A = 51.39;
    double B = 1.5;
    double C = 1.05;
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
        return "ShotPut";
    }

    @Override
    public String getEventUnits() {
         return "m";
        }
    }
