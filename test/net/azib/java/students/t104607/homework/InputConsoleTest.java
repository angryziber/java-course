package net.azib.java.students.t104607.homework;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import static junit.framework.Assert.assertEquals;

/**
 * @author 104607 IASM
 */
public class InputConsoleTest {
	@Before
	public void disableLog4J() {
		PropertyConfigurator.configure(InputConsole.class.getResource("log4j.disable.properties"));
	}

	@Test
	public void testLoad() throws Exception {
		String input = "Василий Пупкин\n31.12.1980\nUK\n10.22\n8.22\n19.17\n2.27\n45.68\n13.47\n55.87\n5.76\n79.80\n238.70\ny\n";
		InputConsole inputConsole = new InputConsole();
		inputConsole.scanner = new Scanner(input);
		inputConsole.out = new OutputStreamWriter(new ByteArrayOutputStream());
		List<Athlete> athletes = inputConsole.load();
		assertEquals("Василий Пупкин",athletes.get(0).getName());
	}
}
