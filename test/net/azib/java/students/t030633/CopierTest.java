package net.azib.java.students.t030633;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

/**
 * CopierTest
 * 
 * @author t030633
 */
public class CopierTest {

	private static File from = TestFileLocation.SOURCE_FILE;
	static File to;

	static {
		try {
			to = File.createTempFile("copier.destfile", ".htm");
		}
		catch (IOException e) {
			System.err.println("File initialization error.");
		}
		finally {
			if (to != null)
				to.deleteOnExit();
		}
	}

	@Test
	public void argumentsAccepted() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new Copier(new PrintStream(out)).main(from, to.getAbsolutePath(), "");
		assertEquals("\'\' is not a valid method.", out.toString());
	}

	@Test
	public void fileNotFoundMessage() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new Copier(new PrintStream(out)).main(new File(""), to.getAbsolutePath());
		assertEquals("File not found.", out.toString());
	}

	@Test
	public void destinationExistsMessage() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new Copier(new PrintStream(out)).main(from, from.getAbsolutePath());
		assertEquals("Destination exists.", out.toString());
	}

	@Test
	public void defaultsToSimpleMethod() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new Copier(new PrintStream(out)).main(from, to.getAbsolutePath());
		assertEquals("Using simple method to copy files.", out.toString());
		assertTrue(to.exists());
		to.delete();
	}

	@Test
	public void acceptsMethodArgument() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new Copier(new PrintStream(out)).main(from, to.getAbsolutePath(), "d");
		assertEquals("Using direct channeled method to copy files.", out.toString());
		assertTrue(to.exists());
		to.delete();
	}

}
