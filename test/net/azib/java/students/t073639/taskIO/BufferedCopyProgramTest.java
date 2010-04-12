package net.azib.java.students.t073639.taskIO;

import net.azib.java.lessons.io.PerformanceTimer;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * BufferedCopyProgramTest
 *
 * @author t073639
 */
public class BufferedCopyProgramTest {
	BufferedCopyProgram bcp=new BufferedCopyProgram();
	File path = new File("test/net/azib/java/students/t073639/taskIO");
	File fIn = new File(path, "8-io.pdf");
	File fOut = new File(path, "8-io.pdf.buf.copy");
	@Test
	public void lengthCompare() throws Exception {
		System.out.println(PerformanceTimer.measureTime(bcp, fIn, fOut));
		assertEquals(fIn.length(),fOut.length());
	}
	@Test
	public void contentEquals() throws Exception {
		assertTrue(IOUtils.contentEquals(new FileInputStream(fIn), new FileInputStream(fOut)));
	}
}
