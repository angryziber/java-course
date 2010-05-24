package net.azib.java.students.t092875.homework.writers;



import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
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
		Locale.setDefault(new Locale("et"));
		athletes = new ArrayList<Athlete>();
		String[] results = { "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20" };
		Athlete a = new Athlete("Mihhail Arhipov", new Date(0), "ET", results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
		
		//File path
		path = new File("test/"+this.getClass().getPackage().toString().replace(".", "/").replace("package ", ""));
	}

	@Test
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
		assertEquals(data, test);
	}
}



