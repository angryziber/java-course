package net.azib.java.students.t030632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;

/**
 * Scanning
 *
 * @author t020632
 */
public class ManualScanning {
	public static void main(String [] args) throws IOException{
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		System.out.println("How old are you?");
		String line = reader.readLine();
		int age = Integer.parseInt(line);
		
		ChoiceFormat cf = new ChoiceFormat(
				new double [] {0, 10, 20, 60},
				new String [] {"kid", "teenager", "grown-up", "old"});
		System.out.println(cf.format(age));
		/*
		while((line = reader.readLine()) != null){
			System.out.print(line);
		}*/
	}
}
