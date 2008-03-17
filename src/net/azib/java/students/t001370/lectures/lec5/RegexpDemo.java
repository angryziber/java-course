package net.azib.java.students.t001370.lectures.lec5;

import java.util.regex.Pattern;

/**
 * RegexpDemo
 *
 * @author maksim
 */
public class RegexpDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "Dog32";//"Dot"//"Dog23";//"Dog2";//"Cat"
		System.out.println(s.matches("..."));
		System.out.println(s.matches("D.."));
		System.out.println(s.matches("[DC][oc][gt][0-9]"));
		System.out.println(s.matches("[DC][oc][gt]\\d"));
		System.out.println(s.matches("[DC][oc][gt]\\d+"));
		System.out.println(s.matches("[DC][oc][gt]*"));
		System.out.println(s.matches("(Dog|Cat)\\d+"));
		System.out.println(s.replaceAll("(Dog|Cat)(\\d+)", "$1ABC$2"));

		
		/*Pattern p = Pattern.compile("(Dog|Cat)(\\d+)");
		p.matcher(s).matches();*/
		
	}

}
