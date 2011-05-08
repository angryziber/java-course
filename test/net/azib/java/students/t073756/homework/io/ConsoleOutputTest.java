package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.Place;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class ConsoleOutputTest {
    private TestInputProcessor p = new TestInputProcessor(null);

    @Test
    public void testOutput() throws Exception {
        final String[] result = {null};
	    System.setOut(new PrintStream(createTempFile()) {
            @Override
            public void println(String input) {
                result[0] = input;
            }
        });

        Athlete a = p.readAthletes().get(0);
        a.getResult().setOverallResult(5000);
        a.getResult().setPlace(new Place(5));

        new ConsoleOutput().writeAthletes(Arrays.<Athlete>asList(a));
        assertEquals("  5| 5000|Siim Susi      |01. 1.1976|EE|12.61   |5.00    |9.22    |1.50    |59.39   |16.43   |21.60   |2.60    |35.81   |5:25.72 |", result[0]);
    }

	private File createTempFile() throws IOException {
		File temp = File.createTempFile("temp", null);
		temp.deleteOnExit();
		return temp;
	}
}
