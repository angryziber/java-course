package net.azib.java.students.t104887.lecture8;

import java.io.*;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 31.03.11
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class lecture {
	public static void main(String[] args) throws FileNotFoundException {
		File tempFile = null;

		try {
			tempFile = File.createTempFile("myfile", ".tmp");
			FileOutputStream fout = new FileOutputStream(tempFile);
			PrintStream out = new PrintStream(fout);
			System.out.println(tempFile.getAbsolutePath());
			InputStream stream = new FileInputStream(tempFile.getAbsolutePath());
			OutputStream output = System.out;
			int b;
			while ((b = stream.read()) != -1) {
				output.write((byte) b);
			}
			stream.close();
			tempFile.deleteOnExit();
		} catch (IOException ex) {
			System.out.println("There was a problem creating/writing to the temp file");
			ex.printStackTrace();
		} finally {

		}


	}

}
