package net.azib.java.students.t104607.homework;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author 104607 IASM
 */
public class OutputHtmlTest {
	@Before
	public void disableLog4J() {
		PropertyConfigurator.configure(OutputHtml.class.getResource("log4j.disable.properties"));
	}

	@Test
	public void testSave () throws Exception {
		List<Athlete> athletes = new ArrayList<Athlete>();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		athletes.add(new Athlete("I.Murumüts",dateFormat.parse("19.06.1980"),"EE",
				9.58, 8.95, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.0));
		new OutputHtml().save(outputStream, athletes);

		assertEquals(true,outputStream.toString().contains("<td>3:26.00</td>"));
	}
}
