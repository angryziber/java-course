package net.azib.java.students.t092859.homework.output;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import org.junit.Test;

/**
 * HTMLResultWriterTest
 *
 * @author kostya
 */
public class HTMLResultWriterTest {
	
	@Test
	public void testResultWrite() throws Exception {
		String expectedResult = "<html>\n<head>\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<meta content=\"text/html; charset=UTF-8\" http-equiv=\"Content-Type\">\n<title>Decathlon competition results</title>\n</head>\n<body>\n<h1>Decathlon competition results</h1>\n<br>\n  \n<p>\n<b>Place: 1</b>\n		Points: 4234<br>Name: Siim Susi<br>Date of birth: 1.01.76<br>Country: EE<table>\n<tr>\n<td width=\"50\"></td><td width=\"200\"><b>Event</b></td><td width=\"200\"><b>Performance</b></td>\n</tr>\n<tr>\n<td></td><td>100M Sprint</td><td>12.61</td>\n</tr>\n<tr>\n<td></td><td>Long Jump</td><td>5.00</td>\n</tr>\n<tr>\n<td></td><td>Shot Put</td><td>9.22</td>\n</tr>\n<tr>\n<td></td><td>High Jump</td><td>1.50</td>\n</tr>\n<tr>\n<td></td><td>400M Sprint</td><td>59.39</td>\n</tr>\n<tr>\n<td></td><td>110M Hurdles</td><td>16.43</td>\n</tr>\n<tr>\n<td></td><td>Discus Throw</td><td>21.60</td>\n</tr>\n<tr>\n<td></td><td>Pole Vault</td><td>2.60</td>\n</tr>\n<tr>\n<td></td><td>Javelin Throw</td><td>35.81</td>\n</tr>\n<tr>\n<td></td><td>1500M Race</td><td>5:25.72</td>\n</tr>\n</table>\n</p>\n\n</body>\n</html>\n";
		
		StringWriter testOutput = new StringWriter();
		HTMLResultWriter uut = new HTMLResultWriter(testOutput);
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
