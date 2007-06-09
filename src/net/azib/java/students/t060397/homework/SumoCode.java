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
 * SumoCode class contains first robot behaiviour and runs generated code
 *
 * @author marcus
 */
public class SumoCode extends Robot implements Runnable {

	Thread sumoCode;

	SumoCode() {
		sumoCode = new Thread(this);
		sumoCode.start();
	}

	public void run() {

		while (Thread.currentThread() == sumoCode) {
			try {
				/* GENERATED CODE by web interface*/
				//left();
				
				forward();
				//ms_sleep(19);
				//backward();
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
		/*AffineTransform origXform = g2d.getTransform();
		AffineTransform newXform = (AffineTransform) (origXform.clone());
		int xRot = img.getWidth(null)/2;
		int yRot = img.getHeight(null)/2;
		
		newXform.rotate(Math.toRadians(UserState.angle), xRot, yRot);
		g2d.setTransform(newXform);
		g2d.drawImage(img, UserState.x, UserState.y, null);
		g2d.setTransform(origXform);*/
		
		RenderRobot.drawRobot(g2d, UserState.x, UserState.y, Color.LIGHT_GRAY, UserState.angle);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Andurid ja mootorid", 1, 600);
		g2d.drawString("all_vasak", 1, 610);
		g2d.drawString("all_keskmine", 1, 620);
		g2d.drawString("all_parem", 1, 630);
		g2d.drawString("vastane_vasak", 150, 610);
		g2d.drawString("vastane_parem", 150, 620);
		g2d.drawString("vasak mootor", 250, 610);
		g2d.drawString("parem mootor", 250, 620);
	}

	

	/* (non-Javadoc)
	 * @see net.azib.java.students.t060397.homework.Robot#ms_sleep(int)
	 */
	@Override
	public void ms_sleep(int ms) {

		while (Thread.currentThread() == sumoCode) {
			try {
				Thread.sleep(ms);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}

		}
	}

}
