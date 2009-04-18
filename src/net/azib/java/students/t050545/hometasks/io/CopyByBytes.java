package net.azib.java.students.t050545.hometasks.io;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * copyByBytes
 * 
 * @author libricon
 */
public class CopyByBytes implements FileCopier, DataCopier {

	public void copy(File input, File output) throws IOException {
		if (input.exists() && input.isFile() && input.canRead()) {
			copy(new FileInputStream(input), new FileOutputStream(output));
		}
		else {
			System.out.println("Something wrong with your files !!!");
			System.out.println("exist: " + input.exists());
			System.out.println("file: " + input.isFile());
			System.out.println("canRead: " + input.canRead());
		}
	}

	public void copy(InputStream input, OutputStream output) throws IOException {

		while (input.available() != 0) {
			output.write(input.read());
		}

		input.close();
		output.close();
	}

}
