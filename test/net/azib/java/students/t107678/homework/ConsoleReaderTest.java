package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ConsoleReaderTest {

	ConsoleReader input = new ConsoleReader();

	@Test
	public void testReturnIfNotEmpty() throws Exception {
		input.reader = new BufferedReader(new StringReader("\n\nHello"));
		assertEquals("Hello", input.returnIfNotEmpty());


	}

	@Test
	public void readRecordManualyCorrectly() throws Exception {

		ConsoleReader consoleReader = mock(ConsoleReader.class);
		when(consoleReader.readRecordManualy()).thenReturn("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01\"");

		assertEquals("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01\"",consoleReader.readRecordManualy());


	}

	@Test
	public void readRecordManualyIncorrectly() throws Exception {

		ConsoleReader consoleReader = mock(ConsoleReader.class);
		when(consoleReader.readRecordManualy()).thenReturn("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01");

		assertNotSame("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01\"", consoleReader.readRecordManualy());


	}


}
