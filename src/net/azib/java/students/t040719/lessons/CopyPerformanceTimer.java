package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * CopyPerformanceTimer
 *
 * @author romi
 */
public class CopyPerformanceTimer {
	
	public static long measureTime(FileCopier copier, File src, File dest) throws IOException {
		long t = System.currentTimeMillis();
		copier.copy(src, dest);
		return System.currentTimeMillis() - t;
	}
	
	public static long measureTime(DataCopier copier, InputStream src, OutputStream dest) throws IOException {
		long t = System.currentTimeMillis();
		copier.copy(src, dest);
		return System.currentTimeMillis() - t;
	}
}
