package net.azib.java.students.t107110.hometask_0331;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class CopyProgramTest {
	@Test
	public void checkSimpleCopyClass() {
		assertThat(CopyProgram.CopyingMethod.SIMPLE.getFileCopier(), is(SimpleCopyProgram.class));
	}

	@Test
	public void checkBufferedCopyClass() {
		assertThat(CopyProgram.CopyingMethod.BUFFERED.getFileCopier(), is(BufferedCopyProgram.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnWrongCopyingMethod() {
		CopyProgram.getFileCopier("wrong");
	}

	@Test
	public void getSimpleFileCopierByCaseInsensitiveName() {
		assertThat(CopyProgram.getFileCopier("simple"), is(SimpleCopyProgram.class));
		assertThat(CopyProgram.getFileCopier("Simple"), is(SimpleCopyProgram.class));
		assertThat(CopyProgram.getFileCopier("SIMPLE"), is(SimpleCopyProgram.class));
	}
}
