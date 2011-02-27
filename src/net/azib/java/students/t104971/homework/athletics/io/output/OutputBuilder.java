package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
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

    public OutputWriter getWriter(String method) {
        if ("-console".equals(method)) {
            return new ConsoleWriter(athletes);
        } else if ("-xml".equals(method)) {
            return new XMLWriter(athletes);
        } else if ("-html".equals(method)) {
            return new HTMLWriter(athletes);
        } else if ("-csv".equals(method)) {
            return new CSVWriter(athletes);
        }
        return null;
    }

}
