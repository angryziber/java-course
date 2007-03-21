package net.azib.java.students.t020544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

/**
 * Scanning
 * 
 * @author Julija
 */
public class Scanning {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		InputStream in = System.in;
		BufferedReader reader =new BufferedReader(new InputStreamReader(in));
		
		
		System.out.println("How old are You?");
		String line=reader.readLine();
		int age = Integer.parseInt(line);
		
		ChoiceFormat cf = new ChoiceFormat(new double[]{5,15,50}, new String[] 
		     { "child", "teenager","old man" });
		
		System.out.println(cf.format(age));
		
		
//		while((line=reader.readLine())!=null){
//			System.out.print(line);
//		}
//		int c;
//		while ((c = in.read()) != -1) {
//			System.out.print((char) c);
//		}
	}
}
