package net.azib.java.students.t073857.hw7;

import java.io.File;
import java.io.IOException;

/**
 * FileRecieveServerDemo
 *
 * @author Joonas Vali
 */
public class FileRecieveServerDemo {
	public static void main(String[] args) throws IOException {
		new FileRecieveServer().reciever(2650, new File("C:/"));
	}
}
