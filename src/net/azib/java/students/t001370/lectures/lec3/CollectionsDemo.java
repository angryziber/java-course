package net.azib.java.students.t001370.lectures.lec3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;



/**
 * CollectionsDemo
 *
 * @author t001370
 */
public class CollectionsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Collection c = new ArrayList();
		//Collection c = new LinkedList();
		//Collection c = new HashSet();
		//Collection c = new TreeSet();
		//Collection c = new LinkedHashSet();
		List c = new ArrayList();
		
		c.add("abc");
		c.add("123");
		c.add("456");
		c.add("789");
		c.add("000");
		c.add(1, "zzz");

		System.out.println(c.size());
		
		/*1.5 puhul*/
		for (Object object : c) {
			System.out.println(object);
		}
		/*1.4 puhul*/
		/*for (Iterator i = c.iterator(); i.hasNext(); ){
			Object o = i.next();
			System.out.println(o);
		}*/
	}

}
