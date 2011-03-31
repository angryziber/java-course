package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSystemDemo {
	public static void main(String[] args) throws IOException {
		File currentDirectory = new File(".");
		File file = new File(currentDirectory, "build.xml");
		File inexistent = new File(currentDirectory, "foo.bar");

		System.out.println(file.exists());
		System.out.println(inexistent.exists());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(inexistent.getAbsolutePath());
		System.out.println(file.getCanonicalPath());

		File tempFile = File.createTempFile("foo", ".bar");
		System.out.println(tempFile.getAbsolutePath());
		tempFile.deleteOnExit();

		RandomAccessFile fileAccess = new RandomAccessFile(file, "r");
		String firstLine = fileAccess.readLine();
		System.out.println(firstLine);
		fileAccess.seek(100);
		System.out.println(fileAccess.read());

		System.out.println("Files in current dir:");
		for (File f : currentDirectory.listFiles()) {
			System.out.println((f.isDirectory() ? "DIR:" : "FILE:") + f.getName());
		}
	}
}
