package net.azib.java.students.t030633;

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
 * @author t030633
 */
public class BufferedCopyProgram implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
		while (in.available() > 0)
			out.write(in.read());
		in.close();
		out.close();
	}

}
