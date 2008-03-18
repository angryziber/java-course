package net.azib.java.students.t030633;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SimpleCopyProgram
 * 
 * @author t030633
 */
public class SimpleCopyProgram implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		FileOutputStream out = new FileOutputStream(dest);
		FileInputStream in = new FileInputStream(src);
		while (in.available() > 0)
			out.write(in.read());
		in.close();
		out.close();
	}

}
