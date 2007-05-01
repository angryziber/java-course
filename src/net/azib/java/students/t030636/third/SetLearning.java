package net.azib.java.students.t030636.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SetLearning {

	public static void main(String[] args) {
//		Set set = new HashSet();
//		Set set = new LinkedHashSet();
		List<Object> c = new ArrayList<Object>(Arrays.asList(new String[] {"a", "b", "z", "x", "z"}));
		c.add("a");
//		c.add("b");
//		c.add("z");
//		c.add("x");
//		c.add("z");
		System.out.println(c.lastIndexOf("z"));
		
		
		for (Object e : c) {
			System.out.println(e);
		}

	}

}
