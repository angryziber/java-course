package net.azib.java.students.t020632.homework;

/**
 * EventCalculator interface is implemented by two classes:
 * FieldEventCalculator and RunningEventCalculator. This interface
 * is used because there are different points formula for 
 * Running Events and Field Events.    
 *
 * @author Marek Soobik t020632
 */
public interface EventCalculator {
	public int calculate(EventInfo in, float result);
}
