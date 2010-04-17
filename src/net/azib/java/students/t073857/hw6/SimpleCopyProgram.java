package net.azib.java.students.t073857.hw6;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SimpleCopyProgram
 *
 * @author Joonas Vali
 */
public class SimpleCopyProgram implements FileCopier{		
	@Override
	public void copy(File src, File dest) throws IOException {
		FileInputStream input = new FileInputStream(src);
		FileOutputStream output = new FileOutputStream(dest);
		int b;
		while((b = input.read())!=-1){
			output.write(b);
		}
		input.close();
		output.close();		
	}
}
