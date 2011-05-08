package net.azib.java.students.t107678.homework;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {

    @Test
    public void parseLineTest() throws CSVReader.CSVLineParser.RecordFormatException {
        String line = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";

        Record record = new CSVReader.CSVLineParser().parseLine(line);
        assertEquals(record.getParticipant().getName(),"Beata Kana");
        assertEquals(record.getParticipant().getBirthDate(),new Date(82, 1, 29));
        assertEquals(record.getParticipant().getCountry(), new CountryCode("ZA"));

    }
}
