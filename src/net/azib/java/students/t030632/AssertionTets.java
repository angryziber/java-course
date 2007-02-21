package net.azib.java.students.t030632;

/**
 * AssertionTets
 *
 * @author Toni
 */
public class AssertionTets {

	/**
	 * @param args
	 */
	public static void main(String ... args) {
		assert args.length > 0 : "Not Enough Command Line parameters given";
		for(String s: args)
			System.out.println("Parameter: "+ s);
		int i=23000;
		System.out.printf("%d", i);

	}

}
