package net.azib.java.students.t050545.hometasks.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
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
//		try{ 
	    File inFile = new File(properties.getProperty("user.dir")+"\\src\\net\\azib\\java\\students\\t050545\\hometasks\\io","input.txt");
		File outFile = new File(properties.getProperty("user.dir")+"\\src\\net\\azib\\java\\students\\t050545\\hometasks\\io","output.txt");
		
		FileCopier copyByte = new CopyByBytes();
		//long time1 = PerformanceTimer.measureTimeOfFileCopier(copier, src, dest)(copyByte, inFile, outFile);
		//System.out.println("Coping byte by byte:\t"+time1+"ns");
		
		CopyByStreamByffer copyStream = new CopyByStreamByffer();
		//long time2 = PerformanceTimer.measureTimeOf(copyStream, inFile, outFile);
		//System.out.println("Coping with buffer:\t"+time2+"ns");
		DecimalFormat ratioDec = new DecimalFormat("0.00");
		//System.out.println("The ratio is "+ratioDec.format((double)time1/time2));
		
		
//		}
//		catch(FileNotFoundException e){
//			System.out.println("File not exist");
//		}
//		catch(IOException e){
//			System.out.println("ERROR!");
//		}
		
	
		
		
			
			
		
	}

}
