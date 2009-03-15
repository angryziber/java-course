/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.hometasks.lecture4;

import net.azib.java.lessons.collections.Shape;

/**
 *
 * @author karlb
 */
public class Square extends Shape {

    private double lenghtOfSide;

    Square(double lenghtOfSide) {
        if(lenghtOfSide < 0){
            throw new IllegalArgumentException("Lenght of side cannot be negative!");
        }
        this.lenghtOfSide = lenghtOfSide;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Square){
            Square s = (Square) o;
            return this.lenghtOfSide == s.lenghtOfSide;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 23 * new Double(this.lenghtOfSide).intValue() + 19;
    }

    @Override
    public String toString() {
        return "This is square with side lenght " + this.lenghtOfSide;
    }

    @Override
    public double area() {
        return Math.pow(lenghtOfSide, 2);
    }

}
