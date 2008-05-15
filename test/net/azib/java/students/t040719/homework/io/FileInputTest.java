package net.azib.java.students.t040719.homework.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import net.azib.java.students.t040719.homework.Athlete;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;


/**
 * FileInputTest
 *
 * @author romi
 */
public class FileInputTest {
	private int errorCode;
	
	@Test
	public void noFileGiven() throws IOException{
		FileInput fi = new FileInput(){
	         @Override
	         public void exit(int errorCode) {
	        	 FileInputTest.this.errorCode = errorCode;
	         }
		};
		fi.getResults();
		assertEquals(6,errorCode);
	}
	
	@Test
	public void fileNotFound() throws IOException{
		String file = "C:\\tester";
		FileInput fi = new FileInput(){
	         @Override
	         public void exit(int errorCode) {
	        	 FileInputTest.this.errorCode = errorCode;
	         }
		};
		fi.getResults(file);
		assertEquals(7,errorCode);
	}
	
	@Test
	public void initiateFileFails(){
		assertTrue(new FileInput().initiateFile("c:\29jrfqnoi2")==false);
	}
	
	@Test
	public void initiateFileSucceeds() throws IOException{
		File tmpFile = File.createTempFile("somefile", ".tmp");
		assertTrue(new FileInput().initiateFile(tmpFile.getAbsolutePath())==true);
	}
	
	@Test
	public void testGetResults() throws URISyntaxException{
		List<Athlete> al = new FileInput().getResults(FileInputTest.class.getResource("inputTest.csv").toURI().getPath());
		int total = 0;
		for (Athlete a:al)
			total += a.getDecathlonPoints();
		assertEquals(14028, total);
		
	}

}
