package net.azib.java.students.t030611;

/**
 * StringDemo
 * 
 * @author t030611
 */
public class StringDemo {
	static void printStuff(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

	}

	public static void main(String... args) {
		// String s1="sa";
		// String s2=s1+"";
		printStuff(args);
		// String s;
		StringBuilder sb = new StringBuilder();
		for (int i : new int[] {1,2,3,4,5}) {
			// s+=i+" ";
			sb.append(i).append(' ');
		}
		System.out.println(sb);
		System.out.printf("Result is : %s", sb);

	}
}
