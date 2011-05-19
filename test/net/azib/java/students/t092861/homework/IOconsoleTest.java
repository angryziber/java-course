package net.azib.java.students.t092861.homework;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class IOconsoleTest {
	
	private static final String LN = System.getProperty("line.separator");
	

	@Test
	public void testConsoleInput() throws ParseException {
		ArrayList<Athlete> athletes;
		String[] lines = 
		{
		"Siim Susi,01.01.1976,EE,12.61,5.0,9.22,1.5,59.39,16.43,21.6,2.6,35.81,5:25.72,y,",//3
		"José Mañana Peréz,03.04.1972,ES,13.75,4.84,10.12,1.5,1:8.44,19.18,30.85,2.8,33.88,6:22.75,y,",//4
		"Jeremy Dunkleverylongname,21.05.1981,US,11.23,6.62,11.49,1.75,51.97,14.89,33.37,3.98,45.6,5:24.26,y,",//1
		"Jürgen Schult,11.05.1960,DE,11.39,6.69,10.0,2.05,49.52,15.72,24.39,3.38,30.37,4:27.58,n"//2
		};
		
		String input = "";
		for (int i = 0; i < lines.length; i++) {
			input += lines[i].toString().replaceAll(",", LN);
		}
		athletes = new IOconsole(new Controller()).consoleInput(new StringReader(input));
		assertEquals("Siim Susi", athletes.get(0).getName());
		assertEquals("ES", athletes.get(1).getCountry());
		assertEquals(6379, athletes.get(2).getScore());
		assertEquals(Const.DATE_FORMAT.parse("11.05.1960"), athletes.get(3).getBirthday());
	}

	@Test
	public void testOutput() {
		String[] lines = 
		{
		"Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72",
		"José Mañana Peréz,3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 ",
		"Jeremy Dunkleverylongname,21.05.1981,US,11.23,6.62,11.49,1.75,51.97,14.89,33.37,3.98,45.60,5:24.26",
		"Jürgen Schult,11.05.1960,DE,11.39,6.69,10.00,2.05,49.52,15.72,24.39,3.38,30.37,4:41.38"
		};
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		for (int i = 0; i < lines.length; i++) {
			ArrayList<String> inputData = new ArrayList<String>(Arrays.asList(lines[i].split(",")));
			athletes.add(new Controller().readData(inputData));
		}
		new IOconsole(new Controller()).output(athletes);
	}
}
