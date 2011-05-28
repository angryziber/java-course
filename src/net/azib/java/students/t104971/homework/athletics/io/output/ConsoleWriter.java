package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.util.PlaceHolderUtil;

import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class ConsoleWriter implements OutputWriter {
    private List<Athlete> athletes;

    public ConsoleWriter(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String write(String outFileName) {
        StringBuilder result = new StringBuilder();
        for (Athlete athlete : athletes) {
            athlete.setPlace(PlaceHolderUtil.getPlace(athlete, athletes));
            result.append(athlete);
            System.out.println(athlete);
        }
        return result.toString();
    }
}
