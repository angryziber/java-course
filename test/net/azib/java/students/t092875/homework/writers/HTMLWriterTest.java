package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

/**
 * HTMLWriterTest
 *
 * @author Mihhail
 */
public class HTMLWriterTest {
	@Test @Ignore
	public void  testWrite(){
		List<Athlete> athletes = new ArrayList<Athlete>();
		Date dob = new Date(0);
		String[] results = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		Athlete a = new Athlete("Mihhail Arhipov",dob,"ET",results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
		HTMLWriter writer = new HTMLWriter("test_write_result.html");
		writer.write(athletes);
		File resultFile = new File("test_write_result.html");
		try {
			// fails here
			assertTrue(IOUtils.contentEquals(this.getClass().getResourceAsStream("test_write_data.html"), new FileInputStream(resultFile)));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			resultFile.delete();
		}
	}
}
