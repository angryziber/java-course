package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.components.Result;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import net.azib.java.students.t104971.homework.athletics.util.PlaceHolderUtil;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class CSVWriter implements OutputWriter {

    private List<Athlete> athletes;

    public CSVWriter(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String write(String outFileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
            for (Athlete athlete : athletes) {
                writer.write(createLine(athlete));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Logger.getLogger(getClass()).error(e);
        }
        return outFileName;
    }

    private String createLine(Athlete athlete) {
        StringBuilder line = new StringBuilder()
                .append(PlaceHolderUtil.getPlace(athlete, athletes))
                .append(",")
                .append(athlete.getTotalScore())
                .append(",")
                .append(athlete.getName())
                .append(",")
                .append(InputParser.formatDate(athlete.getDateBirth()))
                .append(",")
                .append(athlete.getCountry())
                .append(",");
        for (Result result : athlete.getResults()) {
            line.append(result.getResult())
                    .append(",");
        }
        line.deleteCharAt(line.length() - 1);
        return line.toString();
    }
}
