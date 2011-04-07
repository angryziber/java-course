package net.azib.java.students.t104607;
// @author 104607 IASM

import java.io.*;
import java.util.Random;

public class CopyProgramMeasureSpeed {
	public static void main(String[] args) throws IOException {
		byte[] b = new byte[1024*1024];
		Random random = new Random();
		random.nextBytes(b);

		BufferedCopyProgram bufferedCopyProgram = new BufferedCopyProgram();
		File fileBuffered = File.createTempFile("t104607.",".rnd");
		long t = System.currentTimeMillis();
		bufferedCopyProgram.copy(new ByteArrayInputStream(b),new FileOutputStream(fileBuffered));
		System.out.println("BufferedCopyProgram: " + (System.currentTimeMillis() - t) + " ms");

		SimpleCopyProgram simpleCopyProgram = new SimpleCopyProgram();
		File fileSimple = File.createTempFile("t104607.",".rnd");
		t = System.currentTimeMillis();
		simpleCopyProgram.copy(new ByteArrayInputStream(b),new FileOutputStream(fileSimple));
		System.out.println("SimpleCopyProgram: " + (System.currentTimeMillis() - t) + " ms");
	}
}
