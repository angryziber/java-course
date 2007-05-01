package net.azib.java.students.t030721;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * SetLearning
 *
 * @author t030721
 */
public class CollectionLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	List<String> c = new ArrayList(Arrays.asList(new String[] {"a","b","z","x","z"}));
	c.add("m");	
	
	System.out.println(c.indexOf("z"));
		/*	List c = new LinkedList();
		c.add("a");
		c.add("b");
		c.add("z");
		c.add("x");
		c.add("z");
	*/	
		for (Object e : c){
			System.out.println(e);
		}
		
	}

}
