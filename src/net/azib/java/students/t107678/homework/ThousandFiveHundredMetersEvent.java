package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

/** Track event
 *
 */
public class ThousandFiveHundredMetersEvent implements Event {

    /**
     * Constructor takes raw performance
     *
     * @param performance raw performance for this particular event
     */
    public ThousandFiveHundredMetersEvent(double performance) {
        this.performance = performance;
    }

    double A = 0.03768;
    double B = 480;
    double C = 1.85;
    double performance;

    /**
     * @return total number of point according to event specific formula
     */
    @Override
    public int getPoints() {
        return (int) (A * pow(B - performance, C));
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
        return "ThousandFiveHundredMeters";
    }

    /**
     * @return units used to measure event performance
     */
    @Override
    public String getEventUnits() {
        return "sec";
    }
}
