package net.azib.java.students.t100337;

import java.util.Random;

/**
 * Kitchen
 *
 * @author xyxeszter
 */
public class Kitchen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Turtle turtles[];		
		turtles = new Turtle[] { new Turtle("Michelangelo", 3), new Turtle("Donatello", 2), new Turtle("Rafaello", 5), new Turtle("Leonardo",10)}; 
		
		for (Turtle turtle : turtles) {
			System.out.println(turtle.cooking());
		}		
	
		Snail snails[] =  new Snail[100];
		int numberNonToxic = 0;
		
		for (int i = 0; i < snails.length; i++){
			snails[i] = new Snail((int)(Math.random()*10), (int)(Math.random()*5));
			if (snails[i].toxicity < 2 && snails[i].age < 3){				
				numberNonToxic++;
				snails[i].cooking();
			}				 
		}
		System.out.println("We just cooked " + numberNonToxic + " non-toxic young snail(s)");
	}
}
