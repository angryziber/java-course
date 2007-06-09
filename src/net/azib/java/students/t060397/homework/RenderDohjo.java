package net.azib.java.students.t060397.homework;

import java.awt.Color;
import java.awt.Graphics;

/**
 * RenderDohjo class draws dohjo board 
 *
 * @author Margus Ernits
 */
public class RenderDohjo {
	
	
	/**
	 * Paints Dohjo
	 * @param g  applet graphics
	 */
	public void paint(Graphics g) {
		int whitearea=DohjoData.getWhiteArea();
		int border=DohjoData.getBorder();
		int diameter=DohjoData.getDohjoDiam();
		double dojoScale=DohjoData.getDohjoScale();
		g.drawString("Sumorobotite rammukatsumine " + SumoApp.getFrame(), 10, 10);
		g.setColor(Color.white);
		g.fillArc(border, border, (int) (diameter * dojoScale), (int) (diameter * dojoScale), 0, 360);
		g.setColor(Color.black);
		g.fillArc((int) (border+ whitearea * dojoScale), (int) (border + whitearea * dojoScale),
				(int) (diameter * dojoScale - whitearea * whitearea * dojoScale), (int) (diameter * dojoScale - whitearea * whitearea * dojoScale), 0, 360);

	}

}
