package net.azib.java.students.t103640.PlayingWithAnimals;


import org.antlr.stringtemplate.language.NewlineRef;

public class AnimalDemo  {
    public static void main(String[] args) {
  Bunny muffins = new Bunny(12, "Muffins", "Shaved");
     Animal[] loadsOfAnimals = new Animal[]{
             new Bunny(1, "Spot", "Groomed"),
             new Bunny(500, "Elder", "Gray"),
             new Bunny(75, "Retired: Extremly Dangerous", "Bald"),
             new BruceWillis(1000)

     };
        System.out.println(muffins.getName() + " is " + muffins.getFurr() + ", she also is " + muffins.getAge() + " years old");
        System.out.println(BruceWillis.getKilledPeople());
       /* for(Animal a : loadsOfAnimals){
            System.out.println(a);
        }
         */
        }


}
