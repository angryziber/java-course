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
import java.awt.Image;



/**
 * Robot is abstract class for robots<p>
 * You must implement run() and ms_sleep according robot role<p>
 * TODO get rid of ugly UserState class<p>
 * @author Margus Ernits
 */
abstract public class Robot {
	/**
	 * Robot picture
	 */
	public Image img;
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
	 * Sets the robots picture. 
	 * @param imgMyRobot  display picture
	 */
	public void setImage(Image imgMyRobot) {
		img = imgMyRobot;
	}
	
	/**
	 * Get the name of robot.
	 * @return robot name
	 */
	public String getRobotName() {
		return robotName;
	}
	/**
	 * Sets the name of robot.
	 * @param robotName
	 */
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	/**
	 * Robot moves backward.<p>
	 * Sets robot state fields used by Move thread
	 */
	public void backward() {
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.BACKWARD;
			UserState.rmotork = UserState.motorState.BACKWARD;	
		}else{
			UserState.lmotor = UserState.motorState.BACKWARD;
			UserState.rmotor = UserState.motorState.BACKWARD;	
		}
	}
	
	/**
	 * Robot turns left.<p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void left() {
		if(getRobotName()=="killerRobot"){
			UserState.angle++;
			UserState.lmotor = UserState.motorState.STOP;
			UserState.rmotor = UserState.motorState.STOP;	
		}else{
			UserState.anglek++;
			UserState.lmotork = UserState.motorState.STOP;
			UserState.rmotork = UserState.motorState.STOP;
		}
	}
	
	/**
	 * Robot turns left.<p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void right() {
		if(getRobotName()=="killerRobot"){
			UserState.angle--;	
			UserState.lmotor = UserState.motorState.STOP;
			UserState.rmotor = UserState.motorState.STOP;
		}else{
			UserState.anglek--;
			UserState.lmotork = UserState.motorState.STOP;
			UserState.rmotork = UserState.motorState.STOP;
		}
	}
	/**
	 * Stops robot.<p>
	 * Sets robot angle and motorstate fields used by Move thread.
	 */
	public void stop(){
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.STOP;
			UserState.rmotork = UserState.motorState.STOP;	
		}else{
			UserState.lmotor = UserState.motorState.STOP;
			UserState.rmotor = UserState.motorState.STOP;	
		}
	}
	/**
	 * Robot moves forward.<p>
	 * Sets robot state fields used by Move thread
	 */
	public void forward() {
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.FORWARD;
			UserState.rmotork = UserState.motorState.FORWARD;	
		}else{
			UserState.lmotor = UserState.motorState.FORWARD;
			UserState.rmotor = UserState.motorState.FORWARD;	
		}
		
	}
	/**
	 * Is robot out of game?
	 * @return out or not
	 */
	public boolean offDohjo(){
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.FORWARD;
			UserState.rmotork = UserState.motorState.FORWARD;
			return false;
		}else{
			UserState.lmotor = UserState.motorState.FORWARD;
			UserState.rmotor = UserState.motorState.FORWARD;
			return false;
		}
		
		
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
