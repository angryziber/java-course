package net.azib.java.students.t980814;

import net.azib.java.students.t980814.lec6.BufferedFileCopier;
import net.azib.java.students.t980814.lec6.SimpleFileCopier;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;


/**
 * FileCopierTest
 *
 * @author dell
 */
public class FileCopierTest {

	private final static String SOURCE_FILE = System.getProperty("java.io.tmpdir") +
	  										  System.getProperty("file.separator") +
	  										  "SimpleFileCopierTest.src";
	
	private final static String DEST_FILE = System.getProperty("java.io.tmpdir") +
	  										System.getProperty("file.separator") +
	  										"SimpleFileCopierTest.dest";

	private final static int TEMPFILE_SIZE = 1024 << 8;

	private void createTempFile(String fileName) throws IOException {
		File newFile = new File(fileName);
		newFile.createNewFile();

		FileOutputStream output = new FileOutputStream(newFile);
		byte[] randomData = new byte[TEMPFILE_SIZE];
		Random rand = new Random();
		rand.nextBytes(randomData);
		output.write(randomData);
		output.close();	
	}

	private void compareSourceAndDestination(File src, File dest) throws IOException {
		FileInputStream inputSource = null;
		FileInputStream inputDest = null;
		try {
			inputSource = new FileInputStream(src);
			inputDest = new FileInputStream(dest);
			byte[] srcData = new byte[TEMPFILE_SIZE];
			byte[] destData = new byte[TEMPFILE_SIZE];
			inputSource.read(srcData);
			inputDest.read(destData);
			assertArrayEquals(srcData, destData);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (inputSource != null)
				inputSource.close();
			if (inputDest != null)
				inputDest.close();
		}
	}
	
	@Test
	public void testSimpleFileCopier() throws IOException {
		createTempFile(SOURCE_FILE);
		
		File srcFile = new File(SOURCE_FILE);
		File destFile = new File(DEST_FILE);
	
		try {
			new SimpleFileCopier().copy(srcFile, destFile);
			compareSourceAndDestination(srcFile, destFile);
		}
		finally {
			srcFile.deleteOnExit();
			destFile.deleteOnExit();
		}
	}


	@Test
	public void testBufferedFileCopier() throws IOException {
		createTempFile(SOURCE_FILE);
		
		File srcFile = new File(SOURCE_FILE);
		File destFile = new File(DEST_FILE);
	
		try {
			new BufferedFileCopier().copy(srcFile, destFile);
			compareSourceAndDestination(srcFile, destFile);
		}
		finally {
			srcFile.deleteOnExit();
			destFile.deleteOnExit();
		}
		
	}
	
}
