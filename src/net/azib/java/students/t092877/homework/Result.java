package net.azib.java.students.t092877.homework;

public class Result {

	private Event event;
	private double value;

	Result(Event event, double value) {
		this.event = event;
		this.value = value;
	}

	public Event getEvent() {
		return event;
	}

	public  void setEvent(Event event) {
		this.event = event;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getScore(){
		return event.getScore(value);
	}
}
