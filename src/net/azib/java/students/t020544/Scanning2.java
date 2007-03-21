package net.azib.java.students.t020544;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanning2
 *
 * @author Julija Kondratjeva
 */
public class Scanning2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InputStream in = System.in;	
		Scanner scanner = new Scanner(in);
		System.out.println("How old are You?");
		
		int age = scanner.nextInt();
		
		ChoiceFormat cf = new ChoiceFormat(new double[]{5,15,50}, new String[] 
		     { "child", "teenager","old man" });
		
		System.out.println(cf.format(age));

	}

}
