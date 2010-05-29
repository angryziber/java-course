package net.azib.java.students.t092859.hometask8;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SimpleCopyProgram
 *
 * @author kostya
 */
public class SimpleCopyProgram implements FileCopier{

	@Override
	public void copy(File src, File dest) throws IOException {
		FileInputStream input = new FileInputStream(src);
		FileOutputStream output = new FileOutputStream(dest);
		
		int c;
		while((c = input.read()) != -1)
			output.write(c);
		
		input.close();
		output.close();
	}

}
