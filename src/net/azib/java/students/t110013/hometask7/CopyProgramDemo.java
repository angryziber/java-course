package net.azib.java.students.t110013.hometask7;

import java.io.File;
import java.io.IOException;

import static net.azib.java.lessons.io.PerformanceTimer.measureTime;

/**
 * @author Vadim
 */
public class CopyProgramDemo {

	public static void main(String[] args) throws IOException {
		File src = new File("build.xml");
		File dest = File.createTempFile("dummy", null);

		System.out.println("Simple file copy: " + measureTime(new SimpleCopyProgram(), src, dest) + " ms");
		System.out.println("Simple buffered file copy: " + measureTime(new SimpleBufferedCopyProgram(), src, dest) + " ms");

		dest.deleteOnExit();
	}
}
