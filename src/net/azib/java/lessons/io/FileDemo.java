package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * FileDemo
 *
 * @author anton
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		File parent = new File(new File(".."), "java");
		File f = new File(parent, ".classpath");
		System.out.println(f);
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getCanonicalPath());
		System.out.println("exists: " + f.exists());
		
		File tmpFile = File.createTempFile("foo", ".bar");
		tmpFile.deleteOnExit();
		System.out.println("temp file: " + tmpFile);
		
		File currentDir = new File(".");
		for (File file : currentDir.listFiles()) {
			System.out.println(file.getName());
		}
		
		RandomAccessFile random = new RandomAccessFile(f, "r");
		System.out.println("First byte: " + random.read());
		random.close();
	}
}
