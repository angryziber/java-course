package net.azib.java.students.t060397.homework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * RenderMove class draws move status messages
 *
 * @author marcus
 */
public class RenderMove {
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
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


}
