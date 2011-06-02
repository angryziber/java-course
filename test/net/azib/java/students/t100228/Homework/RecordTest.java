package net.azib.java.students.t100228.Homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test for the {@link Record} class
 * @author Martin
 */
public class RecordTest {
	/**
	 * Test for the method {@link Record#compareTo(Record)}
	 */
	@Test
	public void compareTo(){
		Record rec1 = new Record();
		rec1.setScore(3000);

		Record rec2 = new Record();
		rec2.setScore(4000);

		assertEquals(1, rec1.compareTo(rec2));
		assertEquals(-1, rec2.compareTo(rec1));
		assertEquals(0, rec1.compareTo(rec1));
	}
}
