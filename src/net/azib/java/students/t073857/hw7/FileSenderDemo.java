package net.azib.java.students.t073857.hw7;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * FileSenderDemo
 *
 * @author Joonas Vali
 */
public class FileSenderDemo {
	public static void main(String[] args) throws IOException {
		// Change file name to something which exists.
		FileSender sender = new FileSender(InetAddress.getLocalHost(), 2650);
		
		sender.send(new File("C:/Downloads/Readme.txt"));
		sender.send(new File("C:/Downloads/Readme.txt"));
	}
}
