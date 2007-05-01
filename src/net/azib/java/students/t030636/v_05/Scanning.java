package net.azib.java.students.t030636.v_05;

import java.io.IOException;
import java.io.InputStream;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanning
 *
 * @author Martin
 */
public class Scanning {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;	
		
		Scanner scanner = new Scanner(in);
		
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		
		ChoiceFormat cf = new ChoiceFormat(new double[] {0, 5, 20, 30, 50, 70}, new String[] {"tita", "väike", "väga noor", "noor", "keskealine", "vana"});
		
		System.out.println(cf.format(age));
		
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		
//		String line;
//		while ((line = reader.readLine()) != null) {
//			System.out.print(line);
//		}
		
		
//		System.out.println("How old are you?");
//		String line = reader.readLine();
//		int age = Integer.parseInt(line);
//		
//		ChoiceFormat cf = new ChoiceFormat(new double[] {0, 5, 20, 30, 50, 70}, new String[] {"tita", "väike", "väga noor", "noor", "keskealine", "vana"});
//		
//		System.out.println(cf.format(age));
		
		
	}

}
