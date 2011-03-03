package net.azib.java.students.t104950;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 25.02.11
 * Time: 9:30
 * To change this template use File | Settings | File Templates.
 */
public class Cat extends Pet{
      public Cat(int age,String name,int mouseCount){
          super(age,name);
      this.mouseCount=mouseCount;}

    void makeSound() {
        System.out.println("Nurrr");
    }

    private int mouseCount;
    int getMouseCount(){return mouseCount;}

    //void setWeight(int weight) {this.weight=weight;}

}

