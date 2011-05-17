package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

/** Jumping and throwing event
 *
 */
public class JavelinThrowEvent implements Event {

    /**
     * Constructor takes raw performance
     *
     * @param performance raw performance for this particular event
     */
    public JavelinThrowEvent(double performance) {

        this.performance = performance;
    }

    double A = 10.14;
    double B = 7;
    double C = 1.08;
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
        return "JavelinThrow";
    }

    /**
     * @return units used to measure event performance
     */
    @Override
    public String getEventUnits() {
        return "m";
    }
}
