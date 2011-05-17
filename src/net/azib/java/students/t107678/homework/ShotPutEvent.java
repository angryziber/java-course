package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

/** Jumping and throwing event
 *
 */
public class ShotPutEvent implements Event {

    /**
     * Constructor takes raw performance
     *
     * @param performance raw performance for this particular event
     */
    public ShotPutEvent(double performance) {
        this.performance = performance;
    }

    double A = 51.39;
    double B = 1.5;
    double C = 1.05;
    double performance;

    /**
     * @return total number of point according to event specific formula
     */
    @Override
    public int getPoints() {
        return (int) (A * pow(performance - B, C));
    }

    /**
     * @return raw performance of event
     */
    @Override
    public double getPerformance() {
        return performance;
    }

    /**
     * @return event (Decathlon discipline) name
     */
    @Override
    public String getEventName() {
        return "ShotPut";
    }

    @Override
    public String getEventUnits() {
        return "m";
    }
}
