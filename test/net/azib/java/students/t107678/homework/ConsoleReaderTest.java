package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;


public class ConsoleReaderTest {

	ConsoleReader input = new ConsoleReader();

	@Test
	public void testReturnIfNotEmpty() throws Exception {
		input.reader = new BufferedReader(new StringReader("\n\nHello"));
		assertEquals("Hello", input.returnIfNotEmpty());


	}

	@Test
	@Ignore //TODO how to test multiple user interaction???
	public void testReadRecordManualy() throws Exception {

		assertEquals("Blah", input.readRecordManualy());

	}

}
