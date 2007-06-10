package net.azib.java.students.t060397.homework;

/**
 * DohjoBehaviour class contains Dohjo functional behaviour
 * 
 * @author marcus
 */
public class DohjoBehaviour {

	/**
	 * Checks robot location.
	 * 
	 * @param x
	 *            robots x coordinate
	 * @param y
	 *            robots y coordinate
	 * @return true if robot is outside dohjo
	 */
	public static boolean offDohjo(int x, int y) {
		if (MathCalc.inCircle(x, y, DohjoData.getDohjoCentreX(), DohjoData.getDohjoCentreY(), (int) ((DohjoData.getDohjoDiam()
				* DohjoData.getDohjoScale() / 2.0))))
			return false;
		return true;

	}

	/**
	 * Inits Dohjo, sets up sumomatch, places robots to board
	 * 
	 * @param w
	 *            area width
	 * @param h
	 *            area heigth
	 */
	public void init(int w, int h) {

		/* Calculate Dohjo runtime parameters */
		int freeArea = DohjoData.getFreeArea();
		int dohjodiam = DohjoData.getDohjoDiam();
		int border = DohjoData.getBorder();
		int dojoScale = (int) ((w - freeArea) / (double) dohjodiam);

		DohjoData.setDohjoScale(dojoScale);
		int dohjoCentreX = border + (int) (dohjodiam * dojoScale / 2.0);
		DohjoData.setDohjoCentreX(dohjoCentreX);
		int dohjoCentreY = border + (int) (dohjodiam * dojoScale / 2.0);
		DohjoData.setDohjoCentreY(dohjoCentreY);

	}

}
