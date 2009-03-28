package net.azib.java.students.t050545.hometasks.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * CopyByBytesTest
 *
 * @author libricon
 */
public class CopyByBytesTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		Properties properties = System.getProperties();
		try{
	    File inFile = new File(properties.getProperty("user.dir")+"\\src\\net\\azib\\java\\students\\t050545\\hometasks\\io","ENGLISH.EXE");
		File outFile = new File(properties.getProperty("user.dir")+"\\src\\net\\azib\\java\\students\\t050545\\hometasks\\io","ENGLISH2.EXE");
		
		CopyByBytes copyByte = new CopyByBytes();
		long time = PerformanceTimer.measureTime(copyByte, inFile, outFile);
		System.out.println("Coping byte by byte:\t"+time+"ns");
		
		CopyByStreamByffer copyStream = new CopyByStreamByffer();
		time = PerformanceTimer.measureTime(copyStream, inFile, outFile);
		System.out.println("Coping with buffer:\t"+time+"ns");
		
		}
		catch(FileNotFoundException e){
			System.out.println("File not exist");
		}
		catch(IOException e){
			System.out.println("ERROR!");
		}
		
	
		
		
			
			
		
	}

}
