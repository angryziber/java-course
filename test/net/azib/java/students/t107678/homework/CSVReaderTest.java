package net.azib.java.students.t107678.homework;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class CSVReaderTest {

    @Test
    public void correctParseLine() throws Exception {

        String line = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";

        Record record = new LineParser().parseLine(line);
        assertEquals("Beata Kana",record.getParticipant().getName());
        assertEquals(new Date(82, 1, 29),record.getParticipant().getBirthDate());
        assertEquals(new CountryCode("ZA"),record.getParticipant().getCountry());
        assertEquals(10,record.getEvents().size());

    }

    @Test
    public void incorrectParseLineTest() throws Exception{
        String line = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";

        Record record = new LineParser().parseLine(line);
        assertNotSame("BeataKana", record.getParticipant().getName());
        assertNotSame(new Date(82, 2, 29),record.getParticipant().getBirthDate());
        assertNotSame(new CountryCode("GE"),record.getParticipant().getCountry());
        assertNotSame(11,record.getEvents().size());

    }
}
