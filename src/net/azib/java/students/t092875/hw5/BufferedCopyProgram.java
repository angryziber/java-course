package net.azib.java.students.t092875.hw5;

import net.azib.java.lessons.io.FileCopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 *
 * @author Mihhail
 */
public class BufferedCopyProgram implements FileCopier {

	@Override
	public void copy(File src, File dest) throws IOException {
		InputStream reader = null;
		OutputStream writer = null;
		try{
			reader = createReader(src);
			writer = createWriter(dest);
			byte[] buffer = new  byte[1024];
			int c = 0;
			while ((c = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, c);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			reader.close();
			writer.close();
		}
	}
	
	private InputStream createReader(File src) throws IOException{
		return new BufferedInputStream(new FileInputStream(src));
	}
	
	private OutputStream createWriter(File dest) throws IOException{
		return new BufferedOutputStream(new FileOutputStream(dest));
	}


}
