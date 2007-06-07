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
import java.awt.Image;

/**
 * 
 * Dohjo - Japan minisumo board
 * @author Margus Ernits<p>
 * See <a href="http://www.robotroom.com/SumoRules.html">content rules</a>
 * 
 * <p>
 * <img src="http://robot.itcollege.ee:800/~robot/sumo/pic/SumoApp.png" alt="SumoRobot picture">
 * 
 *  
 */
public class Dohjo {

	/**
	 * Some free space for printing status of sensors/motors
	 * 
	 */
	private static final int FREEAREA = 60;
	/**
	 * Japan minisumo board diameter = 77cm
	 */
	private static final int DOHJODIAM = 77;

	private static final int BORDER = 30;
	/**
	 * Bright border size 
	 */
	private static final int WHITEAREA = 2;

	/**
	 * Robot default width [px]
	 */
	private static final int ROBOTWIDTH = 100;
	/**
	 * Robot default heigth [px]
	 */
	private static final int ROBOTHEIGTH = 108;
	/**
	 * Brown start line distance from dohjo centre
	 */
	private static final int STARTLINE = 10;
	/**
	 * Dohjo scale factor
	 */
	private static double dojoScale;
	/**
	 * Dohjo centre point X coordinate [px]
	 */
	private static int dohjoCentreX;
	/**
	 * Dohjo centre point Y coordinate [px]
	 */
	private static int dohjoCentreY;

	private int frame;

	Match sumoMatch = new Match();

	void setFrame(int frameno) {
		frame = frameno;
	}

	/**
	 * Inits Dohjo, sets up sumomatch, places robots to board
	 * @param w area width
	 * @param h area heigth
	 */
	public void init(int w, int h) {
		sumoMatch.init();
		dojoScale = (w - FREEAREA) / (double) DOHJODIAM;
		dohjoCentreX = BORDER + (int) (DOHJODIAM * dojoScale / 2.0);
		dohjoCentreY = BORDER + (int) (DOHJODIAM * dojoScale / 2.0);
		UserState.x = BORDER + (int) (DOHJODIAM * dojoScale / 2.0) - (int) (ROBOTWIDTH / 2);
		UserState.y = BORDER + (int) (DOHJODIAM * dojoScale / 2.0) - (int) (ROBOTHEIGTH / 2) - (int) (STARTLINE * dojoScale);
		UserState.xk = BORDER + (int) (DOHJODIAM * dojoScale / 2.0) - (int) (ROBOTWIDTH / 2);
		UserState.yk = BORDER + (int) (DOHJODIAM * dojoScale / 2.0) - (int) (ROBOTHEIGTH / 2) + (int) (STARTLINE * dojoScale);
	}
	/**
	 * Paints Dohjo
	 * @param g  applet graphics
	 */
	public void paint(Graphics g) {

		g.drawString("Sumorobotite rammukatsumine " + frame, 10, 10);
		g.setColor(Color.white);
		g.fillArc(BORDER, BORDER, (int) (DOHJODIAM * dojoScale), (int) (DOHJODIAM * dojoScale), 0, 360);
		g.setColor(Color.black);
		g.fillArc((int) (BORDER + WHITEAREA * dojoScale), (int) (BORDER + WHITEAREA * dojoScale),
				(int) (DOHJODIAM * dojoScale - WHITEAREA * WHITEAREA * dojoScale), (int) (DOHJODIAM * dojoScale - WHITEAREA
						* WHITEAREA * dojoScale), 0, 360);
		sumoMatch.paint(g);

	}
	/**
	 * Sets Robot pictures
	 * @param imgMyRobot SumoApp robot
	 * @param imgYouRobot User robot - uses generated code from SumoLanguage
	 */

	public void setImages(Image imgMyRobot, Image imgYouRobot) {
		sumoMatch.setImages(imgMyRobot, imgYouRobot);

	}
	/**
	 * Checks robot location.
	 * @param x robots x coordinate
	 * @param y robots y coordinate
	 * @return true if robot is outside dohjo
	 */
	public static boolean offDohjo(int x, int y) {

		double distance;
		distance = Math.sqrt((dohjoCentreX - x) * (dohjoCentreX - x) + (dohjoCentreY - y) * (dohjoCentreY - y));
		
		/* distance from centre + robot*/
		if (distance + ROBOTWIDTH / 2 > (DOHJODIAM * dojoScale / 2.0)) {
			return true;
		}
		return false;
	}

}
