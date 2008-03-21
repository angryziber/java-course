package net.azib.java.students.t001370.lectures.lec6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * IODemo
 *
 * @author maksim
 */
public class IODemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		}		
		catch(FileNotFoundException e){
			System.out.println("no file!");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			if (reader != null) 
				reader.close();
			
			System.out.println("closed!");
		}
		
	}

}
