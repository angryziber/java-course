package net.azib.java.students.t030675;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * StreamTest
 *
 * @author t030675
 */
public class FileDisplayer {
	
	public static void main(String[] args) throws IOException {
//		String filename = "H:\\java.txt";//".classpath";
//		//Reader reader = new FileReader(filename);
//		
//		InputStream is = new FileInputStream(filename);
//		Reader reader = new InputStreamReader(is,"UTF-8");
//		
//		while(reader.ready()){
//			System.out.print((char)reader.read());
//			
//		}
//		System.out.println();
//		reader.close();
		
		
//		Reader reader = new StringReader("Hello Kostja");
//		char c;
//		while((c = (char)reader.read())!=-1){
//			System.out.print((char)c);
//			
//		}
//		System.out.println();
//		reader.close();		
		
		long startTime = System.currentTimeMillis();
		Reader reader = null;
		try{
		String filename = "H:\\java.txt";//".classpath";
		
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		
		reader = new InputStreamReader(is);
		
		int c;
		while((c = (int)reader.read())!=-1){
			System.out.print((char)c);
			
		}
		System.out.println();
		
		}
		catch(IOException e){
			System.out.println("Unable to read data");
		}
		finally{
			try {
				reader.close();	
			}
			catch (Exception e) {
				// this should not happen
			}
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
}
