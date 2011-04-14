package net.azib.java.students.t104540.hometask8;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class AbstractCopyProgramTest {
		public static final String TESTSTRING = "sometext";
	private File dest = new File("dest");
	private File src;
	private static SimpleCopyProgram copyProgram;

	public AbstractCopyProgramTest(SimpleCopyProgram scp){
		copyProgram = scp;
	}

	@Before
	public void createSrcFile() throws IOException {
		src = File.createTempFile("src", null);
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(src));
		outputStream.write(TESTSTRING.getBytes());
	}


	@Test
	public void isDestFileCreated() throws IOException {
		copyProgram.copy(src, dest);
		assertThat(dest.exists(), is(true));
	}

	@Test
	public void isContentCopied() throws IOException {
		FileReader srcReader = new FileReader(src);
		FileReader destReader = new FileReader(dest);
		int a;
		String content1 = "";
		while((a = srcReader.read()) != -1)content1= content1 + a;
		String content2 = "";
		while((a = destReader.read()) != -1)content2= content2 + a;
		assertEquals(content1, content2);
		srcReader.close();
		destReader.close();
	}

	@Test
	public void streamCopyTest() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copyProgram.copy(new ByteArrayInputStream(TESTSTRING.getBytes()), out);
		assertEquals(TESTSTRING, new String(out.toByteArray()));
		assertThat(TESTSTRING+"moretext",not(equalTo(new String(out.toByteArray()))));
	}

	@After
	public void deleteTestFile() {
		dest.deleteOnExit();
		src.deleteOnExit();
	}
}
