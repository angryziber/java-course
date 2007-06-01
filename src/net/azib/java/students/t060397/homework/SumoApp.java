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
import java.io.IOException;
import java.net.URL;

public class SumoApp extends Applet implements Runnable {

	private static final long serialVersionUID = 4458887497742408563L;
	//private static final String RESOURCE_FILE = "resource.properties";
	
	/** Image URL from html */
	private static final String IMG_URL = "imgurl";
	
	static int frame;

	public static int DELAY;

	Thread animator;

	private static final int with = 640;

	private static final int height = 640;

	Dimension offScreenDim;

	Image offScreenImage;

	Image imgMyRobot;

	Image imgYouRobot;

	Graphics offScreenGraphics;

	private URL imageSrc;

	Dohjo board;

	public void start() {
		animator = new Thread(this);
		animator.start();
	}

	private void getResources() throws IOException {
		
		/** Getting class file location 
		final String clsAsResource = this.getName ().replace ('.', '/').concat (".class");
		final String pd = getClass().getProtectionDomain().getCodeSource().toString();
	//	final CodeSource cs = pd.getCodeSource ();
		System.out.println("UUU :"+pd);
		
		java.util.Properties props = new java.util.Properties();
		//String path = getClass().
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
		System.out.println("Path :"+path);
		java.io.FileInputStream fis = new java.io.FileInputStream(new java.io.File(path + File.separator + RESOURCE_FILE));
		props.load(fis);
		java.net.URL url = ClassLoader.getSystemResource(RESOURCE_FILE);
		if (url != null) {
			props.load(url.openStream());
			System.out.println(props);
		}
		else {
			throw new IOException("Can't open resurce file: " + RESOURCE_FILE);
		}
		*/
		/** Print properties */
		/*
		Properties sysprops = System.getProperties();
		Collection c = sysprops.keySet();	
		
		for (Object key : c) {
			System.out.println("Key "+key +" Value "+ sysprops.get(key));
		}*/
		
	}
	public void init() {
		
		imageSrc = getCodeBase();
		String imageSrcUrl = getParameter(IMG_URL);
		
		try{
			getResources();
	      
	     
		//SumoApp.getResourceAsStream("resource.properties");
		}catch (IOException e){
			
			e.printStackTrace();
		}
		System.out.println("Codebase: "+ imageSrc);
		setDelay();
		setSize(with, height);
		setBackground(Color.green);
		board = new Dohjo();
		board.init(with, height);
		//imgMyRobot = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("websumobot.png"));
		imgMyRobot = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("java-logo.gif"));
		//imgMyRobot = getImage(imageSrc,"net/azib/java/students/t060397/homework/images/websumobot.png");
		imgYouRobot = getImage(imageSrc, "images/bot2.png");
		board.setImages(imgMyRobot, imgYouRobot);

	}

	public void setDelay() {
		String str = getParameter("fps");
		int fps = (str != null) ? Integer.parseInt(str) : 50;
		SumoApp.DELAY = (fps > 0) ? (1000 / fps) : 100;
	}

	/**
	 * @param args
	 */
	public void paint(Graphics g) {
		if (offScreenImage != null) {
			g.drawImage(offScreenImage, 0, 0, null);
		}

	}

	public void paintFrame(Graphics g) {

		board.setFrame(frame);
		board.paint(g);

	}

	public static void main(String[] args) {
		// TODO Implement non applet instance too (not in this release)

	}

	public void run() {

		long tm = System.currentTimeMillis();
		while (Thread.currentThread() == animator) {
			repaint();
			try {
				tm += SumoApp.DELAY;
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

}
