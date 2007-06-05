package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.GenericDecathlonEvent;
import net.azib.java.students.t030726.homework.decathlon.InvalidDataFormatException;
import junit.framework.TestCase;

public class GenericDecathlonEventTest extends TestCase {
	private GenericDecathlonEvent fixture = null;

	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new GenericDecathlonEvent();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	public void testSetAParamater() {
		try {
			this.fixture.setAParameter(1.234);
		} catch (InvalidDataFormatException ex){
			fail("When saving a normal A parameter it should not fail");
		}
		return;
	}
	
	public void testSetAWithInvalidInput() {
		try {
			this.fixture.setAParameter(0);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("0 parameter A should have thrown an exception");
	}
	
	public void testSetAParamaterWithNegativeInput() {
		try {
			this.fixture.setAParameter(-2.159);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("negative parameter A should have thrown an exception");
	}

	public void testSetBParameter() {
		try {
			this.fixture.setBParameter(1.234);
		} catch (InvalidDataFormatException ex){
			fail("When saving a normal B parameter it should not fail");
		}
		return;
	}

	public void testSetBWithInvalidInput() {
		try {
			this.fixture.setBParameter(0);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("0 parameter B should have thrown an exception");
	}
	
	public void testSetBParamaterWithNegativeInput() {
		try {
			this.fixture.setBParameter(-2.159);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("negative parameter B should have thrown an exception");
	}
	
	public void testSetCParameter() {
		try {
			this.fixture.setCParameter(1.234);
		} catch (InvalidDataFormatException ex){
			fail("When saving a normal C parameter it should not fail");
		}
		return;
	}

	public void testSetCWithInvalidInput() {
		try {
			this.fixture.setCParameter(0);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("0 parameter C should have thrown an exception");
	}
	
	public void testSetCParamaterWithNegativeInput() {
		try {
			this.fixture.setCParameter(-2.159);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("negative parameter C should have thrown an exception");
	}

	public void testBlankGetAParameter() {
		try {
			this.fixture.getAParameter();
		} catch (NullPointerException ex) {
			return;
		}
		fail("Undefined A parameter should throw an exception on read");
	}
	
	public void testGetAParameter() {
		double expectedResult = 2.158;
		double gotResult = 0.0;
		try {
			this.fixture.setAParameter(expectedResult);
		} catch (InvalidDataFormatException e) {
			fail("Saving proper parameters to A should not produce errors");
		}
		try {
			gotResult = this.fixture.getAParameter();
		} catch (Exception ex) {
			fail("Reading proper results from A parameter should not produce errors");
		}
		assertEquals(expectedResult, gotResult, 0);
	}

	public void testBlankGetBParameter() {
		try {
			this.fixture.getBParameter();
		} catch (NullPointerException ex) {
			return;
		}
		fail("Undefined B parameter should throw an exception on read");
	}
	
	public void testGetBParameter() {
		double expectedResult = 2.158;
		double gotResult = 0.0;
		try {
			this.fixture.setBParameter(expectedResult);
		} catch (InvalidDataFormatException e) {
			fail("Saving proper parameters to B should not produce errors");
		}
		try {
			gotResult = this.fixture.getBParameter();
		} catch (Exception ex) {
			fail("Reading proper results from B parameter should not produce errors");
		}
		assertEquals(expectedResult, gotResult, 0);
	}
	
	public void testBlankGetCParameter() {
		try {
			this.fixture.getCParameter();
		} catch (NullPointerException ex) {
			return;
		}
		fail("Undefined C parameter should throw an exception on read");
	}
	
	public void testGetCParameter() {
		double expectedResult = 2.158;
		double gotResult = 0.0;
		try {
			this.fixture.setCParameter(expectedResult);
		} catch (InvalidDataFormatException e) {
			fail("Saving proper parameters to C should not produce errors");
		}
		try {
			gotResult = this.fixture.getCParameter();
		} catch (Exception ex) {
			fail("Reading proper results from C parameter should not produce errors");
		}
		assertEquals(expectedResult, gotResult, 0);
	}

}
