package net.azib.java.students.t104971.homework.athletics.arithmetics;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.dto.Result;
import net.azib.java.students.t104971.homework.athletics.dto.ResultType;

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
