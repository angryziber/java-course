package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;

/**
 * FileDemo
 *
 * @author anton
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		File file = new File(".classpath");
		System.out.println("Name: " + file);
		System.out.println("Full path: " + file.getAbsolutePath());
		System.out.println("Exists: " + file.exists());
		System.out.println("Readable: " + file.canRead());
		System.out.println("Hidden: " + file.isHidden());
		
		File dir = new File(System.getProperty("java.io.tmpdir"));
		assert dir.isDirectory();
		assert dir.canWrite();
		
		File tmpFile = new File(dir, "blah.txt");
		System.out.println(tmpFile.exists());
		System.out.println(tmpFile.getAbsolutePath());
		
		File strangeFile = new File(new File(dir, ".."), "file.txt");
		System.out.println(strangeFile.getPath());
		System.out.println(strangeFile.getCanonicalPath());
		
		File current = new File(".");
		for (File f : current.listFiles()) {
			System.out.println(f.getName());
		}
	}
}
