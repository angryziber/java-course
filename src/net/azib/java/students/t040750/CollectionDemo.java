package net.azib.java.students.t040750;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * CollectionDemo
 *
 * @author t040750
 */
public class CollectionDemo {
	public static void main(String[] args) {
		List c = new ArrayList();
		//Collection c = new HashSet();
		//Collection c = new LinkedHashSet();
		
		c.add("abc");
		c.add("123");
		c.add("765");
		c.add("000");
		c.add("765"); 	//LinkedHashSet: kuna see on võrdne juba olemasoleva elemendiga,
						//siis asendatakse vana objekt uuega (st sama väärtusega	)
		
		c.add(1, "zzzzz");
		
		//System.out.println(c.size());
		
		for(Object o : c)
			System.out.println(o);
	}
}
