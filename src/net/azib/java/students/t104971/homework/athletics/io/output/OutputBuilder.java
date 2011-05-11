package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.SourceType;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.HTMLWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.XMLWriter;

import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class OutputBuilder {

    private List<Athlete> athletes;

    public OutputBuilder(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public OutputWriter getWriter(SourceType method) {
        switch (method) {
            case CONSOLE:
                return new ConsoleWriter(athletes);
            case XML:
                return new XMLWriter(athletes);
            case HTML:
                return new HTMLWriter(athletes);
            case CSV:
                return new CSVWriter(athletes);
            default:
                return null;
        }

    }

}
