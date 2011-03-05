package net.azib.java.students.t104971.homework.athletics.arithmetics;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.components.Result;

import java.util.Collection;
import java.util.Map;

/**
 * @author Jaroslav Judin
 */
public class Calculator {

    private Collection<Athlete> athletes;

    public Calculator(Collection<Athlete> athletes) {
        this.athletes = athletes;
    }


    public void calculate() {
        for (Athlete athlete : athletes) {
            int totalScore = 0;
            for (Result result : athlete.getResults()) {
                totalScore += result.getScore();
            }
            athlete.setTotalScore(totalScore);
        }
    }
}
