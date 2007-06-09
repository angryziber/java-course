package net.azib.java.students.t060397.homework;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Render is abstract class for render graphics
 *
 * @author Margus Ernits
 */
public class RenderRobot {
	/** Frame number */
	private int frame;

	/**
	 * @return the frame
	 */
	public int getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(int frame) {
		this.frame = frame;
	}
	/**
	 * Draws robot into surface
	 * @param g graphics surface
	 * @param x robot x coordinate
	 * @param y robot y coordinate
	 * @param color robot color
	 * @param angle robot angle
	 */
	public static void drawRobot(Graphics2D g, int x, int y,Color color,double angle){
		
		g.setColor(color);
		g.fillOval( x-Robot.getDimension()/2, y-Robot.getDimension()/2, Robot.getDimension(),Robot.getDimension()); 
	}

}
