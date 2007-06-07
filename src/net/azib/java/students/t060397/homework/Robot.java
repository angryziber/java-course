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

import java.awt.Image;



/**
 * @author marcus
 *
 */
abstract public class Robot {
	public Image img;
	public String robotName;
	
	abstract public void run();
	

	
	
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	public void backward() {
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.BACKWARD;
			UserState.rmotork = UserState.motorState.BACKWARD;	
		}else{
			UserState.lmotor = UserState.motorState.BACKWARD;
			UserState.rmotor = UserState.motorState.BACKWARD;	
		}
	}

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
	
	public void stop(){
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.STOP;
			UserState.rmotork = UserState.motorState.STOP;	
		}else{
			UserState.lmotor = UserState.motorState.STOP;
			UserState.rmotor = UserState.motorState.STOP;	
		}
	}
	public void forward() {
		if(getRobotName()=="killerRobot"){
			UserState.lmotork = UserState.motorState.FORWARD;
			UserState.rmotork = UserState.motorState.FORWARD;	
		}else{
			UserState.lmotor = UserState.motorState.FORWARD;
			UserState.rmotor = UserState.motorState.FORWARD;	
		}
		
	}
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
	
	public void ms_sleep(int ms) {
		/*
		 * while (Thread.currentThread() == sumoCode) { try { Thread.sleep(ms); }
		 * catch (InterruptedException e) { //e.printStackTrace(); //return; } }
		 */
	}



}
