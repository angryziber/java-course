package net.azib.java.lessons.io;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * FileListerTest
 *
 * @author anton
 */
public class FileListerTest {
	@Test
	public void testListing() throws Exception {
		File file = new File(".");
		Set<String> files = new HashSet<String>(Arrays.asList(file.list()));
		assertTrue(files.contains(".classpath"));
		assertTrue(files.contains("src"));
	}
}
