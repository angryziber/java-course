package net.azib.java.students.t050545.hometasks.io;

import net.azib.java.students.t050545.hometasks.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * PerformanceTimer
 *
 * @author anton
 */
public class PerformanceTimer {
	
	public static void measureTimeOfFileCopier(FileCopier copier) throws IOException {
		long t = System.nanoTime();
		System.err.println("Measuring performance of " + copier);
		File src = new File(PerformanceTimer.class.getResource("ENGLISH.EXE").getFile());
		File dest = File.createTempFile("ENGLISH", "EXE");
		copier.copy(src, dest);
		dest.delete();
		System.err.println("Nanoseconds: " + (System.nanoTime() - t));
	}
	
	public static long measureTimeOfDataCopier(DataCopier copier, InputStream src, OutputStream dest) throws IOException {
		long t = System.nanoTime();
		copier.copy(src, dest);
		return System.nanoTime() - t;
	}
	public static void main(String[] args) throws Exception {
		measureTimeOfFileCopier(new CopyByBytes());
		measureTimeOfFileCopier(new CopyByStreamByffer());
	}
}
