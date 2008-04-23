package net.azib.java.students.t072054.hometask1;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * SimpleCopyProgram
 *
 * @author r_vassiljev
 */
public class SimpleCopyProgram implements FileCopier{
	
	public void copy(File src, File dest) throws IOException
	{
		/**
		 * Opening file for reading
		 */
		FileReader fr = new FileReader(src);
		
		/**
		 * Creating new file for writing
		 */
		FileWriter fw = new FileWriter(dest);
		
		while (fr.ready()){
			fw.write(fr.read());
		}
	}
	
	
}
