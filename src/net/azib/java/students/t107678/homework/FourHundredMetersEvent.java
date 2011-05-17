package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

/** Track event
 *
 */
public class FourHundredMetersEvent implements Event {

    /** Constructor takes raw performance
     *
     * @param performance raw performance for this particular event
     */
    public FourHundredMetersEvent(double performance) {
        this.performance = performance;
    }

    double A = 1.53775;
    double B = 82;
    double C = 1.81;
    double performance;

    /**
     *
     * @return total number of point according to event specific formula
     */
    @Override
    public int getPoints() {
        return (int) (A * pow(B - performance, C));
    }

    /**
     *
     * @return raw performance of event
     */
    @Override
    public double getPerformance() {
        return performance;
    }

    /**
     *
     * @return event (Decathlon discipline) name
     */
    @Override
    public String getEventName() {
        return "FourHundredMeters";
    }

    /**
     *
     * @return units used to measure event performance
     */
    @Override
    public String getEventUnits() {
        return "sec";
    }


}
