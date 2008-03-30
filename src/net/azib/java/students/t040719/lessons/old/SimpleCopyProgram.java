package net.azib.java.students.t040719.lessons.old;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SimpleCopyProgram
 *
 * @author romi
 */
public class SimpleCopyProgram implements FileCopier, Runnable{
	private File src;
	private File dest;
	
	public SimpleCopyProgram(){
		super();
	}
	
	public SimpleCopyProgram(File src, File dest){
		this.src = src;
		this.dest = dest;
	}
	
	public void copy(File src, File dest) throws IOException {
		Integer sisse = null;
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		try{
			while ((sisse = fis.read()) != -1){
				fos.write(sisse);
			}			
		}
		finally{
			fis.close();
			fos.close();
		}
	}
	
	public void run() {
		try {
			copy(src,dest);
		}
		catch (IOException e) {
			
		}
	}
}
