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

import java.awt.Graphics;



/**
 * Robot is abstract class for robots<p>
 * You must implement run() and ms_sleep according robot role<p>
 * TODO get rid of ugly UserState class<p>
 * @author Margus Ernits
 */
abstract public class RobotBehaviour {
	public RobotData data = new RobotData(); 
	private String robotName;
	/**
	 * Override the run() method for particular robot. <p>
	 * Run method for user robot will be generated from Sumolanguage program by web interface<p>
	 * Interface address <a href="http://robot.itcollege.ee:800/~robot/sumo/">is here.</a><p>
	 * Please upload some robot code according Sumo language.<p>
	 * Please see <a href="http://robot.itcollege.ee:800/~robot/sumo/sumolanguage_tutorial.html">Sumolanguage tutorial (currently only in Estonian)</a>
	 */
	abstract public void run();
	

	/**
	 * Get the name of robot.
	 * @return robot name
	 */
	public String getName() {
		return robotName;
	}
	/**
	 * Sets the name of robot.
	 * @param robotName
	 */
	public void setName(String robotName) {
		this.robotName = robotName;
	}
	/**
	 * Robot moves backward.<p>
	 * Sets robot state fields used by Move thread
	 */
	public void backward() {
		data.setLmotor(RobotData.motorState.BACKWARD);
		data.setRmotor(RobotData.motorState.BACKWARD);
	}
	
	/**
	 * Robot turns left.<p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void left() {
		data.setLmotor(RobotData.motorState.STOP);
		data.setRmotor(RobotData.motorState.STOP);
		data.incAngle();
	}
	
	/**
	 * Robot turns left.<p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void right() {
		data.setLmotor(RobotData.motorState.STOP);
		data.setRmotor(RobotData.motorState.STOP);
		data.decAngle();
	}
	/**
	 * Stops robot.<p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void stop(){
		data.setLmotor(RobotData.motorState.STOP);
		data.setRmotor(RobotData.motorState.STOP);
	}
	/**
	 * Robot moves forward.<p>
	 * Sets robot state fields used by Move thread
	 */
	public void forward() {
		data.setLmotor(RobotData.motorState.FORWARD);
		data.setRmotor(RobotData.motorState.FORWARD);		
	}
	/**
	 * Is robot out of game?
	 * @return out or not
	 */
	public boolean offDohjo(){
		if(DohjoBehaviour.offDohjo(data.getX(), data.getY())) return true;
		return false;
		
	}
	/**
	 * Returns sensor value
	 * @param sensorName
	 * @return sensor value
	 */
	public int getVal(String sensorName) {
		//TODO please see release.txt
		return 0;
	}
	/**
	 * Robot runs as motor state seys ms milliseconds
	 * @param ms time in milliseconds
	 */
	abstract public void ms_sleep(int ms);
	/**
	 * Paints robot
	 * @param g applet graphics object
	 */
	abstract public void paint(Graphics g);
	



}
