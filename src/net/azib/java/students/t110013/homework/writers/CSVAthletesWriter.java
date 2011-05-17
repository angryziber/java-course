package net.azib.java.students.t110013.homework.writers;

import net.azib.java.students.t110013.homework.model.Athlete;
import net.azib.java.students.t110013.homework.model.Decathlon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Vadim
 */
public class CSVAthletesWriter implements AthletesWriter {
    private static final String UTF8_CHARSET = "UTF-8";
    private static final String BOM_UTF8_MARKER = "\uFEFF";
    private static final Logger LOG = Logger.getLogger(CSVAthletesWriter.class.getName());
    private String filename;

    public CSVAthletesWriter(String filename) {
        this.filename = filename;
    }

    public void writeAthletes(List<Athlete> athletes) {
        writeCSV(filename, athletes);
    }

    void writeCSV(String filename, List<Athlete> athletes) {
        PrintWriter output = null;

        try {
            output = new PrintWriter(new File(filename), UTF8_CHARSET);

            output.print(BOM_UTF8_MARKER); // for Windows compatibility
            for (Athlete athlete : athletes) {
                output.println(createCSVLine(athlete, ","));
            }
        }
        catch (FileNotFoundException e) {
            LOG.severe("The specified CSV file name " + filename + " is invalid.\n");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (output != null) output.close();
        }
    }

    public String createCSVLine(Athlete athlete, String delimiter) {
        StringBuilder sb = new StringBuilder();

        sb.append("\"").append(athlete.getName()).append("\"").append(delimiter);
        sb.append(athlete.getDateOfBirth()).append(delimiter);
        sb.append(athlete.getCountry()).append(delimiter);

        for (Decathlon event : Decathlon.values()) {
            sb.append(athlete.getPerformanceResult(event.getIndex())).append(delimiter);
        }

        sb.append(athlete.getTotalScore()).append(delimiter).append(athlete.getPlace());

        return sb.toString();
    }
}
