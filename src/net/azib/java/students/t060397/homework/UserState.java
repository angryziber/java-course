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

public class UserState {
	
	public enum motorState {
		FORWARD,
		BACKWARD,
		STOP
		}
	
	static public int x, y;

	static public double angle;

	static public int vastane_vasak, vastane_parem;

	static public boolean all_vasak, all_keskmine, all_parem;

	static public motorState lmotor, rmotor;
	
	static public int xk, yk;

	static public double anglek;

	static public int vastane_vasakk, vastane_paremk;

	static public boolean all_vasakk, all_keskminek, all_paremk;

	static public motorState lmotork, rmotork;

	public static boolean off;
	public static boolean offk;
}
