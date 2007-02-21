package net.azib.java.students.t020632;

import java.util.Set;
import java.util.HashSet;

/**
 * SetLearning
 *
 * @author t020632
 */
public class SetLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		
		for(Object o : set){
			System.out.println(o);
		}
		

	}

}
