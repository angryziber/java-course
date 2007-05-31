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



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class SumoCode extends Robot implements Runnable {
	

	Thread sumoCode;

	SumoCode() {
		sumoCode = new Thread(this);
		sumoCode.start();
	}
	
	public void run() {

		while (Thread.currentThread() == sumoCode) {			
			try {
				/** Test Code */
				
				edasi();
				//tagasi();
				//viivitus(2);
				//vasakule();
				//viivitus(1);
				//tagasi();
				//viivitus(100);
				Thread.sleep(SumoApp.DELAY);
			} catch (InterruptedException e) {

			}
		}
	}



	
	

	public int getVal(String sensorName) {
		return 0;
	}

	public void tick() {
	}

	public void viivitus(int ms) {
		/*
		 * while (Thread.currentThread() == sumoCode) { try { Thread.sleep(ms); }
		 * catch (InterruptedException e) { //e.printStackTrace(); //return; } }
		 */
	}

	/*
	 * public void runCode(){
	 * 
	 * if ( getVal("all_keskmine") < 400 ){ tagasi(); tick(); viivitus(500);
	 * tick(); vasakule(); tick(); viivitus(500); tick(); } else if
	 * (getVal("all_vasak")<400){ paremale(); tick(); viivitus(500); tick(); }
	 * else if (getVal("all_parem")<400) { vasakule(); tick(); viivitus(800);
	 * tick(); } else if ((getVal("vastane_vasak") > 150) &&
	 * (getVal("vastane_parem") > 150)){
	 * 
	 * edasi(); tick(); viivitus(100); tick(); } else if
	 * (getVal("vastane_vasak")>150){ while (getVal("vastane_parem") < 150){
	 * vasakule(); } tick(); } }
	 */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_4BYTE_ABGR);
		//Graphics2D g2d = bimg.createGraphics();
	    AffineTransform origXform = g2d.getTransform();
	    AffineTransform newXform = (AffineTransform)(origXform.clone());
	     //center of rotation is center of the panel
	     //int xRot = img.getWidth()/2;
	     int xRot = img.getWidth(null)/2;
	     int yRot = img.getHeight(null)/2;
	     newXform.rotate(Math.toRadians(UserState.angle), xRot, yRot);
	     g2d.setTransform(newXform);
	     //draw image centered in panel
	     //int x = (getWidth() - img.getWidth(this))/2;
	     //int y = (getHeight() - img.getHeight(this))/2;
	     g2d.drawImage(img, UserState.x, UserState.y, null);
	     g2d.setTransform(origXform);
		//g.drawImage(img, UserState.x, UserState.y, null);
		g2d.drawString("YOU", 1, 600);
		g2d.drawString("all_vasak", 1, 610);
		g2d.drawString("all_keskmine", 1, 620);
		g2d.drawString("all_parem", 1, 630);
		g2d.drawString("vastane_vasak", 150, 610);
		g2d.drawString("vastane_parem", 150, 620);
		g2d.drawString("vasak mootor", 250, 610);
		g2d.drawString("parem mootor", 250, 620);
		g2d.drawString("state.x " + UserState.x, 350, 620);
	}

	public void setImage(Image imgMyRobot) {
		img = imgMyRobot;
	}

}

