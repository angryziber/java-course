package net.azib.java.students.t092875.hw5;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * SimpleCopyProgram
 *
 * @author Mihhail
 */
public class SimpleCopyProgram implements FileCopier {

	@Override
	public void copy(File src, File dest) throws IOException {
		Reader reader = null;
		Writer writer = null;
		try{
			reader = createReader(src);
			writer = createWriter(dest);
			int c;
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			reader.close();
			writer.close();
		}
	}
	
	private Reader createReader(File src) throws IOException{
		return  new InputStreamReader(new FileInputStream(src));
	}
	
	private Writer createWriter(File dest) throws IOException{
		return  new OutputStreamWriter(new FileOutputStream(dest));
	}

}
