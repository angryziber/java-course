package net.azib.java.students.t104971.homework.athletics.util;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;

import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class PlaceHolderUtil {

    public static String getPlace(Athlete athlete, List<Athlete> athletes) {
        int times = 0;
        int currentPosition = athletes.indexOf(athlete);

        for (Athlete a : athletes) {
            if (a.getTotalScore() == athlete.getTotalScore()) {
                times++;
                int position = athletes.indexOf(a);
                if (position < currentPosition) {
                    currentPosition = position;
                }
            }
        }
        currentPosition++;

        if (times < 2) {
            return String.valueOf(currentPosition);
        }

        return currentPosition + "-" + (currentPosition + times - 1);
    }

}
