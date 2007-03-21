package net.azib.java.students.t960644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanning
 *
 * @author Lembit
 */
public class ManualScanner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		String line;
/*		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}*/
		System.out.println("Vana oled?");
		Scanner sc = new Scanner(in);
//		line = reader.readLine();
//		int age = Integer.parseInt(line);
		int age = sc.nextInt();
		System.out.println(age);
		/*		int c;
		while((c = in.read()) != 13){
			System.out.print((char)(c));
		}*/
		ChoiceFormat cf = new ChoiceFormat(
				new double[] {0,10,20,30},
				new String[] {"laps","teismeline","kutt","rauk"});
		System.out.println(cf.format(age));

	}

}
