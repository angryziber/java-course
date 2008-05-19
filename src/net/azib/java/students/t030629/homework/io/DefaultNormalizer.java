package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.DecathlonEvent;

import java.math.BigDecimal;

/**
 * Result normalizer for the input units specified in the task.
 * Instead of centimeters, meters are used for expressing the
 * results for
 * {@link net.azib.java.students.t030629.homework.base.DecathlonEvent#LONG_JUMP},
 * {@link net.azib.java.students.t030629.homework.base.DecathlonEvent#HIGH_JUMP} and
 * {@link net.azib.java.students.t030629.homework.base.DecathlonEvent#POLE_VAULT}.
 * <p>
 * So the specified unit is METER for the 3 events above.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 12:43:08
 */
public class DefaultNormalizer implements ResultNormalizer {

    /** {@inheritDoc} */
    public BigDecimal normalize(DecathlonEvent event, BigDecimal value) {
        switch (event) {
            case LONG_JUMP:
            case HIGH_JUMP:
            case POLE_VAULT:
                /* Convert METERS to CENTIMETERS */
                return value.multiply(new BigDecimal(100));
            default:
                return value;
        }
    }

    /** {@inheritDoc} */
    public BigDecimal denormalize(DecathlonEvent event, BigDecimal value) {
        switch (event) {
            case LONG_JUMP:
            case HIGH_JUMP:
            case POLE_VAULT:
                /* Convert CENTIMETERS to METERS */
                return value.divide(new BigDecimal(100));
            default:
                return value;
        }
    }

    /** {@inheritDoc} */
    public String getNormalizedUnit(DecathlonEvent event) {
        switch (event) {
            case LONG_JUMP:
            case HIGH_JUMP:
            case POLE_VAULT:
                /* Return METERS */
                return "m";
            case SPRINT_400M:
            case RACE_1500M:
                /* Add MIN to SECs */
                return "min:sec";
            default:
                /*Return default unit */
                return event.getUnit();
        }
    }
}
