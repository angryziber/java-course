package net.azib.java.students.t030604.homework.parser;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataParser;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * DbParserTest 
 * 
 * 
 * <b>NB!</b> for the correct testing dbunit is required
 *
 * @author Aleksandr Ivanov
 */
public class DbParserTest {

	@Test
	public void testSetup() throws ParserException {
		IDataParser tested = new DbParser();
		//pray that the record with this ID exists
		tested.setup("1");
	}
	
//	@Test(expected=ParserException.class)
	public void testSetupInvalid() throws ParserException {
		IDataParser tested = new DbParser();
		//pray that the record with this ID does not exist
		tested.setup(System.currentTimeMillis()+"");
	}
	
	@Test
	public void testParseDataValid() throws ParserException {
		IDataParser tested = new DbParser();
		tested.setup("1");
		List<AthleteScore> list = tested.parseData();
		//I have absolutely no idea what's inside
		Assert.assertTrue(list != null && list.size() > 0);
	}
}
