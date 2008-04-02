package net.azib.java.students.t030633.hometasks.copier;

import net.azib.java.students.t030633.FileLocations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.Test;

/**
 * CopierTest
 * 
 * @author t030633
 */
public class CopierTest {

	private static File from = FileLocations.SOURCE_FILE;
	static File to = FileLocations.DESTINATION_FILE;

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
