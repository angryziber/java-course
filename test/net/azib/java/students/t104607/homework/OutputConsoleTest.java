package net.azib.java.students.t104607.homework;

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
public class OutputConsoleTest {
	@Test
	public void testSave() throws Exception {
		List<Athlete> athletes = new ArrayList<Athlete>();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		athletes.add(new Athlete("I.Murumüts",dateFormat.parse("19.06.1980"),"EE",
				9.58, 8.95, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.0));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		new OutputConsole().save(outputStream, athletes);
		assertEquals(true, outputStream.toString().endsWith(",3:26,12544,null\n"));
		//assertEquals(23, outputStream.size());
	}
}
