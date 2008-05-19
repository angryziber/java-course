package net.azib.java.students.t030629.homework.io;

import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.util.List;

import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;
import net.azib.java.students.t030629.homework.utils.LoggingException;
import static junit.framework.Assert.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 13:26:43
 */
public class CSVLoaderTest {
    private static final String LN = System.getProperty("line.separator");

    static {
        DecathlonCalculator.initProperties();
    }

    @Test (expected = LoggingException.class)
    public void incompleteAthleteDataRejected() throws IOException {
        String incompleteAthleteData = AthleteCreatorTestHelper.createAthleteData(1)[0];
        incompleteAthleteData = incompleteAthleteData.substring(0, incompleteAthleteData.lastIndexOf(","));
        File sourceFile = null;

        try {
            /* Write incompleteAthleteData to temp file */
            sourceFile = writeStringToTempFile(incompleteAthleteData);
            new CSVLoader(sourceFile, new AthleteBuilder(), new DefaultNormalizer()).load();
        } finally {
            if (sourceFile != null) {
                sourceFile.delete();
            }
        }

    }

    @Test
    public void testAthleteLineParsing() throws IOException, ParseException, AthleteBuilder.UnsupportedCountryException, AthleteBuilder.IncompleteAthleteException {
        Athlete athlete = CSVLoader.loadAthleteFromLine(AthleteCreatorTestHelper.createAthleteData(2)[0]);
        assertEquals("Sz?r?s Sz?k", athlete.getName());
        assertEquals(StringParser.parseBirthday("3.04.1972"), athlete.getBirthday());
        assertEquals("HU", athlete.getLocale().getCountry());
    }

    @Test
    public void testParsedAthletes() throws IOException, ParseException {
        String[] athleteData = AthleteCreatorTestHelper.createAthleteData(1, 2, 0);
        File sourceFile = null;

        try {
            /* Write athleteData to temp file */
            sourceFile = writeStringToTempFile(athleteData);
            CSVLoader csvLoader = new CSVLoader(sourceFile, new AthleteBuilder(), new DefaultNormalizer());
            csvLoader.load();
            List<Athlete> athletes = csvLoader.getAthletes();
            assertEquals(athleteData.length, athletes.size());
            assertEquals("Siim Susi", athletes.get(0).getName());
            assertEquals("Sz?r?s Sz?k", athletes.get(1).getName());
            assertEquals("Василий Пупкин", athletes.get(2).getName());
        } finally {
            if (sourceFile != null) {
                sourceFile.delete();
            }
        }

    }

    /**
     * Helper method for writing specified strings to temporary file.
     * @param stringsToWrite lines to be written
     * @return temporary file the strings have been written to
     * @throws IOException if IO error occurrs while writing to file
     */
    private File writeStringToTempFile(String... stringsToWrite) throws IOException {
        OutputStreamWriter writer = null;
        File tempFile = null;
        try {
            tempFile = File.createTempFile("corruptedFile", ".csv");
            writer = new OutputStreamWriter(new FileOutputStream(tempFile), System.getProperty(DecathlonCalculator.ENCODING_KEY));
            for (String string : stringsToWrite) {
                writer.write(string);
                writer.write(LN);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return tempFile;
    }
}
