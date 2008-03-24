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
public class FileCopierImpl implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream srcFile = null;
		FileOutputStream dstFile = null;
		int data = 0;
		try {
			srcFile = new FileInputStream(src);
			dstFile = new FileOutputStream(dest);
			while ((data = srcFile.read()) != -1) {
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
