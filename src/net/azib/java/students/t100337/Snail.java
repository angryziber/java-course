package net.azib.java.students.t100337;

/**
 * Snail
 *
 * @author xyxeszter
 */
public class Snail extends Mollusc implements Cooking{

	/**
	 * @param args
	 */
	
  public Snail(int age, int toxicity){
    savouriness = true;
    cuteness = false;
    this.age = age; 
    this.toxicity = toxicity;
  }
   	    
  
  public String cooking(){
	  String output= "";
	  if(toxicity < 2) {
		  output += "non-toxic ";
	  }
	  else{
		  output += "toxic "; 
	  }
	  if(age < 3 ){
		  output += "young ";
	  }
	  else{
		  output += "old ";
	  }
	  output += "snails are being cooked";
	  return output;
  }
}
