package net.azib.java.students.t050545.hometasks.io;

import net.azib.java.students.t050545.hometasks.io.FileCopier;

import java.io.File;
import java.io.IOException;

/**
 * PerformanceTimer
 *
 * @author anton
 */
public class PerformanceTimer {
	
	public static long measureTime(FileCopier copier, File src, File dest) throws IOException {
		long t = System.nanoTime();
		copier.copy(src, dest);
		return System.nanoTime() - t;
	}
	
	public static void main(String[] args) throws InterruptedException {
	}
}
