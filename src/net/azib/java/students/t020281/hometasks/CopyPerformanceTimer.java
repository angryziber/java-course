package net.azib.java.students.t020281.hometasks;

import net.azib.java.lessons.io.FileCopier;
import net.azib.java.students.t980814.lec6.BufferedFileCopier;
import net.azib.java.students.t980814.lec6.SimpleFileCopier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * CopyPerformanceTimer
 *
 * @author Trial
 */
public class CopyPerformanceTimer {
	
	public long measure (FileCopier CopyFile, File src, File dst) {
		
		long time;
		
		time = System.currentTimeMillis();
		
		try {
			CopyFile.copy(src,dst);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return time = System.currentTimeMillis() - time;
		
	}
	
	private static File tempFile(){
		
		String myString = "copytest";
		
		try {
			File tmpFile = File.createTempFile("test", ".tmp");
			FileOutputStream tmp = new FileOutputStream(tmpFile);
			
			for (int i = 0; i < 100000; i++) {
				tmp.write(myString.getBytes());
			}
			tmp.close();
			return tmpFile;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	} 
	
	public static void main(String[] args) {
		FileCopier SimpleCopy = new SimpleFileCopier();
		FileCopier BufferedCopy = new BufferedFileCopier();
		CopyPerformanceTimer myTimer = new CopyPerformanceTimer();
		File src = tempFile();
		File dst = null;
		try {
			dst = File.createTempFile("test", ".tmp");
			System.out.println("Buffered copy performance: "+myTimer.measure(BufferedCopy,src, dst)+" ms.");
			dst.delete();
			System.out.println("Simple copy performance: "+myTimer.measure(SimpleCopy,src, dst)+" ms.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			src.delete();
			dst.delete();
		}
	}
}
