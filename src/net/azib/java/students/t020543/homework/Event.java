package net.azib.java.students.t020543.homework;

import java.lang.Math;

/**
 * An <b>enum</b>, which holds constants 
 * (calculation constants, current World Record) 
 * for every  decathlon event. <br><br>
 * <i>Also implements methods for calculating points for a single event
 * and comparing input with World Record</i>
 *
 * @author t020543
 */

public enum Event implements IEvent {
		
SPRINT100 		( 25.437, 	18.0, 	1.81, 	true,	9.77 ),
LONG_JUMP 		( 0.14354, 	220, 	1.40, 	false, 	8.95 ),
SHOT_PUT 		( 51.39, 	1.5,	1.05, 	false, 	23.12),	
HIGH_JUMP 		( 0.8465,	75,		1.42, 	false, 	2.45 ),	 
SPRINT400 		( 1.53775,	82,		1.81, 	true,	43.18 ), 	 
HURDLES110		( 5.74352,	28.5,	1.92, 	true, 	12.91 ), 	
DISCUS_THROW 	( 12.91,	4.0,	1.10, 	false, 	74.08 ),	 
POLE_VAULT 		( 0.2797,	100,	1.35, 	false, 	6.15 ),	 
JAVELIN_THROW	( 10.14,	7.0,	1.08, 	false, 	98.48 ),
RACE1500 		( 0.03768, 	480,	1.85, 	true, 	206.00 );

private final double a;   
private final double b;
private final double c; 
private final boolean run;
private final double wr;

/**
 * {@link Enum} <b>Event</b> constructor
 * 
 * @param abc - calculation constants
 * @param run - running event flag (<b>true</b> while event is a running event)
 * @param wr -  current World Record in a selected event 
  */
Event(double a, double b, double c, boolean run, double wr) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.run = run;
		this.wr = wr;
	}

	@Override
	public int calculateEvent(double input)
	{
		
		int points;
		
		/* Check for NULL input. 
		  It's possible for an athlete to have 0 as a event result: 
		  For example, in case of disqualification (false start, etc.)*/
		
		if (input == 0) 	
		{					
			points = 0;		
		}
		else {
		/*
		Note! Method uses Math.round (rouding to the nearest ) method 
		So, 195,8 = 196, not 195. ( I couldn't find rounding rule in a specification )
		*/			
				if (run) {	
					//A formula for the running events
					points = (int) Math.round( a * Math.pow((b-input),c));
				}
				else {	
					//A formula for the field events
					points = (int) Math.round( a * Math.pow((input-b),c));
				}
		}
		return points;
	}
	
	@Override
	public boolean compareWorldRecord(double input){
		
		/*To achieve WR, time for running events must be less than current WR, but more than 0*/
		if (run) { 
					if ( (input <= wr) && (input > 0)) 						
						return true;
					else return false;
		}
		/*To achieve WR, measure for field events must be grater than current WR*/
		else {
				if ( input >= wr ) 
					return true;
				else return false;
		}
	}
	
}

