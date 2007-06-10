package net.azib.java.students.t060397.homework;

/**
 * RobotData
 * 
 * @author Margus Ernits
 */
public class RobotData {

	/**
	 * 
	 * motorState - possible states of robot motor
	 * 
	 * @author Margus Ernits
	 */
	public static enum motorState {
		FORWARD, BACKWARD, STOP
	}

	private String robotName;
	/**
	 * Robot coordinates
	 */
	private int x, y;
	/**
	 * Robot angle
	 */
	private int angle;
	/**
	 * Robot motor states
	 */
	private motorState lmotor, rmotor;
	/**
	 * Robot position on dohjo or not
	 */
	private boolean off;
	/**
	 * @return the angle
	 */
	private final static int dimension = 100;

	public int getAngle() {
		return angle;
	}

	/**
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * @return the lmotor
	 */
	public motorState getLmotor() {
		return lmotor;
	}

	/**
	 * @param lmotor
	 *            the lmotor to set
	 */
	public void setLmotor(motorState lmotor) {
		this.lmotor = lmotor;
	}

	/**
	 * @return the off
	 */
	public boolean isOff() {
		return off;
	}

	/**
	 * @param off
	 *            the off to set
	 */
	public void setOff(boolean off) {
		this.off = off;
	}

	/**
	 * @return the rmotor
	 */
	public motorState getRmotor() {
		return rmotor;
	}

	/**
	 * @param rmotor
	 *            the rmotor to set
	 */
	public void setRmotor(motorState rmotor) {
		this.rmotor = rmotor;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Increase robot angle
	 */
	public void incAngle() {
		this.angle++;
		if (angle > 360)
			this.angle = this.angle % 360;

	}

	/**
	 * Decrease robot angle
	 */
	public void decAngle() {
		this.angle--;
		if (angle < 0)
			this.angle = this.angle + 360;

	}

	/**
	 * @return the dimension of robot
	 */
	public static int getDimension() {
		return dimension;
	}

	/**
	 * Increase X coordinate
	 */
	public void incX() {
		this.x++;

	}

	/**
	 * Increase Y coordinate
	 */
	public void incY() {
		this.y++;

	}

	/**
	 * Get the name of robot.
	 * 
	 * @return robot name
	 */
	public String getName() {
		return robotName;
	}

	/**
	 * Sets the name of robot.
	 * 
	 * @param robotName
	 */
	public void setName(String robotName) {
		this.robotName = robotName;
	}

	/**
	 * Decrease Y coordinate
	 */
	public void decY() {
		this.y--;

	}

	/**
	 * Decrease X coordinate
	 */
	public void decX() {
		this.x--;

	}

}
