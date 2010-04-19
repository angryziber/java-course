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
		new FileRecieveServer(2650).recieveTo(new File("C:/"));
	}
}
