package net.azib.java.students.t030633.lessons;

// import java.util.regex.Pattern;

/**
 * RegexpDemo
 * 
 * @author t030633
 */
public class RegexpDemo {
	public static void main(String[] args) {
		String sDog = "Dog";
		String sCat = "Cat2";
		System.out.println(sDog.matches("...")); // true
		System.out.println(sCat.matches("D..")); // false
		System.out.println(sDog.matches("[DC]o[gt]")); // true
		// Pattern p;
		System.out.println(sCat.replaceAll("(Dog|Cat)(\\d+)", "ANIMAL$2"));
	}

}
