package net.azib.java.students.t001370.lectures.lec3.home;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DubllicateRemoverTest
 *
 * @author maksim
 */
public class DubllicateRemoverTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec3.home.DuplicateRemoverImpl#removeDuplicateStrings(java.lang.String[])}.
	 */
	@Test
	public void testRemoveDuplicateStrings() {
		String[] strArray = new String[]{"bla", "alb"};
		DuplicateRemoverImpl dri = new DuplicateRemoverImpl();
		assertArrayEquals("!!!DuplicateRemover.removeDuplicateStings has an error!!!",
				strArray, dri.removeDuplicateStrings(strArray));
	}

}
