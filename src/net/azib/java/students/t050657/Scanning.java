package net.azib.java.students.t050657;

import java.io.InputStream;
import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 * Scanning
 *
 * @author t050657
 */
public class Scanning {

	public static void main(String[] args) {
		InputStream is = System.in;
		Scanner scanner = new Scanner(is);
		
		int age = scanner.nextInt();
		
		ChoiceFormat sf = new ChoiceFormat(
				new double[]{0,5,15,20},
				new String[]{"unborned 8)","kid","teenager","student"});

		System.out.println(sf.format(age));
	}
}
