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
	DohjoData data;
	DohjoBehaviour dohjo;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bot = new BotRobot();
		data = new DohjoData();
		dohjo = new DohjoBehaviour();
		dohjo.init(640, 640);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bot = null;
		data = null;
		dohjo = null;
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
