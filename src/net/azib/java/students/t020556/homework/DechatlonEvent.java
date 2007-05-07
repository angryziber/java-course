package net.azib.java.students.t020556.homework;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import sun.security.jca.GetInstance;

/**
 * DechatlonEvent class which contains enumerations to dechtlon events. Events divide into 
 * two categories: Running and Field events.
 *
 * @author Agu Aarna
 * @version 1
 */
public final class DechatlonEvent {
	
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
		private DateFormat timeFormatter = new SimpleDateFormat("mm:ss.SS");
		
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
		 * @param result - the time value from which to calculate the results. Only minute, second
		 * and millisecond fields will be examined
		 * 
		 * @version 1
		 */
		public double calculatePoints(Date result){
			Calendar cal = new GregorianCalendar();
			cal.setTime(result);
			BigDecimal timeInSeconds = 
				new BigDecimal((double)cal.get(Calendar.MILLISECOND) / 100 + 
				cal.get(Calendar.MINUTE) * 60 + 
				cal.get(Calendar.SECOND));
			
			return constA * (constB - timeInSeconds) ^ constC;
		}
		
		/**
		 * calculatePoints calculates dechatlon ponints according to the provided result in the
		 * parameter field
		 * @author Agu Aarna
		 * 
		 * @param result - the time value from which to calculate the results; overloads 
		 * calculatePoints(Date). The result has to be in a format "mm:ss.SS".
		 * 
		 * @version 1
		 */
		public double calculatePoints(String result){
			try {
				Date timeFormatted = timeFormatter.parse(result);
				return calculatePoints(timeFormatted);
			}
			catch (ParseException e) {
				LOG.log(
					Level.SEVERE, "Unable to parse time string " + result + " for the event " + this, e);
			}
			return 0;
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
	}
}
