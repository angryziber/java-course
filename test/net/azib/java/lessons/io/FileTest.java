package net.azib.java.lessons.io;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

/**
 * FileTest
 *
 * @author anton
 */
public class FileTest {

	@Test
	public void testFileMethods() throws Exception {
		File f = File.listRoots()[0]; 
		f = new File(f, "usr");
		f = new File(f, "bin");
		f = new File(f, "man");

		assertEquals("man", f.getName());
		assertEquals("bin", f.getParentFile().getName());
		assertEquals("/usr/bin/man", f.getAbsolutePath());
		assertEquals(new File("/usr/bin/man"), f);
		
		assertTrue(f.isAbsolute());
		
		if (System.getProperty("os.name").indexOf("Linux") >= 0) {
			assertTrue(f.exists());
			assertTrue(f.isFile());
			assertTrue(f.getParentFile().isDirectory());
			assertTrue(f.canRead());
			assertTrue(f.canExecute());
		}
	}
}
