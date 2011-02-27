package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.HTMLWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.XMLWriter;
import net.azib.java.students.t104971.homework.athletics.util.BrowserLaunch;

import java.util.Collection;
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
            //BrowserLaunch.openURL(buildXML(parameter));
        } else if ("-html".equals(method)) {
            return new HTMLWriter(athletes);
            //BrowserLaunch.openURL(buildHTML(parameter));
        } else if ("-csv".equals(method)) {
            return new CSVWriter(athletes);
        }
        return null;
    }

}
