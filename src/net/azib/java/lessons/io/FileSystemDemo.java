package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;

/**
 * FileSystemDemo
 *
 * @author anton
 */
public class FileSystemDemo {
	public static void main(String[] args) throws IOException {
		File file = new File(".classpath");
		File dir = new File(file.getParent(), "..");
		System.out.println(file.exists());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(dir.getAbsolutePath());
		System.out.println(dir.getCanonicalPath());
		System.out.println(file.length());
		
		for (File f: dir.listFiles()) {
			System.out.println(f);
		}
	}
}
