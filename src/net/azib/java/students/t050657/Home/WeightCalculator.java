/**
 * WeightCalculator
 * @author t050657
 *
 */
public class WeightCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Planet planet = Planet.MERCURY;
		
		for(int i = 0; i<9; i++) {
			planet = Planet.values()[(planet.ordinal() + 1) % Planet.values().length];
			double weigth = planet.surfaceWeight(65);
			System.out.println("On the " + planet + " = " + (int)weigth);
		}
	}
}
