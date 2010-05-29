package net.azib.java.students.t092859.homework.output;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import org.junit.Test;

/**
 * CSVResultWriterTest
 *
 * @author kostya
 */
public class CSVResultWriterTest {
	
	@Test
	public void testResultWrite() throws Exception {
		String expectedResult = "1,4234,\"Siim Susi\",1.01.76,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n";
		
		StringWriter testOutput = new StringWriter();
		CSVResultWriter uut = new CSVResultWriter(testOutput);
		uut.writeResults(prepareResults(), preparePlaces());
		
		assertEquals(expectedResult, testOutput.toString());
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
