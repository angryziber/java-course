package net.azib.java.students.t092875.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
/**
 * DecathlonControllerTest
 *
 * @author Mihhail
 */
public class DecathlonControllerTest {
	@Test
	public void testSetReader(){
		DecathlonController dc = new DecathlonController();
		String[] commands = {"-csv", "test.csv"};
		assertEquals("CSVReader", dc.setReader(commands).getClass().getSimpleName());
		String[] commands2 = {"-db", "2"};
		assertEquals("DatabaseReader", dc.setReader(commands2).getClass().getSimpleName());
		String[] commands3 = {"-console"};
		assertEquals("ConsoleReader", dc.setReader(commands3).getClass().getSimpleName());
		String[] commands4 = {"console"};
		assertNull(dc.setReader(commands4));
	}
	
	@Test
	public void testSetWriter(){
		DecathlonController dc = new DecathlonController();
		String[] commands = {"-csv", "test.csv","-csv", "test.csv"};
		assertEquals("CSVWriter", dc.setWriter(commands).getClass().getSimpleName());
		String[] commands2 = {"-db", "2","-xml", "test.xml"};
		assertEquals("XMLWriter", dc.setWriter(commands2).getClass().getSimpleName());
		String[] commands3 = {"-console","-html", "test.html"};
		assertEquals("HTMLWriter", dc.setWriter(commands3).getClass().getSimpleName());
		String[] commands4 = {"-console","-console"};
		assertEquals("ConsoleWriter", dc.setWriter(commands4).getClass().getSimpleName());
		String[] commands5 = {"-console","console"};;
		assertNull(dc.setWriter(commands5));
	}
}
