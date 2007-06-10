package net.azib.java.students.t060397.homework;

/***************************************************************************
 *   Copyright (C) 2007 by Margus Ernits   *
 *   Margus.Ernits@itcollege.ee   *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * SumoCode class contains computer driven code
 *
 * @author marcus
 */
public class BotRobot extends RobotBehaviour implements Runnable {

	Thread botCode;

	BotRobot() {
		botCode = new Thread(this);
		botCode.start();
	}

	public void run() {

		while (Thread.currentThread() == botCode) {
			try {
				/* GENERATED CODE by web interface*/
				backward();
				ms_sleep(1000);
				
				left();
				ms_sleep(1000);

				forward();
				ms_sleep(1000);

				/* GENERATED CODE by web interface*/

				Thread.sleep(SumoApp.getDelay());
			}
			catch (InterruptedException e) {

			}
		}
	}

	/**
	 * paints robot on the dohjo according to coordinates and angle.
	 * paints motor and sensor states
	 * @param g applet graphics
	 */
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		RenderRobot.drawRobot(g2d, data.getX(), data.getY(), Color.LIGHT_GRAY, data.getAngle());

	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t060397.homework.Robot#ms_sleep(int)
	 */
	@Override
	public void ms_sleep(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
