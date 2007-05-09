package net.azib.java.students.t020632.homework;

/**
 * Event is a class which represents one decathlon event
 *
 * @author Marek Soobik t020632
 */
public class Event {
	
	private EventInfo eventInfo;
	private EventCalculator calculator;
	private float result;
	private int score;
	
	public Event(EventInfo ei, EventCalculator ec){
		eventInfo = ei; 
		calculator = ec;
	}
	
	public void setResult(float result){
		this.result = result;
	}
	
	public int calculate(){
		int score = 0;
		
		score = calculator.calculate(eventInfo, result);
		
		return score;
		
	}
	
	public EventInfo getEventInfo(){
		return eventInfo;
	}
	
	public EventCalculator getCalculator(){
		return calculator;
	}
	
	public float getResult(){
		return result;
	}
	
	public int getScore(){
		return this.score;
	}
	
	
	
}
