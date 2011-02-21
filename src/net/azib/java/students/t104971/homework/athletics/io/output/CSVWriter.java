package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.dto.Result;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * @author Jaroslav Judin
 */
public class CSVWriter {

    private Collection<Athlete> athletes;

    public CSVWriter(Collection<Athlete> athletes) {
        this.athletes = athletes;
    }

    public void write() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PropertiesLoader.getXMLPath().replace(".xml", ".csv")));
            for (Athlete athlete : athletes) {
                writer.write(createLine(athlete));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Logger.getLogger(getClass()).error(e);
        }
    }

    private String createLine(Athlete athlete) {
        StringBuilder line = new StringBuilder()
            .append(athlete.getName())
            .append(",")
            .append(new SimpleDateFormat("dd.MM.yyyy").format(athlete.getDateBirth()))
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
