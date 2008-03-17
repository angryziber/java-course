package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;

/**
 * PerformanceTimer
 *
 * @author anton
 */
public class PerformanceTimer {
	
	public static long measureTime(FileCopier copier, File src, File dest) throws IOException {
		long t = System.currentTimeMillis();
		copier.copy(src, dest);
		return System.currentTimeMillis() - t;
	}
	
	public static void main(String[] args) throws InterruptedException {
		// do something
//		FileCopier copier = new SimpleCopyProgram();
//		copier.copy(new File(".classpath"), new File("/tmp/foobar"));
//		System.out.println(runAndMeasureTime(new Simple));
//		System.out.println(runAndMeasureTime(new Simple));
	}
}
