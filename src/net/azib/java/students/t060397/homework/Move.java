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

public class Move implements Runnable {
	Thread move;

	/** Ctor. */
	Move() {

		move = new Thread(this);
		move.start();
	}

	/** TODO */
	public void run() {
		while (Thread.currentThread() == move) {
			try {
				
				//UserState.y--;
				if ((UserState.lmotor == UserState.motorState.FORWARD) && (UserState.rmotor == UserState.motorState.FORWARD)){
					UserState.y++;
					//UserState.y++;
				}else if ((UserState.lmotor==UserState.motorState.BACKWARD) && (UserState.rmotor==UserState.motorState.BACKWARD )){
					UserState.y--;
					
				}
				if(Dohjo.offDohjo(UserState.x, UserState.y)){
					UserState.off=true;
					break;
				}
				
			
					

				Thread.sleep(SumoApp.DELAY/10);

			} catch (InterruptedException e) {
			}
		}
	}

}
