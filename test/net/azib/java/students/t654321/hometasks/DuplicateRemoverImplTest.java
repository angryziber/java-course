package net.azib.java.students.t654321.hometasks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DuplicateRemoverImplTest
 *
 * @author Karl
 */
public class DuplicateRemoverImplTest {

	private String[] unsortedStringArray = {"kuku","kiki","kuku","koer","kass","koer","murka"};
	private String[] sortedStringArray = {"kuku","kiki","koer","kass","murka"};
	private DuplicateRemoverImpl dri = new DuplicateRemoverImpl();

	
	// Tests that method removeDuplicateStrings removes all duplicate strings from string array 
	@Test
	public void removeDuplicateStringsTest () {
		assertArrayEquals("Arrays are not equal", sortedStringArray, dri.removeDuplicateStrings(unsortedStringArray));
	}
}
