package net.azib.java.students.t020556.homework;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DecathlonEvent class which contains enumerations to dechtlon events. Events divide into 
 * two categories: Running and Field events.
 *
 * @author Agu Aarna
 * @version 1
 */
public final class DecathlonEvent {
	
	/**
	 * 
	 * RUNNING enum represents dechatlon running events
	 *
	 * @author Agu Aarna
	 * @version 1
	 */
	public enum Running{
		A_100_M(25.437, 18, 1.81),
		A_400_M(1.53775, 82, 1.81),
		A_110_M_HURDLE(5.74352, 28.5, 1.92),
		A_1500_M(0.03768, 480, 1.85);

		//private constants
		private double constA;
		private double constB;
		private double constC;
		private DateFormat timeFormatterLong = new SimpleDateFormat("mm:ss.SS");
		private NumberFormat timeFormatterShort = NumberFormat.getInstance(Locale.US);
		
		//logger
		private Logger LOG = Logger.getLogger(this.getClass().getName());
		
		/**
		 * The consructor
		 * @author Agu Aarna
		 * 
		 * @param constA - the A constant of the dechatlon points calculation equasion
		 * @param constB - the B constant of the dechatlon points calculation equasion
		 * @param constC - the C constant of the dechatlon points calculation equasion
		 * 
		 * @version 1
		 */
		Running(double constA, double constB, double constC){
			this.constA = constA;
			this.constB = constB;
			this.constC = constC;
		}
		
		/**
		 * calculatePoints calculates dechatlon ponints according to the provided result in the
		 * parameter field
		 * @author Agu Aarna
		 * 
		 * @param resultTime - the time value from which to calculate the results; overloads 
		 * calculatePoints(Date). The result has to be in a format "mm:ss.SS" or "ss.SS".
		 * 
		 * @version 1
		 */
		public double calculatePoints(String resultTime){
			if(resultTime == null){
				LOG.severe("Passed argument was null! Unable to colculate points!");
				return 0;
			}
			//first try date
			try {
				return calculatePoints(timeFormatterLong.parse(resultTime));
			}
			catch (ParseException e) {
				LOG.warning( "Unable to parse time string \"" + resultTime + 
					"\" for the event " + this + ". Parsing by number...");
			}
			
			//then try decimal number
			try {
				return calculatePoints(timeFormatterShort.parse(resultTime).doubleValue());
			}
			catch (ParseException e) {
				LOG.log(
						Level.SEVERE, "Unable to parse time string \"" + 
						resultTime + "\" for the event " + this, e);
				return 0;
			}
		}

		/**
		 * calculatePoints calculates dechatlon ponints according to the provided result in the
		 * parameter field
		 * @author Agu Aarna
		 * 
		 * @param resultTime - the time value from which to calculate the results. Only minute, second
		 * and millisecond fields will be examined
		 * 
		 * @version 1
		 */
		public double calculatePoints(Date resultTime){
			if(resultTime == null){
				LOG.severe("Passed argument was null! Unable to colculate points!");
				return 0;
			}

			Calendar cal = new GregorianCalendar();
			cal.setTime(resultTime);
			double points =
				(double)cal.get(Calendar.MILLISECOND) / 100 + 
				cal.get(Calendar.MINUTE) * 60 + 
				cal.get(Calendar.SECOND);
			
			//return points
			return calculatePoints(points); 
		}
		
		/**
		 * calculatePoints calculates dechatlon ponints according to the provided result in the
		 * parameter field
		 * @author Agu Aarna
		 * 
		 * @param resultTime - the time value in seconds from which to calculate the results
		 * 
		 * @version 1
		 */
		private double calculatePoints(double resultTime){
			return constA * Math.pow(constB - resultTime, constC);
		}
	}
	
	/**
	 * 
	 * FIELD enum represents dechatlon field events
	 *
	 * @author Agu Aarna
	 * @version 1
	 */
	public enum Field{
		LONG_JUMP(0.14354, 220, 1.40),
		SHOT_PUT(51.39, 1.5, 1.05),
		HIGH_JUMP(0.8465, 75, 1.42),
		DISCUS_THROW(12.91, 4.0, 1.1),
		POLE_VAULT(0.2797, 100, 1.35),
		JAVELIN_THROW(10.14, 7.0, 1.08);
		
		//private constants
		private double constA;
		private double constB;
		private double constC;
		private NumberFormat formatter = NumberFormat.getInstance(Locale.US);
		
		//logger
		private Logger LOG = Logger.getLogger(this.getClass().getName());

		/**
		 * The consructor
		 * @author Agu Aarna
		 * 
		 * @param constA - the A constant of the dechatlon points calculation equasion
		 * @param constB - the B constant of the dechatlon points calculation equasion
		 * @param constC - the C constant of the dechatlon points calculation equasion
		 * 
		 * @version 1
		 */
		Field(double constA, double constB, double constC){
			this.constA = constA;
			this.constB = constB;
			this.constC = constC;
		}
		
		/**
		 * calculatePoints calculates dechatlon ponints according to the provided result in the
		 * parameter field
		 * @author Agu Aarna
		 * 
		 * @param resultLength - the length value in meters from which to calculate the results.
		 * 
		 * @version 1
		 */
		public double calculatePoints(String resultLength){
			if(resultLength == null){
				LOG.severe("Passed argument was null! Unable to colculate points!");
				return 0;
			}

			try {
				return calculatePoints(formatter.parse(resultLength).doubleValue());
			}
			catch (ParseException e) {
				LOG.log(
						Level.SEVERE, "Unable to parse length string \"" + 
						resultLength + "\" for the event " + this, e);
				return 0;
			}
		}

		/**
		 * calculatePoints calculates dechatlon ponints according to the provided result in the
		 * parameter field
		 * @author Agu Aarna
		 * 
		 * @param resultLength - the length value in meters from which to calculate the results
		 * 
		 * @version 1
		 */
		public double calculatePoints(double resultLength){
			//handle high_jump separately
			if(this == DecathlonEvent.Field.HIGH_JUMP)
				resultLength *= 100;
				
			//return points
			return constA * Math.pow(resultLength - constB, constC);
		}
	}
}
