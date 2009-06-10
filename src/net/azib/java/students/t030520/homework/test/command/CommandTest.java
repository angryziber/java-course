package net.azib.java.students.t030520.homework.test.command;

import net.azib.java.students.t030520.homework.command.Command;

import junit.framework.Assert;

import org.junit.Test;

/**
 * The test class for testing functionality of the Command.
 *
 * @author t030520
 */
public class CommandTest {

	@Test
	public void testMatchActionWithWrongData() {
		Assert.assertEquals(false, Command.CSV.matches("somefile.txt"));
		Assert.assertEquals(false, Command.DB.matches("_some_invalid_name"));
		Assert.assertEquals(false, Command.DB.matches("2.3"));
		Assert.assertEquals(false, Command.HTML.matches("somefile.txt"));
		Assert.assertEquals(false, Command.XML.matches("somefile.txt"));
	}

	@Test
	public void testMatchActionWithRightData() {
		Assert.assertEquals(true, Command.CSV.matches("somefile.csv"));
		Assert.assertEquals(true, Command.CSV.matches("dir/somefile.csv"));
		Assert.assertEquals(true, Command.DB.matches("Competition"));
		Assert.assertEquals(true, Command.DB.matches("2"));
		Assert.assertEquals(true, Command.HTML.matches("somefile.html"));
		Assert.assertEquals(true, Command.HTML.matches("dir/somefile.html"));
		Assert.assertEquals(true, Command.XML.matches("somefile.xml"));
		Assert.assertEquals(true, Command.XML.matches("dir/somefile.xml"));
	}
}
