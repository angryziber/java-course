package net.azib.java.students.t030629.homework.base;

import java.math.BigDecimal;

/**
 * Enumeration class for Decathlon events.
 * <p>
 * Contains oficial titles for the events, oficial normal units,
 * constants and the formula for calculating the score for the
 * event result, and distinguishes between running and field events.
 *  
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 14:27:40
 */
public enum DecathlonEvent {

    SPRINT_100M     (true, "25.437", "18.0", "1.81", "sec", "100 m sprint"),
    LONG_JUMP       (false, "0.14354", "220", "1.40", "cm", "Long jump"),
    SHOT_PUT        (false, "51.39", "1.5", "1.05", "m", "Shot put"),
    HIGH_JUMP       (false, "0.8465", "75", "1.42", "cm", "High jump"),
    SPRINT_400M     (true, "1.53775", "82", "1.81", "sec", "400 m sprint"),
    HURDLES_110M    (true, "5.74352", "28.5", "1.92", "sec", "110 m hurdles"),
    DISCUS_THROW    (false, "12.91", "4.0", "1.1", "m", "Discus throw"),
    POLE_VAULT      (false, "0.2797", "100", "1.35", "cm", "Pole vault"),
    JAVELIN_THROW   (false, "10.14", "7.0", "1.08", "m", "Javelin throw"),
    RACE_1500M      (true, "0.03768", "480", "1.85", "sec", "1500 m race");

    private final boolean isRunning;
    private final BigDecimal a;
    private final BigDecimal b;
    private final BigDecimal c;
    private final String unit;
    private final String title;


    DecathlonEvent (boolean isRunning, String a, String b, String c, String unit, String title) {
        this.isRunning = isRunning;
        this.a = new BigDecimal(a);
        this.b = new BigDecimal(b);
        this.c = new BigDecimal(c);
        this.unit = unit;
        this.title = title;
    }

    /**
     * @return the next event in the traditional order of Decathlon events.
     * <b>NB!</b> Current implementation returns the first event when invoking
     * this method on the last event.
     */
    public DecathlonEvent next() {
        return values()[(ordinal() + 1) % values().length];
    }

    /**
     * @param result result in the event to calculate score for
     * @return score for the result as <code>short</code>, since
     *         the total current results for the athletes are far
     *         below 32K (in fact, < 10K).
     * @throws NumberFormatException
     *          if infinite value or NaN is received during calculations.
     *          Occurs when calculating the score for a wrong result
     *          (either of another event or unnormalized one). Event
     *          is used for debugging purposes.
     */
    public short calculateScore(BigDecimal result) throws NumberFormatException {
        /* Math.pow() operation supports doubles only, so the intermediate
         * calculations in the method must be performed in doubles, unfortunately.
         * In fact, practically both the current precision of measurements and
         * achievements are handled correctly with doubles. */
        double difference = isRunning ?
                b.subtract(result).doubleValue() :
                result.subtract(b).doubleValue();
        return (short) a.multiply(BigDecimal.valueOf(Math.pow(difference, c.doubleValue()))).intValue();
    }

    /**
     * @return the normal unit for the event results
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @return oficial title of the event
     */
    public String toString() {
        return title;
    }

    /**
     * @return the first event in the competition (traditionally) - 100 m sprint
     */
    public static DecathlonEvent getFirstEvent() {
        return SPRINT_100M;
    }

}
