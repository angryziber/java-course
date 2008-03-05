package net.azib.java.students.t001370.lectures.lec4;


import java.util.ArrayList;
import java.util.List;

/**
 * GenericsDemo
 *
 * @author maksim
 */
public class GenericsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//List<String> listOfStrings = (List)list;
		
		list.add(5);
		//String s = listOfStrings.get(0);
		//Integer in = list.get(0);
	}

}
