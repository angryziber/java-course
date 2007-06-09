package net.azib.java.students.t060397.homework;

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



import java.awt.Graphics;

/**
 * Match class creates robots and move controller.
 * @author Margus Ernits
 */
public class Match implements Runnable{
	Thread move;


    BotRobot killerRobot = new BotRobot();
    UserRobot userRobot = new UserRobot();
    
	
	Match(){

		move = new Thread(this);
		move.start();
	}
	
	/**
	 * Move calculations based on robot state
	 */
	public void run() {
		while (Thread.currentThread() == move) {
			try {
				killerRobot.turn();
				userRobot.turn();
				if(DohjoBehaviour.offDohjo(killerRobot.data.getX(), killerRobot.data.getY())){
					break;
					
				}
			
					

				Thread.sleep(SumoApp.getDelay()/5);

			} catch (InterruptedException e) {
			}
		}
	}


    /**
     * paints robots
     */
    public void render(Graphics g){

    	killerRobot.paint(g);
    	userRobot.paint(g);
    }

	/**
	 * sets robot starting angles and names
	 */
	public void init() {
		killerRobot.data.setName("killerRobot");
		killerRobot.data.setAngle(0);
		killerRobot.data.setX(DohjoData.getDohjoCentreX());
		killerRobot.data.setY(DohjoData.getDohjoCentreY()-DohjoData.getSartLine()-RobotData.getDimension());
		userRobot.data.setName("userRobot");
		userRobot.data.setAngle(90);
	}
    
}
