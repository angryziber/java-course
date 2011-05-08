package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.TestHelper;
import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertEquals;

public class HtmlOutputTest {

	private final String expectedHTML= "<html>\n" +
			"<head>\n" +
			"<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
			"<title>Decathlon competition results</title>\n" +
			"</head>\n" +
			"<body>\n" +
			"<h2>Decathlon competition results</h2>\n" +
			"<table border=\"1\">\n" +
			"<tr bgcolor=\"#FF69B4\">\n" +
			"<th>Place</th><th>Overall result</th><th>Name</th><th>Birthday</th><th>Country</th><th>100 meters</th><th>Long jump</th><th>Shot put</th><th>High jump</th><th>400 meters</th><th>110 meters hurdles</th><th>Discus throw</th><th>Pole vault</th><th>Javelin throw</th><th>1500 meters</th>\n" +
			"</tr>\n" +
			"<tr>\n" +
			"<td>5</td><td>5000</td><td>Siim Susi</td><td>01.01.1976</td><td>EE</td><td>12.61</td><td>5.00</td><td>9.22</td><td>1.50</td><td>59.39</td><td>16.43</td><td>21.60</td><td>2.60</td><td>35.81</td><td>5:25.72</td>\n" +
			"</tr>\n" +
			"</table>\n" +
			"</body>\n" +
			"</html>";

	@Test
	public void testHtmlOutput() throws Exception {
		File htmlFile = TestHelper.createTempFile();

		new HtmlOutput(htmlFile).writeAthletes(TestHelper.createAthleteList());

		assertEquals(expectedHTML, TestHelper.getFileContent(htmlFile));
	}
}
