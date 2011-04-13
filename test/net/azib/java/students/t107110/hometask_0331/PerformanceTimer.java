package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.FileDownloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Eduard Shustrov
 */
public class PerformanceTimer extends net.azib.java.lessons.io.PerformanceTimer {
	public static long measureTime(final FileDownloader downloader,
	                               final URL sourceURL, final File destinationFolder) throws IOException {
		final long start = System.currentTimeMillis();
		downloader.download(sourceURL, destinationFolder);
		final long stop = System.currentTimeMillis();
		return stop - start;
	}
}
