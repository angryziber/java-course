package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class PoleVaultEvent implements Event{

    public PoleVaultEvent(double performance) {
        this.performance = performance;
    }

    double A = 0.2797;
    double B = 100;
    double C = 1.35;
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
        return "PoleVault";
    }

    @Override
    public String getEventUnits() {
        return "m";
    }
}

