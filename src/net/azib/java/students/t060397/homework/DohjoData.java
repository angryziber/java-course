package net.azib.java.students.t060397.homework;

/**
 * 
 * DohjoData class contains Japan minisumo board data<p>
 * Dohjo is sumoboard<p>
 * @author Margus Ernits<p>
 * See <a href="http://www.robotroom.com/SumoRules.html">content rules</a>
 * 
 * <p>
 * <img src="http://robot.itcollege.ee:800/~robot/sumo/pic/SumoApp.png" alt="SumoRobot picture">
 * 
 *  
 */
public class DohjoData {

	/**
	 * Some free space for printing status of sensors/motors
	 * 
	 */
	private static final int FREEAREA = 60;
	/**
	 * Japan minisumo board diameter = 77cm
	 */
	private static final int DOHJODIAM = 77;

	private static final int BORDER = FREEAREA / 2;
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
	private static final int ROBOTHEIGTH = 100;
	/**
	 * Brown start line distance from dohjo centre
	 */
	private static final int STARTLINE = 10;
	/**
	 * Dohjo scale factor
	 */
	private static double dohjoScale;
	/**
	 * Dohjo centre point X coordinate [px]
	 */
	private static int dohjoCentreX;
	/**
	 * Dohjo centre point Y coordinate [px]
	 */
	private static int dohjoCentreY;

	/**
	 * @return the border
	 */
	public static int getBorder() {
		return BORDER;
	}

	/**
	 * WhiteArea is 2 cm white border of dohjo
	 * @return the WhiteArea
	 */
	public static int getWhiteArea() {
		return WHITEAREA;
	}

	/**
	 * Japan minisumo board diameter = 77cm
	 * @return the Dohjo Diameter [cm]
	 */
	public static int getDohjoDiam() {
		return DOHJODIAM;
	}

	/**
	 * @return the Dohjo scale factor
	 */
	public static double getDohjoScale() {
		return dohjoScale;
	}

	/**
	 * @param dohjoScale the Dohjo scale factor to set
	 */
	public static void setDohjoScale(double dohjoScale) {
		DohjoData.dohjoScale = dohjoScale;
	}

	/**
	 * @return the the Dohjo centre point X coordinate [px]
	 */
	public static int getDohjoCentreX() {
		return dohjoCentreX;
	}

	/**
	 * 
	 * @param dohjoCentreX the Dohjo centre point X coordinate [px] to set
	 */
	public static void setDohjoCentreX(int dohjoCentreX) {
		DohjoData.dohjoCentreX = dohjoCentreX;
	}

	/**
	 * @return the Dohjo centre point Y coordinate [px]
	 */
	public static int getDohjoCentreY() {
		return dohjoCentreY;
	}

	/**
	 * @param dohjoCentreY the Dohjo centre point Y coordinate [px] to set
	 */
	public static void setDohjoCentreY(int dohjoCentreY) {
		DohjoData.dohjoCentreY = dohjoCentreY;
	}

	/**
	 * @return the FreeArea
	 */
	public static int getFreeArea() {
		return FREEAREA;
	}

	/**
	 * @return the  Brown start line distance from dohjo centre [cm]
	 */
	public static int getSartLine() {
		return STARTLINE;
	}

	/**
	 * @return the Robot default width [px]
	 */
	public static int getRrobotWidth() {
		return ROBOTWIDTH;
	}

	/**
	 * @return the Robot default heigth [px]
	 */
	public static int getRobotHeigth() {
		return ROBOTHEIGTH;
	}

}
