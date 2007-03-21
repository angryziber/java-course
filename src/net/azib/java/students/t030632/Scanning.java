package net.azib.java.students.t030632;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanner
 *
 * @author t020632
 */
public class Scanning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream in = System.in;
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("How old are you?");
		int age = Integer.parseInt(scanner.next());
		
		ChoiceFormat cf = new ChoiceFormat(
				new double [] {0, 10, 20, 60},
				new String [] {"kid", "teenager", "grown-up", "old"});
		System.out.println(cf.format(age));

	}

}
