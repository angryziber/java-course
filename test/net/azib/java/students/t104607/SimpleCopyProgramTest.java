package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

public class SimpleCopyProgramTest {
	@Test
	public void copy() throws Exception {
		byte[] b = new byte[10];
		ByteArrayOutputStream c = new ByteArrayOutputStream();
		Random random = new Random();
		random.nextBytes(b);
		new SimpleCopyProgram().copy(new ByteArrayInputStream(b),c);
		assertArrayEquals(b,c.toByteArray());
	}
}
