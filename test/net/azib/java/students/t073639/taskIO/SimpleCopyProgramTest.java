package net.azib.java.students.t073639.taskIO;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**
 * SimpleCopyProgramTest
 * 
 * @author t073639
 */
public class SimpleCopyProgramTest {
	SimpleCopyProgram scp = new SimpleCopyProgram();
	File path = new File("test/net/azib/java/students/t073639/taskIO");
	File fIn = new File(path, "8-io.pdf");
	File fOut = new File(path, "8-io.pdf.copy");

	@Test
	public void LengthCompare() throws Exception {
		scp.copy(fIn, fOut);
		System.out.println(scp.ms);
		assertEquals(fIn.length(),fOut.length());
	}
}
