package net.azib.java.students.t030633.lessons;

import java.io.File;
import java.io.IOException;

/**
 * FileSystemDemo
 *
 * @author t030633
 */
public class FileSystemDemo {
	
	public static void main(String[] args) throws IOException {
		
		File root = File.listRoots()[0];
		File bin = new File(root,"bin");
		File ping = new File(bin,"ping");
		
		System.out.println(ping.exists());
		System.out.println(ping.getPath()); // relative path
		System.out.println(ping.getAbsolutePath());
		System.out.println(ping.getCanonicalPath()); // the "shortest" path, without links
		System.out.println(ping.length());
		
	}

}
