package net.azib.java.students.t001370.lectures.lec6.home;

import net.azib.java.lessons.io.FileCopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedCopyProgram
 *
 * @author maksim
 */
public class BufferedCopyProgram implements FileCopier, Runnable{
	
	private BufferedInputStream input;
	private BufferedOutputStream output;
	
	public int initStreams(File src, File dest){
		try {
			input = new BufferedInputStream(new FileInputStream(src));
			output = new BufferedOutputStream(new FileOutputStream(dest));
			
			return 0;
		}
		catch (FileNotFoundException e) {
			return -1;
		}
	}
	
	public void closeStreams()  throws IOException {
		input.close();
		output.close();
	}
	
	
	public void copy(File src, File dest) throws IOException {
		int infoRead = 0;
		//byte[] b = new byte[10000];
		
		if (initStreams(src, dest) != -1) {
			while ((infoRead = input.read()) != -1){
				output.write(infoRead);
			}
			dest.deleteOnExit();
			closeStreams();
		}
	}
	
	public void run(){
		File src = new File("C:\\Users\\maksim\\Desktop\\Kool\\IAG0040 Programmeerimise erikursus II\\Speller.exe");
		File dest = new File("C:\\Users\\maksim\\Desktop\\Kool\\IAG0040 Programmeerimise erikursus II\\Speller_BufferedDest.exe");
		
		try{
			copy(src, dest);
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException" + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("IOException" + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new BufferedCopyProgram().run();
	}
}