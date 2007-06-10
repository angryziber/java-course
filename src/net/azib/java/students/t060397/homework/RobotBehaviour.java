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
/**
 * 
 */
package net.azib.java.students.t060397.homework;

/**
 * Robot is abstract class for robots
 * <p>
 * You must implement run() and ms_sleep according robot role
 * 
 * @author Margus Ernits
 */
abstract public class RobotBehaviour {
	public RobotData data = new RobotData();

	/**
	 * Override the run() method for particular robot.
	 * <p>
	 * Run method for user robot will be generated from Sumolanguage program by
	 * web interface
	 * <p>
	 * Interface address <a href="http://robot.itcollege.ee:800/~robot/sumo/">is
	 * here.</a>
	 * <p>
	 * Please upload some robot code according Sumo language.
	 * <p>
	 * Please see <a
	 * href="http://robot.itcollege.ee:800/~robot/sumo/sumolanguage_tutorial.html">Sumolanguage
	 * tutorial (currently only in Estonian)</a>
	 */
	abstract public void run();

	/**
	 * Robot moves backward.
	 * <p>
	 * Sets robot state fields used by Move thread
	 */
	public void backward() {
		data.setLmotor(RobotData.motorState.BACKWARD);
		data.setRmotor(RobotData.motorState.BACKWARD);
	}

	/**
	 * Robot turns left.
	 * <p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void left() {
		this.data.setLmotor(RobotData.motorState.STOP);
		this.data.setRmotor(RobotData.motorState.STOP);
		this.data.setAngle(this.data.getAngle() + 40);

	}

	/**
	 * Robot turns left.
	 * <p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void right() {
		this.data.setLmotor(RobotData.motorState.STOP);
		this.data.setRmotor(RobotData.motorState.STOP);
		this.data.setAngle(this.data.getAngle() - 40);
	}

	/**
	 * Stops robot.
	 * <p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void stop() {
		this.data.setLmotor(RobotData.motorState.STOP);
		this.data.setRmotor(RobotData.motorState.STOP);
	}

	/**
	 * Robot moves forward.
	 * <p>
	 * Sets robot state fields used by Move thread
	 */
	public void forward() {
		this.data.setLmotor(RobotData.motorState.FORWARD);
		this.data.setRmotor(RobotData.motorState.FORWARD);
	}

	/**
	 * Returns sensor value
	 * 
	 * @param sensorName
	 * @return sensor value
	 */
	public int getVal(String sensorName) {
		// TODO please see release.txt
		return 0;
	}

	/**
	 * Robot runs as motor state seys ms milliseconds
	 * 
	 * @param ms
	 *            time in milliseconds
	 */
	abstract public void ms_sleep(int ms);

	private boolean isBackward() {
		if ((this.data.getLmotor() == RobotData.motorState.BACKWARD) && (this.data.getRmotor() == RobotData.motorState.BACKWARD))
			return true;
		return false;
	}

	/**
	 * Robot moves to new position
	 * 
	 */
	public void turn() {

		if ((this.data.getLmotor() == RobotData.motorState.STOP) && (this.data.getRmotor() == RobotData.motorState.STOP)) {
			// TODO too big method, needs refactoring
		}
		else {

			MathCalc.Rumb s = MathCalc.getRumb(this.data.getAngle());

			switch (s) {
			case N: {
				if (this.isBackward()) {
					this.data.incY();
				}
				else {
					this.data.decY();
				}
				break;
			}
			case NW: {
				if (this.isBackward()) {
					this.data.incY();
					this.data.incX();
				}
				else {
					this.data.decY();
					this.data.decX();
				}
				break;
			}
			case W: {
				if (this.isBackward()) {
					this.data.incX();
				}
				else
					this.data.decX();
				break;
			}
			case SW: {
				if (this.isBackward()) {
					this.data.incX();
					this.data.decY();
				}
				else {
					this.data.incY();
					this.data.decX();
				}
				break;
			}
			case S: {
				if (this.isBackward()) {
					this.data.decY();
				}
				else
					this.data.incY();
				break;
			}
			case SO: {
				if (this.isBackward()) {
					this.data.decY();
					this.data.decX();
				}
				else {
					this.data.incY();
					this.data.incX();
				}
				break;
			}
			case O: {
				if (this.isBackward()) {
					this.data.decX();
				}
				else
					this.data.incX();
				break;
			}
			case NO: {
				if (this.isBackward()) {
					this.data.incY();
					this.data.decX();
				}
				else {
					this.data.incX();
					this.data.decY();
				}
				break;
			}

			}
		}
	}
}
