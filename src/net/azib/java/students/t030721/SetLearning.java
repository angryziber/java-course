package net.azib.java.students.t030721;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * SetLearning
 *
 * @author t030721
 */
public class SetLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("z");
		set.add("x");
		set.add("z");
		
		for (Object e : set){
			System.out.println(e);
		}
		
	}

}
