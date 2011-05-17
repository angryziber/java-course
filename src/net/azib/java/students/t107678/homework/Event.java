package net.azib.java.students.t107678.homework;

interface Event {
    /**
     * @return total number of point according to event specific formula
     */
    public int getPoints();

    /**
     * @return raw performance of event
     */
    public double getPerformance();

    /**
     *
     * @return event (Decathlon discipline) name
     */
    public String getEventName();

    /**
     *
     * @return units used to measure event performance
     */
    public String getEventUnits();


}
