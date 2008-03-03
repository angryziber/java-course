package net.azib.java.students.t040750.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericsDemo
 *
 * @author t040750
 */
public class GenericsDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
				
		list.add(5);
		int s = list.get(0);
		System.out.println(s);
/*		
		List<String> listOfString = (List)list;

		String str = listOfString.get(0); 	//ClassCastException, kuna (List)
		System.out.println(str);			//list ees muudab selle vea kompilaatorile nähtamatuks
		
*/
	}
}
