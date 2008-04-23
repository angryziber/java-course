package net.azib.java.students.t072054.hometask1;


import java.io.File;

import org.junit.Test;

/**
 * SimpleCopyProgramTest
 * 
 * @author r_vassiljev
 */
public class SimpleCopyProgramTest {

	/**
	 * Test method for SimpleCopyProgram
	 */
	@Test
	public void functionalityTest() {
		File f1 = new File("C:\\source.txt");
		File f2 = new File("C:\\dest.txt");
		SimpleCopyProgram scp = new SimpleCopyProgram();

		try {
			scp.copy(f1, f2);
		}
		catch (Exception e) {
			System.out.println("File exception");
		}
	}
}
