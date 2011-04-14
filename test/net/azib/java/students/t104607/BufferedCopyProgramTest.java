package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.*;

public class BufferedCopyProgramTest {
	@Test
	public void copy() throws Exception {
		byte[] b = new byte[10];
		ByteArrayOutputStream c = new ByteArrayOutputStream();
		Random random = new Random();
		random.nextBytes(b);
		new BufferedCopyProgram().copy(new ByteArrayInputStream(b),c);
		assertArrayEquals(b,c.toByteArray());
	}
}
