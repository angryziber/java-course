package net.azib.java.students.t050703;

import java.util.ArrayList;
import java.util.List;

/**
 * Zoo
 *
 * @author Leedu
 */
public class Zoo {

	
	public static void main(String[] args) {
	    Animal[] Animals = new Animal[3]; 
		Animal sheep	= new Sheep("Juhan", 12);
	    Animal rabit    = new Rabit("Juss", 2);
	    Animal cat      = new Cat("Maks", 5);
      
	   	    
	    List tere = new ArrayList(); 
	    
	    tere.add(sheep);
	    tere.add(rabit);
	    tere.add(cat);
	    
	 
	    
		Animals[0] = sheep;
	    Animals[1] = rabit;
	    Animals[2] = cat;
	    
	    for (Animal animal : Animals) {
			
		 System.out.println(animal); 
		 animal.makeSound();
		 System.out.println("\n");
		}
	    
	 System.out.println(tere.get(2));
		
     
	}

}
