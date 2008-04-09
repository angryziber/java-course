package net.azib.java.students.t040719.homework.io;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;


/**
 * FileInputTest
 *
 * @author romi
 */
public class FileInputTest {
	
	private String processInput(String s) throws IOException {
		Scanner input = new Scanner(s);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new FileInput(input, new PrintStream(out)).getResults();
		return out.toString();
	}
	
	private void assertOutput(String expected, String input) throws IOException {
		assertEquals(FileInput.INSTRUCTIONS_TEXT + InputChooser.NL + expected + InputChooser.NL, processInput(input));
	}
	
	@Test
	public void fileNotFound() throws IOException{
		String file = "C:\\tester";
		assertOutput("'" + file + "'" + FileInput.ERROR_NO_FILE_TEXT, file);
	}
	
}
