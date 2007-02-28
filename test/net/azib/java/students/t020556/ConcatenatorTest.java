package net.azib.java.students.t020556;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * ConcatenatorTest
 *
 * @author t020556
 */
public class ConcatenatorTest {
	Concatenator conc;
	@Before
	public void setUp(){
		conc = new Concatenator();
	}
	/**
	 * @param args
	 */
	@Test
	public void testConcGood() {
		Assert.assertEquals("abc123", conc.concatenate("abc", "123"));
	}
	
	@Test
	public void testConcNull() throws Exception {
		Assert.assertEquals("abc", conc.concatenate("abc", null));
		Assert.assertEquals("123", conc.concatenate(null, "123"));
		Assert.assertEquals("", conc.concatenate(null, null));
		
	}

}
