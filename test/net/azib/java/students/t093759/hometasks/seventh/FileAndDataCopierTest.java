package net.azib.java.students.t093759.hometasks.seventh;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author dionis
 *         4/7/11 9:01 AM
 */
@Ignore
public abstract class FileAndDataCopierTest {
	@Test
	public void dataCopyExample() throws IOException {
		byte[] buf = {1, 2, 3, 4, 5, 12, 98, 14};
		InputStream src = new ByteArrayInputStream(buf);
		ByteArrayOutputStream dest = new ByteArrayOutputStream();
		getCopyProgram().copy(src, dest);
		assertArrayEquals(buf, dest.toByteArray());
	}

	@Test(expected = RuntimeException.class)
	public void sourceInputStreamShouldBeNotNull() throws IOException {
		getCopyProgram().copy(null, new ByteArrayOutputStream());
	}

	@Test(expected = RuntimeException.class)
	public void destinationInputStreamShouldBeNotNull() throws IOException {
		getCopyProgram().copy(new ByteArrayInputStream(new byte[]{}), null);
	}

	@Test(expected = RuntimeException.class)
	public void sourceFileShouldBeNotNull() throws IOException {
		File tempFile = createTempFile();
		getCopyProgram().copy(null, tempFile);
	}

	@Test(expected = RuntimeException.class)
	public void destinationFileShouldBeNotNull() throws IOException {
		File tempFile = createTempFile();
		getCopyProgram().copy(tempFile, null);
	}

	@Test
	public void fileCopyExample() throws IOException {
		byte[] sourceBytes = {0, 1, 2, 3, 4,5,6,7,8,9,10 };
		byte[] destBytes = new byte[sourceBytes.length];
		File src= createTempFile();
		File dest= createTempFile();
		FileOutputStream outputStream = new FileOutputStream(src);
		outputStream.write(sourceBytes);
		outputStream.close();
		getCopyProgram().copy(src, dest);
		FileInputStream inputStream = new FileInputStream(dest);
		inputStream.read(destBytes);
		assertArrayEquals(sourceBytes, destBytes);
	}

	private File createTempFile() throws IOException {
		File tempFile = File.createTempFile("prefix", "suffix");
		tempFile.deleteOnExit();
		return tempFile;
	}

	protected abstract FileAndDataCopier getCopyProgram();
}
