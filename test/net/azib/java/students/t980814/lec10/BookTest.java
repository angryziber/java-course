package net.azib.java.students.t980814.lec10;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;


/**
 * BookTest
 *
 * @author dell
 */
public class BookTest {

	@Test
	public void testBookString() {
		final String LN = System.getProperty("line.separator");
		LinkedList<String> authors = new LinkedList<String>();
		authors.add("Erich Gamma");
		authors.add("Richard Helm");
		authors.add("Ralph Johnson");
		authors.add("John Vissides");
		
		Book book = new Book("Design Patterns: Elements of Reusable Object-Oriented Software",
							 "COMPUTERS", "en",
				             authors,
				             1994, 59.99);
		assertEquals("Category: COMPUTERS / en" + LN +
					 "Design Patterns: Elements of Reusable Object-Oriented Software [1994] - $59.99" + LN +
					 "[Erich Gamma, Richard Helm, Ralph Johnson, John Vissides]",
					 book.toString());
	}

}
