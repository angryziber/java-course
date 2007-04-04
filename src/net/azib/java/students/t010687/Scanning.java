package net.azib.java.students.t010687;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanning
 *
 * @author t010687
 */
public class Scanning {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		
		Scanner scanner = new Scanner(in);

		System.out.println("How old are you?");

		int age =  scanner.nextInt();
		
		ChoiceFormat cf = new ChoiceFormat(
				new double[]{0,10,20,60},
				new String[]{"kid","teenager","grown-up","old man"});
		System.out.println(cf.format(age));
		

	}

	//J2rgnev pikem ja ilma scannita
	/*public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		System.out.println("How old are you?");
		String line  = reader.readLine();
		int age = Integer.parseInt(line);
		
		ChoiceFormat cf = new ChoiceFormat(
				new double[]{0,10,20,60},
				new String[]{"kid","teenager","grown-up","old man"});
		System.out.println(cf.format(age));
		
		//String line;
		//while((line = reader.readLine()) != null) {
		//	System.out.print(line);
		//}	
		//int c;
		//while((c=in.read()) != -1) {
		//	System.out.print((char)c);
		//}
	}
*/
}
