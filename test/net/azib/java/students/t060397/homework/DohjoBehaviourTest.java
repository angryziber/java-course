package net.azib.java.students.t060397.homework;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DohjoBehaviourTest
 *
 * @author marcus
 */
public class DohjoBehaviourTest {
	DohjoData data;
	DohjoBehaviour dohjo;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		data = new DohjoData();
		dohjo = new DohjoBehaviour();
		dohjo.init(640, 640);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		data = null;
		dohjo = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.DohjoBehaviour#offDohjo(int, int)}.
	 */
	@Test
	public final void testOffDohjo() {
		assertTrue(DohjoBehaviour.offDohjo(462, 0));
		assertFalse(DohjoBehaviour.offDohjo(300, 300));
	}
	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.DohjoBehaviour#init(int, int)}.
	 */
	@Test
	public final void testInit() {
		assertEquals(DohjoData.getDohjoCentreX(), 299);
		assertEquals(DohjoData.getDohjoCentreY(), DohjoData.getDohjoCentreX());
	}



}
