package net.azib.java.students.t103784;

import net.azib.java.lessons.collections.DuplicateRemover;
import net.azib.java.students.t103784.DupRemImpl;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 6.04.11
 * Time: 23:38
 * To change this template use File | Settings | File Templates.
 */
public class DupRemImplTest {
	@Test
	public void testRemoveDuplicateStrings() throws Exception {
		int x = 3;
		String[] stringArray = {"asi","asi","aparaat","riist"};
		DupRemImpl dupRem = new DupRemImpl();

		String[] strings = dupRem.removeDuplicateStrings(stringArray);
		String[] noDuplicate = {"asi","aparaat","riist"};


		for (int i = 0; i<x; i++){
			assertArrayEquals(strings,noDuplicate);
			System.out.println("Test success for: " + strings[i]);
		}
	}
}
