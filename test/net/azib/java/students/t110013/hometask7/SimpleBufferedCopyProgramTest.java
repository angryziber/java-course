package net.azib.java.students.t110013.hometask7;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class SimpleBufferedCopyProgramTest {

	@Test
	public void fileCopy() throws IOException {
		File src = new File("build.xml");
		File dest = File.createTempFile("temp", null);

		new SimpleCopyProgram().copy(src, dest);
		assertThat(dest.length(), equalTo(src.length()));

		dest.deleteOnExit();
	}
}
