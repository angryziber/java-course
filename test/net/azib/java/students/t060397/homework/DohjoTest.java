package net.azib.java.students.t060397.homework;

import junit.framework.TestCase;

/**
 * DohjoTest
 *
 * @author Margus Ernits
 */
public class DohjoTest extends TestCase {
	
	

	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.Dohjo#offDohjo(int, int)}.
	 */
	public void testOffDohjo() {
		Dohjo board = new Dohjo();
		board.init(640, 640);
		
		/* out of area */
		assertTrue(Dohjo.offDohjo(0, 0));
		assertTrue(Dohjo.offDohjo(-10, 1000));
		assertTrue(Dohjo.offDohjo(40, 1000));
		/* inside dohjo */
		assertFalse(Dohjo.offDohjo(260, 260));
		board = null;
	}
	

}
