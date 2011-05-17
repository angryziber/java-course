package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

/** Jumping and throwing event
 *
 */
public class DiscusThrowEvent implements Event {

    /**
     * Constructor takes raw performance
     *
     * @param performance raw performance for this particular event
     */
    public DiscusThrowEvent(double performance) {
        this.performance = performance;
    }

    double A = 12.91;
    double B = 4;
    double C = 1.1;
    double performance;

    /**
     * @return raw performance of event
     */
    public double getPerformance() {
        return performance;
    }

    /**
     * @return total number of point according to event specific formula
     */
    public int getPoints() {
        return (int) (A * pow(performance - B, C));
    }

    /**
     * @return event (Decathlon discipline) name
     */
    public String getEventName() {
        return "DiscusThrow";
    }

    /**
     * @return units used to measure event performance
     */
    @Override
    public String getEventUnits() {
        return "m";
    }
}

