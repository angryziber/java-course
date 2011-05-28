package net.azib.java.students.t104971.homework.athletics.io;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.output.CSVWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.ConsoleWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.OutputWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.HTMLWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.XMLWriter;

import java.util.List;

/**
 * @author Jaroslav Judin
 */
public enum OutputType {

    XML {
        @Override
        public OutputWriter getWriter(List<Athlete> athletes) {
            return new XMLWriter(athletes);
        }
    },
    CSV {
        @Override
        public OutputWriter getWriter(List<Athlete> athletes) {
            return new CSVWriter(athletes);
        }
    },
    HTML {
        @Override
        public OutputWriter getWriter(List<Athlete> athletes) {
            return new HTMLWriter(athletes);
        }
    },
    CONSOLE {
        @Override
        public OutputWriter getWriter(List<Athlete> athletes) {
            return new ConsoleWriter(athletes);
        }
    };

    public abstract OutputWriter getWriter(List<Athlete> athletes);

}
