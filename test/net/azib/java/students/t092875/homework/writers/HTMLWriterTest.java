package net.azib.java.students.t092875.homework.writers;

import net.azib.java.lessons.io.LineBasedReading;
import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * HTMLWriterTest
 * 
 * @author Mihhail
 */
public class HTMLWriterTest {
	List<Athlete> athletes;
	File path;
	@Before
	public void prepareData() {
		athletes = new ArrayList<Athlete>();
		String[] results = { "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20" };
		Athlete a = new Athlete("Mihhail Arhipov", new Date(0), "ET", results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
		
		//File path
		path = new File("src/"+this.getClass().getPackage().toString().replace(".", "/").replace("package ", ""));
	}

	@Test
	@Ignore
	public void testWrite() throws Exception {
		HTMLWriter writer = new HTMLWriter("test_write_result.html");
		writer.write(athletes);
		String data = "";
		String test = "";
		LineNumberReader reader = new LineNumberReader(new FileReader(new File("test_write_result.html")));
		String line = null;
		while((line=reader.readLine())!=null){
			test+=line;
		}
		reader = new LineNumberReader(new FileReader(new File(path,"test_write_data.html")));
		while((line=reader.readLine())!=null){
			data+=line;
		}
		assertEquals(test, data);
	}
}
