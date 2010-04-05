package net.azib.java.lessons.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * ReadingPerformanceDemo
 *
 * @author anton
 */
public class ReadingPerformanceDemo {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		File file = new File(new File("lib"), "antlr.jar");
		System.out.println(file.length());
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		try {
			byte[] buf = new byte[4096];
			int len;
			while ((len = in.read(buf)) != -1) {
			}
		}
		finally {
			in.close();
		}
		
		System.out.println("took " + (System.currentTimeMillis() - start) + " ms");
	}
}
