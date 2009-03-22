package net.azib.java.students.t050545.hometasks.animal;

/**
 * Animal
 *
 * @author libricon
 */
public abstract class Animal {
     private String name;
     private int age;
     
     Animal(String name, int age) {
    	 this.name = name;
    	 this.age = age;
     }
     
     public int getAge(){
    	 return age;
     }
     
     public String getName(){
    	 return name;
     }
     
     public void setAge(int age){
    	 this.age = age;
     }
     
     public void setName(String name){
    	 this.name = name;
     }

     abstract public void makeSound();
     abstract public void eat();
}    

