package net.azib.java.students.t073639.taskIO;

import net.azib.java.lessons.io.PerformanceTimer;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

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
	public void filesContentAndLengthCompare() throws Exception {
		System.out.println(PerformanceTimer.measureTime(bcp, fIn, fOut));
		assertEquals(fIn.length(),fOut.length());
		assertTrue(IOUtils.contentEquals(new FileInputStream(fIn), new FileInputStream(fOut)));
	}
	@Test
	public void dataContentAndLengthCompare() throws Exception {
		InputStream src=new FileInputStream(fIn);
		OutputStream dest=new FileOutputStream(fOut);
		long s=System.currentTimeMillis();
		bcp.copy(src, dest);
		System.out.println(System.currentTimeMillis()-s);
		assertEquals(fIn.length(),fOut.length());
		assertTrue(IOUtils.contentEquals(new FileInputStream(fIn), new FileInputStream(fOut)));
	}
}
