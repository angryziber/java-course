package net.azib.java.students.t104607.homework;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.List;
import static junit.framework.Assert.assertEquals;

/**
 * @author 104607 IASM
 */
public class InputCsvTest {
	@Before
	public void disableLog4J() {
		PropertyConfigurator.configure(InputCsv.class.getResource("log4j.disable.properties"));
	}

	@Test
	public void testLoad() throws Exception {
	  	String input = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
		List<Athlete> athletes = new InputCsv().load(inputStream);
		assertEquals("Beata Kana",athletes.get(0).getName());
	}
}
