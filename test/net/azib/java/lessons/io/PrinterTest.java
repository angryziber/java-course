package net.azib.java.lessons.io;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

public class PrinterTest {
	private static final String LN = System.getProperty("line.separator");

	@Test
	public void hello() {
	    Printer printer = new Printer();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		printer.out = new PrintStream(out);

		printer.printSomething();

		assertEquals("Hello" + LN, new String(out.toByteArray()));
	}
}
