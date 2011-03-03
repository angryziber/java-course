package net.azib.java.students.t103640.PlayingWithAnimals;

public class Bunny extends Pet {
    public String fluffy;

    public Bunny(int age, String name, String fluffy) {
        super(age, name);

          this.fluffy = fluffy;

    }
                                     public String getFurr(){
                    return fluffy;
                }
}




