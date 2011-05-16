package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public class DiscusThrowEvent implements Event{

    public DiscusThrowEvent(double performance) {
        this.performance = performance;
    }

    double A = 12.91;
    double B = 4;
    double C = 1.1;
    double performance;


    public double getPerformance() {
        return performance;
    }


    public int getPoints() {
        return (int) (A * pow(performance - B, C));
    }

    public String getEventName(){
        return "DiscusThrow";
    }

    @Override
    public String getEventUnits() {
        return "m";
    }
}

