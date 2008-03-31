package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

/**
 * AbstractCopierTest
 *
 * @author romi
 */
public abstract class AbstractCopierTest {
	private static final String SEP = File.separator;
	private File in= null;
	private File out = null; 

	private final AbstractCopier copier;

	public AbstractCopierTest(AbstractCopier copier) {
		this.copier = copier;
		try {
			out = File.createTempFile("out", ".file");
			in = new File(new URI(LessonSeven.class.getClassLoader().getResource("net"+SEP+"azib"+SEP+"java"+SEP+"students"+SEP+"t040719"+SEP+"lessons"+SEP+"test.file").toString()));
		}
		catch (IOException e) {
		}
		catch (URISyntaxException e) {
		}
	}
	
	@Test
	public void testFileCopy() throws IOException {
		copier.copy(in, out);
		assertEquals(in.length(), out.length());
	}

	@Test
	public void testDataCopy() throws IOException {
		InputStream is = new FileInputStream(in);
		OutputStream os = new FileOutputStream(out);
		copier.copy(is, os);
		assertEquals(in.length(), out.length());
	}

}
