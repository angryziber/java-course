package net.azib.java.students.t010687;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * SetLearning
 *
 * @author t010687
 */
public class SetLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		set.add("a");
		set.add("b");
		set.add("z");
		set.add("x");
		set.add("z");
		
		for (Object e : set) {
			System.out.println(e);
		}
	}

}
