package net.azib.java.students.t060397.homework;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * BotRobotTest
 *
 * @author Margus Ernits
 */
public class BotRobotTest {
	BotRobot bot;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bot = new BotRobot();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bot = null;
	}






	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.RobotBehaviour#turn()}.
	 */
	@Test
	public final void testTurn() {
		bot.data.setLmotor(RobotData.motorState.FORWARD);
		bot.data.setRmotor(RobotData.motorState.FORWARD);
		
		bot.data.setAngle(180);
		int xold = bot.data.getX();
		int yold = bot.data.getY();
		
		bot.turn();
		assertEquals(xold--,bot.data.getX());
		assertEquals(yold,bot.data.getY());
	}

}
