package net.azib.java.students.t030675;

import java.io.IOException;
import java.io.InputStream;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * RegexStuff
 *
 * @author t030675
 */
public class Scanning {

	public static void main(String[] args) throws IOException {
//		InputStream in = System.in;
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		
//		
//		
//		System.out.println("How old are you?");
//		String line = reader.readLine();
//	
//		int age = Integer.parseInt(line);
//		
//		ChoiceFormat cf = new ChoiceFormat(new double[]{0,10,20,60},new String[]{"kid","teenager","grow-up","old human"});
//		
//		System.out.println(cf.format(age));
		
		InputStream in = System.in;
		
		Scanner scanner = new Scanner(in);
		
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		
		ChoiceFormat cf = new ChoiceFormat(
				new double[]{0,10,20,60},
				new String[]{"kid","teenager","grow-up","old human"});
		
		System.out.println(cf.format(age));
	}
	
}
