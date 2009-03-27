package net.azib.java.lessons.io;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Test;


/**
 * FileIODemoTest
 *
 * @author anton
 */
public class FileIODemoTest {
	@Test
	public void readAndDisplay() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileIODemo.out = new PrintStream(baos);
		
		FileIODemo.readAndDisplay(new StringReader("Hello"));
		
		assertEquals("Hello", new String(baos.toByteArray()));
	}
}
