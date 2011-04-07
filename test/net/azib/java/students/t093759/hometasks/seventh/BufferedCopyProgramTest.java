package net.azib.java.students.t093759.hometasks.seventh;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author dionis
 *         4/7/11 9:01 AM
 */
public class BufferedCopyProgramTest {
	@Test
	public void dataCopyExample() throws IOException {
		byte[] buf = {1, 2, 3, 4, 5, 12, 98, 14};
		InputStream src = new ByteArrayInputStream(buf);
		ByteArrayOutputStream dest = new ByteArrayOutputStream();
		new BufferedCopyProgram().copy(src, dest);
		assertArrayEquals(buf, dest.toByteArray());
	}

	@Test(expected = IllegalArgumentException.class)
	public void sourceInputStreamShouldBeNotNull() throws IOException {
		new BufferedCopyProgram().copy(null, new ByteArrayOutputStream());
	}

	@Test(expected = IllegalArgumentException.class)
	public void destinationInputStreamShouldBeNotNull() throws IOException {
		new BufferedCopyProgram().copy(new ByteArrayInputStream(new byte[]{}), null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sourceFileShouldBeNotNull() throws IOException {
		File tempFile = createTempFile();
		new BufferedCopyProgram().copy(null, tempFile);
	}

	@Test(expected = IllegalArgumentException.class)
	public void destinationFileShouldBeNotNull() throws IOException {
		File tempFile = createTempFile();
		new BufferedCopyProgram().copy(tempFile, null);
	}

	@Test
	public void fileCopyExample() throws IOException {
		char[] sourceChars = {'a', 'b', 'q','a', 'b', 'q','a', 'b', 'q','a', 'b', 'q','a', 'b', 'q','a', 'b', 'q', };
		char[] destChars = new char[sourceChars.length];
		File src= createTempFile();
		File dest= createTempFile();
		FileWriter writer = new FileWriter(src);
		writer.write(sourceChars);
		writer.close();
		new BufferedCopyProgram().copy(src, dest);
		new FileReader(dest).read(destChars);
		assertArrayEquals(sourceChars, destChars);
	}

	private File createTempFile() throws IOException {
		File tempFile = File.createTempFile("prefix", "suffix");
		tempFile.deleteOnExit();
		return tempFile;
	}
}
