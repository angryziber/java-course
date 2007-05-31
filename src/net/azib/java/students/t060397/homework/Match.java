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

package net.azib.java.students.t060397.homework;

import java.awt.Graphics;
import java.awt.Image;


public class Match {
	
	
	
    SumoCode killerRobot = new SumoCode();
    //killerRobot.setRobotName("killerRobot");
    UserCode userRobot = new UserCode();
    Move move = new Move();
    
  
    

    public void paint(Graphics g){
    	killerRobot.paint(g);
    	userRobot.paint(g);
    }
	public void setImages(Image imgMyRobot, Image imgYouRobot) {
		killerRobot.setImage(imgMyRobot);
		userRobot.setImage(imgYouRobot);
		
	}
	public void init() {
		killerRobot.setRobotName("killerRobot");
		UserState.angle=0;
		userRobot.setRobotName("userRobot");
		UserState.anglek=90;
	}
	public void stop(){
		
	}
	public void endMatch(String robotName){
		//stop();
		
	}

    
}
