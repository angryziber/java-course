package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.DecathlonEvent;

import java.math.BigDecimal;

/**
 * Interface for normalization/denormalization of the results of Decathlon events from some specific units
 * to the normal units declared by {@link net.azib.java.students.t030629.homework.base.DecathlonEvent}
 * <p>
 * Each class that implements this interface should implement
 * {@link #denormalize(net.azib.java.students.t030629.homework.base.DecathlonEvent, java.math.BigDecimal)}
 * and {@link #getNormalizedUnit(net.azib.java.students.t030629.homework.base.DecathlonEvent)} in addition to
 * {@link #normalize(net.azib.java.students.t030629.homework.base.DecathlonEvent, java.math.BigDecimal)}.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 12:38:15
 */
public interface ResultNormalizer {
    /**
     * Converts results in some specific units to the ones in normal units
     * @param event event of the result value
     * @param value result value for the event in some specific units
     * @return normalized result value for the event (in the normal units)
     */
    public BigDecimal normalize (DecathlonEvent event, BigDecimal value);

    /**
     * Converts results in normal units to the ones in some specific units
     * @param event event of the result value
     * @param value result value for the event in normal units
     * @return denormalized result value for the event (in the specific units)
     */
    public BigDecimal denormalize (DecathlonEvent event, BigDecimal value);

    /**
     * Provides a string representation of the specific unit for the specified event
     * @param event to get the units for
     * @return string representation of the specific units
     */
    public String getNormalizedUnit(DecathlonEvent event);
}
