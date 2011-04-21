package ee.ttu.decathlon.io;

import ee.ttu.decathlon.DecathlonException;
import ee.ttu.decathlon.beans.Athlete;
import ee.ttu.decathlon.validator.CsvLineValidator;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvProcessor extends AbstractInputProcessor<File> {
    public CsvProcessor(File source) {
        super(source);
    }

    public List<Athlete> readAthletes() {
        List<Athlete> athletes = new ArrayList<Athlete>();

        try {
            for (String line : FileUtils.readLines(getSource(), "UTF-8")) {
                CsvLine csvLine = new CsvLine(line);

                new CsvLineValidator().validate(csvLine);

                athletes.add(createAthlete(csvLine.getValues()));
            }
        } catch (IOException e) {
            throw new DecathlonException("Unable to read from file: " + getSource().getAbsolutePath());
        }
        return athletes;
    }

    public static class CsvLine {
        private String csv;

        public CsvLine(String csv) {
            this.csv = csv;
        }

        public List<String> getValues() {
            return Arrays.asList(csv.split(","));
        }

        @Override
        public String toString() {
            return csv;
        }
    }
}
