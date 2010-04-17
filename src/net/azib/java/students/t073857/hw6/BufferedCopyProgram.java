package net.azib.java.students.t073857.hw6;

import net.azib.java.lessons.io.DataCopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 *
 * @author Joonas Vali
 */
public class BufferedCopyProgram implements DataCopier{
	
	
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		BufferedInputStream input = new BufferedInputStream(src);
		BufferedOutputStream output = new BufferedOutputStream(dest);
		int b;
		while((b = input.read())!=-1){
			output.write(b);
		}
		input.close();
		output.close();	
	}

}
