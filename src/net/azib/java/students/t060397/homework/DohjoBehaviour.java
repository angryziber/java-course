package net.azib.java.students.t060397.homework;

/**
 * DohjoBehaviour class contains Dohjo functional behaviour
 *
 * @author marcus
 */
public class DohjoBehaviour {

	/**
	 * Checks robot location.
	 * @param x robots x coordinate
	 * @param y robots y coordinate
	 * @return true if robot is outside dohjo
	 * TODO testCase
	 */
	public static boolean offDohjo(int x, int y,int centreX,int centreY,int radius) {
		if (MathCalc.inCircle(x, y,centreX, centreY, (int) ((DohjoConfiguration.getDohjoDiam() * DohjoConfiguration.getDohjoScale() / 2.0) )))
			return false;
		return true;
	
	}
	/**
	 * Inits Dohjo, sets up sumomatch, places robots to board
	 * @param w area width
	 * @param h area heigth
	 */
	public void init(int w, int h) {
		Match sumoMatch = new Match();
		sumoMatch.init();
		int freeArea = DohjoConfiguration.getFreeArea();
		int dohjodiam = DohjoConfiguration.getDohjoDiam();
		int border = DohjoConfiguration.getBorder();
		int	dojoScale = (int) ((w - freeArea) / (double) dohjodiam);
		int startLine = DohjoConfiguration.getSartLine();
		DohjoConfiguration.setDohjoScale(dojoScale);
		int dohjoCentreX = border + (int) (dohjodiam * dojoScale / 2.0);
		DohjoConfiguration.setDohjoCentreX(dohjoCentreX);
		int dohjoCentreY = border + (int) (dohjodiam * dojoScale / 2.0);
		DohjoConfiguration.setDohjoCentreY(dohjoCentreY);
		//UserState.x = BORDER + (int) (DOHJODIAM * dojoScale / 2.0) - (int) (ROBOTWIDTH / 2);
		//UserState.y = BORDER + (int) (DOHJODIAM * dojoScale / 2.0) - (int) (ROBOTHEIGTH / 2) - (int) (STARTLINE * dojoScale);
		UserState.x = dohjoCentreX;
		UserState.y = dohjoCentreY- (int) (startLine * dojoScale);
		UserState.xk = border + (int) (dohjodiam * dojoScale / 2.0) - (int) (DohjoConfiguration.getRrobotWidth()/ 2);
		UserState.yk = border + (int) (dohjodiam * dojoScale / 2.0) - (int) (DohjoConfiguration.getRobotHeigth()/ 2) + (int) (startLine * dojoScale);
	}

}
