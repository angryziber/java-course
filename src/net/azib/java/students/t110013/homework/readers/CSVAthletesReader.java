package net.azib.java.students.t110013.homework.readers;

import net.azib.java.students.t110013.homework.model.Athlete;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static net.azib.java.students.t110013.homework.model.AthleteUtils.*;
import static org.apache.commons.io.IOUtils.closeQuietly;

/**
 * //TODO class description
 * @author Vadim
 */
public class CSVAthletesReader implements AthletesReader {
    private static final String UTF8_CHARSET = "UTF-8";
    private static final String BOM_UTF8_MARKER = "\uFEFF";
    private static final int EXPECTED_VALUES_PER_LINE = 13;
    private static final SimpleDateFormat CSV_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private static final Logger LOG = Logger.getLogger(CSVAthletesReader.class.getName());
    private String filename;

    CSVAthletesReader(String filename) {
        this.filename = filename;
    }

	/**
	 * //TODO method description
	 * @return A
	 */
    public List<Athlete> getAthletes() {
        List<String[]> inputStringArrays = readCSV(filename);

        List<Athlete> athletes = new ArrayList<Athlete>();

        for (String[] stringArray : inputStringArrays) {
            athletes.add(buildAthlete(stringArray));
        }

        return athletes;
    }

    List<String[]> readCSV(String filename) {
        List<String[]> strings = new ArrayList<String[]>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), UTF8_CHARSET));

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    line = line.replace(BOM_UTF8_MARKER, "");
                    firstLine = false;
                }

                strings.add(splitCSVLine(line));
            }
        }
        catch (FileNotFoundException e) {
            LOG.severe("The specified CSV file " + filename + " cannot be found.\n" +
                    "Verify that the file name is correctly specified and that it exists in the target directory.\n");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (reader != null) closeQuietly(reader);
        }

        return strings;
    }

    String[] splitCSVLine(String line) {
        String[] strings = line.split("[,;]");

        if (strings.length != EXPECTED_VALUES_PER_LINE) {
            LOG.severe("The CSV file is not in an expected format.\n" +
                    "Expected " + EXPECTED_VALUES_PER_LINE + " comma or semicolon separated values per line, " +
                    "found " + strings.length + ".\n");
            throw new RuntimeException();
        }

        return strings;
    }

    Athlete buildAthlete(String[] stringArray) {
        Athlete athlete = new Athlete();

        athlete.setName(validateName(stringArray[0].replace("\"", "")));
        athlete.setDateOfBirth(validateAndParseDate(stringArray[1], CSV_DATE_FORMAT));
        athlete.setCountry(validateCountry(stringArray[2]));

        for (String string : Arrays.copyOfRange(stringArray, 3, stringArray.length)) {
            athlete.setPerformanceResult(validateAndParsePerformanceResult(string));
        }

        return athlete;
    }
}
