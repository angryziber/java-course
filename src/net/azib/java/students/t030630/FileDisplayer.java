package net.azib.java.students.t030630;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.omg.CosNaming.IstringHelper;

/**
 * FileDisplayer
 * 
 * @author Kasutaja
 */
public class FileDisplayer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args){
		long starttime = System.currentTimeMillis();
		String fileName = ".classpath";
		Reader reader= null;
		try{
		InputStream is = new BufferedInputStream(new FileInputStream(fileName));
		reader = new InputStreamReader(is, "UTF-8");
		//Reader reader = new StringReader("Hello");
		int c;
		while ((c = reader.read())!= -1) {
			System.out.print((char) c);
		}
		reader.close();
		}catch(IOException e){
			System.out.println("Unable to read data");
		}
		finally{
			try{
			reader.close();
			}catch (IOException e){
				//this should not happen
			}
		}
		System.out.println();
		System.out.println(System.currentTimeMillis()- starttime);
	}

}
