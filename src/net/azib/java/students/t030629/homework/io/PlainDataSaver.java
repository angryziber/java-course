package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.utils.LoggingException;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.io.*;
import java.util.logging.Logger;

/**
 * Writes statistics of the Decathlon competition, formatted with the specified formatter,
 * into the specified stream.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 20:53:23
 */
public class PlainDataSaver implements AthleteSaver {
    private static final Logger LOG = Logger.getLogger(PlainDataSaver.class.getName());

    private final OrderedAthleteFormatter formatter;
    private final OutputStream out;

    /**
     * Constructor for setting the required formatter and output stream
     * @param formatter to format the array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes} with
     * @param out where to write the output of the formatter
     */
    public PlainDataSaver(OrderedAthleteFormatter formatter, OutputStream out) {
        this.formatter = formatter;
        this.out = out;
    }

    /** {@inheritDoc} */
    public void save(OrderedAthlete... athlets) {

        String athletsAsString = formatter.format(athlets);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, System.getProperty(DecathlonCalculator.ENCODING_KEY)));
            writer.write(athletsAsString);
            writer.flush();
        } catch (Exception e) {
            throw new LoggingException(ERROR_SAVING_MESSAGE + e.getMessage(), LOG);
        }
        /* Don't close the writer, since it's based on the input parameter stream,
         * which may be needed by the client provided it */

    }

}
