package net.azib.java.students.t073639.taskIO;

import static org.junit.Assert.*;

import net.azib.java.lessons.io.PerformanceTimer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
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
	public void filesContentAndLengthCompare() throws Exception {
		System.out.println(PerformanceTimer.measureTime(scp, fIn, fOut));
		fOut.deleteOnExit();
		assertEquals(fIn.length(),fOut.length());
		assertTrue(IOUtils.contentEquals(new FileInputStream(fIn), new FileInputStream(fOut)));
	}
	@Test
	public void dataContentAndLengthCompare() throws Exception {
		InputStream src=new FileInputStream(fIn);
		OutputStream dest=new FileOutputStream(fOut);
		long s=System.currentTimeMillis();
		scp.copy(src, dest);
		System.out.println(System.currentTimeMillis()-s);
		assertEquals(fIn.length(),fOut.length());
		assertTrue(IOUtils.contentEquals(new FileInputStream(fIn), new FileInputStream(fOut)));
	}
}
