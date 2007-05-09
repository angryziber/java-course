package net.azib.java.students.t020632.homework;

/**
 * FieldEventCalculator is used to calculate scores for 
 * non-running events (Long Jump, Shot Put, High Jump,
 * Discus Throw, Pole Vault and Javelin Throw)
 * 
 *
 * @author Marek Soobik
 */
public class FieldEventCalculator implements EventCalculator {
	
	public static FieldEventCalculator calculator;
	
	private FieldEventCalculator(){
		
	}
	
	public static FieldEventCalculator getCalculator(){
		
		if(calculator == null){
			calculator = new FieldEventCalculator();
		}
		
		return calculator;
	}
	
	public int calculate(EventInfo info, float result) {
			
		int score = 0;
			
		score = (int) (info.getA() * Math.pow((result - info.getB()), info.getC()));
			
		return score;
	}
}
