package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DecathlonResultsTest
 *
 * @author maksim
 */
public class DecathlonResultsTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getTotalScore()}.
	 */
	@Test
	public void testGetTotalScore() {
		DecathlonResults dr = new DecathlonResults();

		dr.setResult100mRace((float)12.61);
		dr.setResult110mHurdles((float)16.43);
		dr.setResult1500mRace((float)325.72);
		dr.setResult400mSprint((float)59.39);
		dr.setResultDiscusThrow((float)21.60);
		dr.setResultHighJump((float)1.50);
		dr.setResultJavelinThrow((float)35.81);
		dr.setResultLongJump((float)5.00);
		dr.setResultPoleVault((float)2.60);
		dr.setResultShotPut((float)9.22);
		
		assertEquals((int)4234, dr.getTotalScore());

	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResult100mRace()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResult100mRace(float)}.
	 */
	@Test
	public void testGetSetResult100mRace() {

		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResult100mRace(value);
		assertEquals(value, dr.getResult100mRace());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResultLongJump()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResultLongJump(float)}.
	 */
	@Test
	public void testGetSelResultLongJump() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResultLongJump(value);
		assertEquals(value, dr.getResultLongJump());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResultShotPut()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResultShotPut(float)}.
	 */
	@Test
	public void testGetSetResultShotPut() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResultShotPut(value);
		assertEquals(value, dr.getResultShotPut());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResultHighJump()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResultHighJump(float)}.
	 */
	@Test
	public void testGetSetResultHighJump() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResultHighJump(value);
		assertEquals(value, dr.getResultHighJump());
	}


	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResult400mSprint()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResult400mSprint(float)}.
	 */
	@Test
	public void testGetSetResult400mSprint() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResult400mSprint(value);
		assertEquals(value, dr.getResult400mSprint());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResult110mHurdles()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResult110mHurdles(float)}.
	 */
	@Test
	public void testGetSetResult110mHurdles() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResult110mHurdles(value);
		assertEquals(value, dr.getResult110mHurdles());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResultDiscusThrow()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResultDiscusThrow(float)}.
	 */
	@Test
	public void testGetSetResultDiscusThrow() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResultDiscusThrow(value);
		assertEquals(value, dr.getResultDiscusThrow());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResultPoleVault()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResultPoleVault(float)}.
	 */
	@Test
	public void testGetSetResultPoleVault() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResultPoleVault(value);
		assertEquals(value, dr.getResultPoleVault());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResultJavelinThrow()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResultJavelinThrow(float)}.
	 */
	@Test
	public void testGetSetResultJavelinThrow() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResultJavelinThrow(value);
		assertEquals(value, dr.getResultJavelinThrow());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#getResult1500mRace()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonResults#setResult1500mRace(float)}.
	 */
	@Test
	public void testGetSetResult1500mRace() {
		float value = (float)1.1;
		DecathlonResults dr = new DecathlonResults();
		dr.setResult1500mRace(value);
		assertEquals(value, dr.getResult1500mRace());
	}

}
