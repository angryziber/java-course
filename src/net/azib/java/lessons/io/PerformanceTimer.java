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
	
	public static void main(String[] args) throws IOException {
		measureTime(new DummyFileCopier(), new File("build.xml"), File.createTempFile("dummy", null));
	}

	private static class DummyFileCopier implements FileCopier {
		@Override
		public void copy(File src, File dest) throws IOException {
			System.out.println("Dummy copy of " + src + " to " + dest);
		}
	}
}
