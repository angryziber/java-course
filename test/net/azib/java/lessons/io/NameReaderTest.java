package net.azib.java.lessons.io;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * NameReaderTest
 *
 * @author anton
 */
public class NameReaderTest {
	@Test
	public void readName() throws Exception {
		InputStream mockStream = new ByteArrayInputStream("Hello World".getBytes()); 
		
		NameReader reader = new NameReader(new Scanner(mockStream));
		assertEquals("Hello", reader.readName());
		assertEquals("World", reader.readName());
	}
}
