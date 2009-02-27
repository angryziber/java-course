package net.azib.java.students.t050703;

import sun.org.mozilla.javascript.internal.ObjArray;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;



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
      
	    ObjArray tere = new ObjArray(); //needs implementing collections interface to use foreach construct
	    
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
