package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.Place;
import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ConsoleOutputTest {
    /*already tested so reused to create athlete*/
    private AbstractInputProcessor p = new AbstractInputProcessor<Object>(null) {
        public List<Athlete> readAthletes() {
            return null;
        }
    };

    @Test
    public void testOutput() throws Exception {
        final String[] result = {null};
        System.setOut(new PrintStream(File.createTempFile("temp", "tmp")) {
            @Override
            public void println(String input) {
                result[0] = input;
            }
        });

        Athlete a = p.createAthlete(Arrays.<String>asList("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72".split(",")));
        a.getResult().setOverallResult(5000);
        a.getResult().setPlace(new Place(5));

        new ConsoleOutput().writeAthletes(Arrays.<Athlete>asList(a));
        assertEquals("  5| 5000|Siim Susi      |01. 1.1976|EE|12.61   |5.00    |9.22    |1.50    |59.39   |16.43   |21.60   |2.60    |35.81   |5:25.72 |", result[0]);
    }
}
