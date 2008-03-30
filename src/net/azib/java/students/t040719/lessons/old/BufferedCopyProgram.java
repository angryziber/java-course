package net.azib.java.students.t040719.lessons.old;

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
 * @author romi
 */
public class BufferedCopyProgram implements FileCopier, Runnable {
	private File src;
	private File dest;
	
	public BufferedCopyProgram(){
		super();
	}
	
	public BufferedCopyProgram(File src, File dest){
		this.src = src;
		this.dest = dest;
	}
	
	public void copy(File src, File dest) throws IOException {
		int inp;
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		try{
			while ((inp = bis.read()) != -1){
				bos.write(inp);
			}			
		}
		finally{
			bis.close();
			bos.close();
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
