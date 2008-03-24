package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.io.FileCopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedCopyProgram
 * 
 * @author Karl
 */
public class BufferedCopyProgram implements FileCopier {

	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	FileInputStream from = null;
	FileOutputStream to = null;

	public void copy(File src, File dest) throws IOException {
		try {
			from = new FileInputStream(src);
			to = new FileOutputStream(dest);
			bis = new BufferedInputStream(from);
			bos = new BufferedOutputStream(to);
			int readByte;

			while ((readByte = bis.read()) != -1)
				bos.write(readByte);
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
