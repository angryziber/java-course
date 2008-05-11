package net.azib.java.students.t040719.homework.io;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;


/**
 * FileInputTest
 *
 * @author romi
 */
public class FileInputTest {
	private int errorCode;
	
	/*private String processInput(String s) throws IOException {
		Scanner input = new Scanner(s);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new FileInput().getResults();
		return out.toString();
	}
	
	private void assertOutput(String expected, String input) throws IOException {
		assertEquals(FileInput.INSTRUCTIONS_TEXT + InputChooser.NL + expected + InputChooser.NL, processInput(input));
	}*/
	@Test
	public void noFileGiven() throws IOException{
		FileInput fi = new FileInput(){
	         @Override
	         public void exit(int errorCode) {
	        	 FileInputTest.this.errorCode = errorCode;
	         }
		};
		fi.getResults();
		assertEquals(1,errorCode);
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
		assertEquals(2,errorCode);
	}
	
}
