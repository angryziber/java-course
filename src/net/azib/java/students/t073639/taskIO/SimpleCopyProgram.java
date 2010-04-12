package net.azib.java.students.t073639.taskIO;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/**
 * SimpleCopyProgram
 * 
 * @author t073639
 */
public class SimpleCopyProgram implements FileCopier {

	@Override
	public void copy(File src, File dest) throws IOException {
		FileInputStream inStream = new FileInputStream(src);
		FileOutputStream outStream = new FileOutputStream(dest);
		try {
			int i;
			while ((i = inStream.read()) != -1) {
				outStream.write(i);
			}
		}
		catch (IOException e) {
			System.err.println("Error");
		}
		finally {
			IOUtils.closeQuietly(inStream);
			IOUtils.closeQuietly(outStream);
		}
	}
}
