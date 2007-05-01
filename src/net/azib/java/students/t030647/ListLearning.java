package net.azib.java.students.t030647;

import java.util.Arrays;
import java.util.Collection;

/**
 * ListLearning
 *
 * @author t030647
 */
public class ListLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Collection set = new ArrayList();
		Collection set = Arrays.asList(new String[] {"a", "b", "z", "x", "z"});
		
		for (Object s : set) {
			System.out.println(s);
		}
	}

}
