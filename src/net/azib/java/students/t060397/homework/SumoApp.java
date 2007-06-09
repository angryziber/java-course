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
package net.azib.java.students.t060397.homework;

import java.applet.*;
import java.awt.*;

/**
 * @author Margus Ernits<p>
 * The SumoApp class is contains main applet for Sumorobot application.
 * This class contains graphical part and creation of board - no application logic.
 * You will find newer version of Sumo language and training applet from
 * <a href="http://robot.itcollege.ee:800/~robot/sumo/">SumoRobot programming</a>.<p>
 * Sumo Language used by children for learning proposes.<p> Currently all built-in
 * functions in Sumo language are in Estonian. I plan to develop English version too
 * See release.txt 
 */
public class SumoApp extends Applet implements Runnable {

	private static final long serialVersionUID = 4458887497742408563L;
	

	/**
	 * Sumomatch frame no. It can be used for syncronization of match.
	 */
	private static int frame;

	/**
	 * Delay between frames
	 */
	private static int delay;

	private Thread animator;

	private static int width;

	private static int height;

	private Dimension offScreenDim;

	private Image offScreenImage;

	private Graphics offScreenGraphics;

	/**
	 * Sumoboard for match
	 */
	protected DohjoBehaviour board;
	
	protected RenderDohjo render;
	
	private Match sumoMatch = new Match();
	

	public void start() {
		animator = new Thread(this);
		animator.start();
	}


/**
 * init() creates Dohjo object and sets Robot pictures
 */
	public void init() {

		setDelay();
		setWidth();
		setHeight();
		setSize(width, height);
		setBackground(Color.green);
		board = new DohjoBehaviour();
		board.init(width, height);
	    render = new RenderDohjo();
		sumoMatch.init();
	}

	private void setWidth() {
		String str = getParameter("WIDTH");
		int with = (str != null) ? Integer.parseInt(str) : 640;
		SumoApp.width = (with > 640) ? with : 640;
	}

	private void setHeight() {
		String str = getParameter("HEIGHT");
		int height = (str != null) ? Integer.parseInt(str) : 640;
		SumoApp.height = (height > 640) ? height : 640;
		;
	}

	private void setDelay() {
		String str = getParameter("FPS");
		int fps = (str != null) ? Integer.parseInt(str) : 50;
		SumoApp.delay = (fps > 0) ? (1000 / fps) : 100;
	}

	public void paint(Graphics g) {
		if (offScreenImage != null) {
			g.drawImage(offScreenImage, 0, 0, null);
		}

	}

	public void paintFrame(Graphics g) {

		render.paint(g);
		sumoMatch.paint(g);

	}

	public static void main(String[] args) {
		// TODO Implement non applet instance too (see release.txt)

	}

	public void run() {

		long tm = System.currentTimeMillis();
		while (Thread.currentThread() == animator) {
			repaint();
			try {
				tm += SumoApp.delay;
				Thread.sleep(Math.max(0, tm - System.currentTimeMillis()));
			}
			catch (InterruptedException e) {
				break;
			}
			frame++;
		}
	}

	/**
	 * Update current frame
	 */
	public void update(Graphics g) {
		Dimension d = getSize();

		if ((offScreenGraphics == null) || (d.width != offScreenDim.width) || (d.height != offScreenDim.height)) {
			offScreenDim = d;
			offScreenImage = createImage(d.width, d.height);
			offScreenGraphics = offScreenImage.getGraphics();
		}

		offScreenGraphics.setColor(getBackground());
		offScreenGraphics.fillRect(0, 0, d.width, d.height);
		offScreenGraphics.setColor(Color.black);

		paintFrame(offScreenGraphics);

		g.drawImage(offScreenImage, 0, 0, null);
	}

	/**
	 * Exit this thread before drawing next frame.
	 */
	public void stop() {
		animator = null;
		offScreenImage = null;
		offScreenGraphics = null;
	}

	/**
	 * Returns frame number
	 * @return the frame
	 */
	public static synchronized int getFrame() {
		return frame;
	}

	/**
	 * Returns applet delay between frames
	 * @return the delay
	 */
	public static int getDelay() {
		return delay;
	}

	/**
	 * Returns applet heigth
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Returns applet width
	 * @return the witdh
	 */
	public int getWidth() {
		return width;
	}

}
