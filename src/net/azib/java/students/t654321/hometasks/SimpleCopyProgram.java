package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SimpleCopyProgram
 * 
 * @author Karl
 */
public class SimpleCopyProgram implements FileCopier {

	FileInputStream from = null;
	FileOutputStream to = null;

	public void copy(File src, File dest) throws IOException {
		try {
			from = new FileInputStream(src);
			to = new FileOutputStream(dest);
			int readByte;

			while ((readByte = from.read()) != -1)
				to.write(readByte);
		}
		finally {
			if (from != null)
				try {
					from.close();
				}
				catch (IOException e) {
				}
			if (to != null)
				try {
					to.close();
				}
				catch (IOException e) {
				}
		}
	}
}
