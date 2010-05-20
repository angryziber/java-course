package net.azib.java.students.t073862.homework;

import net.azib.java.students.t073862.homework.model.Score;

import junit.framework.Assert;

import org.junit.Test;

/**
 * TestScore
 *
 * @author Pets
 */
public class TestScore {

	@Test
	public void testScoreModel() {
		Score s = new Score("Peeter Tomberg", "18.06.1988", "ee", 10);
		Assert.assertEquals("Name getter returning the right result?" ,"Peeter Tomberg", s.getName());
		Assert.assertEquals("Dob getter returning the right result?" ,"18.06.1988", s.getDob());
		Assert.assertEquals("Iso getter returning the right result?" ,"ee", s.getIso());	
		Assert.assertEquals("toString returning the right result?" ,"Peeter Tomberg (18.06.1988) from ee scored: 10", s.toString());	
		
	}
}
