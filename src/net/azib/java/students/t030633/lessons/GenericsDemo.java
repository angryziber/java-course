package net.azib.java.students.t030633.lessons;

import java.util.List;
import java.util.ArrayList;

/**
 * GenericsDemo
 * 
 * @author t030633
 */
public class GenericsDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		// no generics at runtime!
		// List<String> listOfString = (List)list;
		
		
		list.add(5);
		int s = list.get(0);
		
		// CastCastException
		// even though we do not explicitly cast anything
		// String string = listOfString.get(0);
		
		System.out.println(s);

	}

}
