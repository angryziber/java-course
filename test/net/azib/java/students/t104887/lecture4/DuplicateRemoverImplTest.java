package net.azib.java.students.t104887.lecture4;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 3.04.11
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class DuplicateRemoverImplTest {
	@Test
	public void testRemoveDuplicateStrings() {
		DuplicateRemoverImpl collection = new DuplicateRemoverImpl();
		assertArrayEquals(new String[]{"one", "two", "three"}, collection.removeDuplicateStrings(new String[]{"one", "one", "one", "two", "two", "three"}));

	}
}
