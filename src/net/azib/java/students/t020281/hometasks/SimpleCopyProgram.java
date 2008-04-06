package net.azib.java.students.t020281.hometasks;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileCopierImpl
 *
 * @author Trial
 */
public class SimpleCopyProgram implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream srcFile = null;
		FileOutputStream dstFile = null;
		try {
			srcFile = new FileInputStream(src);
			dstFile = new FileOutputStream(dest);
			while (srcFile.available() != 0) {
				dstFile.write(srcFile.read());

			}
		}
		catch (IOException e){}
		finally {
			if (srcFile!= null) {
				try {
				srcFile.close();
				}
				catch (IOException e) {}
			}
			if (dstFile!= null) {
				try {
				dstFile.close();
				}
				catch (IOException e) {}
			}
		}
	}

}
