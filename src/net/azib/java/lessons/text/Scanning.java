package net.azib.java.lessons.text;

import java.io.IOException;
import java.io.InputStream;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanning
 *
 * @author anton
 */
public class Scanning {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		
		Scanner scanner = new Scanner(in);
		
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		
		ChoiceFormat cf = new ChoiceFormat(
				new double[] {0, 10, 20, 60},
				new String[] {"kid", "teenager", "grown-up", "old human"});
		System.out.println(cf.format(age));
	}
}




