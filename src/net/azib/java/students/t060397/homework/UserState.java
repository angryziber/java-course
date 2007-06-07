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
/**
 * 
 * UserState class contains robot state<p>
 * WARNING this is bad desing and this class will be dropped<p>
 * Please see release.txt
 *
 * @author Margus Ernits
 */
public class UserState {
	/**
	 * 
	 * motorState - possible states of robot motor
	 *
	 * @author Margus Ernits
	 */
	public enum motorState {
		FORWARD,
		BACKWARD,
		STOP
		}
	/**
	 * 1. Robot coordinates
	 */
	static public int x, y;
	/**
	 * 1. Robot angle
	 */
	static public double angle;
	/**
	 * 1. Robot motor states
	 */
	static public motorState lmotor, rmotor;
	/**
	 * 1. Robot position on dohjo or not
	 */
	public static boolean off;
	/**
	 * 2. Robot coordinates
	 */
	static public int xk, yk;
	/**
	 * 2. Robot angle
	 */
	static public double anglek;
	/**
	 * 2. Robot motor states
	 */
	static public motorState lmotork, rmotork;
	/**
	 * 2. Robot position on dohjo or not
	 */
	public static boolean offk;
}
