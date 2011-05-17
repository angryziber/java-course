package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

/** Jumping and throwing event
 *
 */
public class HighJumpEvent implements Event {

    /** Constructor takes raw performance
     *
     * @param performance raw performance for this particular event
     */
    public HighJumpEvent(double performance) {
        this.performance = performance;
    }

    double A = 0.8465;
    double B = 75;
    double C = 1.42;
    double performance;

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
     * @return total number of point according to event specific formula
     */
    @Override
    public int getPoints() {
        return (int) (A * pow(performance - B, C));
    }

    /**
     *
     * @return event (Decathlon discipline) name
     */
    @Override
    public String getEventName() {
        return "HighJump";
    }

    /**
     *
     * @return units used to measure event performance
     */
    @Override
    public String getEventUnits() {
        return "m";
    }

  }



