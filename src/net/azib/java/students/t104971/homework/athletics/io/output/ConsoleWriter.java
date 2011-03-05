package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * @author Jaroslav Judin
 */
public class ConsoleWriter implements OutputWriter {
    private Collection<Athlete> athletes;
    private Logger logger = Logger.getLogger(getClass());

    public ConsoleWriter(Collection<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String write(String outFileName) {
        for (Athlete athlete : athletes) {
            logger.info(athlete);
        }
        return null;
    }
}
