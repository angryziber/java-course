package net.azib.java.students.t104540.hometask8;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;

public class SimpleCopyProgram implements FileCopier, DataCopier{
	public void copy(File src, File dest) throws IOException {
		FileReader in = new FileReader(src);
		FileWriter out = new FileWriter(dest);

		int a;
		while((a = in.read()) != -1 ) out.write(a);

		in.close();
		out.close();

	}

	public void copy(InputStream src, OutputStream dest) throws IOException {
		int a;
		while((a = src.read()) != -1 ) dest.write(a);

		src.close();
		dest.close();
	}
}
