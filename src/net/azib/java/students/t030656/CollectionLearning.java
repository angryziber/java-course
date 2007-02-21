package net.azib.java.students.t030656;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * SetLearning
 *
 * @author t030656
 */
public class CollectionLearning {
	public static void main(String[] args){
		List c = new ArrayList(Arrays.asList(new String[] {"a", "b", "z", "x", "z"}));
		
		c.add("m");
		
		System.out.println(c.lastIndexOf("z"));
		for(Object e: c){
			System.out.println(e);
		}
		
	}
}
