package net.azib.java.students.t040750.lesson5;

import java.util.regex.Pattern;

/**
 * RegexpDemo
 *
 * @author t040750
 */
public class RegexpDemo {
	public static void main(String[] args) {
		String s = "Dog";
		System.out.println(s.matches("C..")); 	//. on tähe wildcard
												//Input peab olema 3 tähelina 
												//ja esimene täht peab olema C
		
		String s1 = "Dot2";
		System.out.println(s1.matches("[DC][ao][gt]\\d+"));
		
		String s2 = "Dog6767";
		System.out.println(s2.replaceAll("(Dog|Cat)(\\d+)", "ABC$2"));
		
		s1.split("\\s");
		
		Pattern p = Pattern.compile("(Dog|Cat)(\\d+)");
		//p.matcher();

		
	}
}
