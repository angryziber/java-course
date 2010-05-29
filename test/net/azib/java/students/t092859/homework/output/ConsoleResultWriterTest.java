package net.azib.java.students.t092859.homework.output;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import org.junit.Test;

/**
 * ConsoleResultWriterTest
 *
 * @author kostya
 */
public class ConsoleResultWriterTest {
	
	String expectedConsoleOutput = "\n\nAll results are given in " +
			"[min:]sec or meters, as appropriate\n\nPlace: 1" +
			"\n\tPoints: 4234" +
			"\n\tName: Siim Susi" +
			"\n\tDate of birth: 1.01.76" +
			"\n\tCountry code: EE" +
			"\n\t100m sprint: 12.61" +
			"\n\tLong jump: 5.00" +
			"\n\tShot put: 9.22" +
			"\n\tHigh jump: 1.50" +
			"\n\t400m sprint: 59.39" +
			"\n\t110m hurdles: 16.43" +
			"\n\tDiscus throw: 21.60" +
			"\n\tPole vault: 2.60" +
			"\n\tJavelin throw: 35.81" +
			"\n\t1500m race: 5:25.72\n";
	
	@Test
	public void testConsoleWrite() throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outStream);
		ConsoleResultWriter uut = new ConsoleResultWriter();
		uut.setTestOutput(printStream);
		
		uut.writeResults(prepareResults(), preparePlaces());
		
		assertEquals(expectedConsoleOutput, outStream.toString().replaceAll("\r", ""));
		
	}

	private List<String> preparePlaces() {
		return Arrays.asList(new String[]{"1"});
	}

	private List<DecathlonResult> prepareResults() {
		List<DecathlonResult> results = new ArrayList<DecathlonResult>();
		
		String[] testInput = new String[]{"Siim Susi",
				"01.01.1976", "EE", "12.61","5.00", "9.22", "1.50", "59.39",
				"16.43", "21.60", "2.60", "35.81","5:25.72"};
		
		results.add(new DecathlonResult(testInput));
		
		return results;
	}
	
}
