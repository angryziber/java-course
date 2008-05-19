package net.azib.java.students.t030629.homework;

import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.io.CSVLoader;

import java.util.logging.Logger;

/**
 * Helper class for creating Athletes
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 10:22:36
 */
public class AthleteCreatorTestHelper {
    private static final Logger LOG = Logger.getLogger(AthleteCreatorTestHelper.class.getName());

    static {
        DecathlonCalculator.initProperties();
    }

    private static String[] athleteData = {
            "\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01", // 3100 points
            "\"Siim Susi\",1.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72",        // 4234 points
            "\"Sz?r?s Sz?k\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75"     // 3495 points
    };

    public static String[] createAthleteData(int... indices) {
        String[] athleteData = new String[indices.length];
        for (int i = 0; i < indices.length; i++) {
            athleteData[i] = AthleteCreatorTestHelper.athleteData[indices[i]];
        }
        return athleteData;
    }

    public static Athlete[] createUnsortedAthletes() {
        return createAthletes(getUnsortedAthleteIndices());
    }

    public static Athlete[] createSortedAthletes() {
        return createAthletes(getSortedAthleteIndices());
    }

    public static Athlete[] createDuplicatedSortedAthletes() {
        return createAthletes(1, 2, 2);
    }

    public static Athlete[] createAthletes(int... indices) {
        Athlete[] athlets = new Athlete[indices.length];
        for (int i = 0; i < indices.length; i++) {
            try {
                athlets[i] = CSVLoader.loadAthleteFromLine(AthleteCreatorTestHelper.athleteData[indices[i]]);
            } catch (Exception e) {
                LOG.severe(e.getMessage());
            }
        }
        return athlets;
    }

    public static int[] getSortedAthleteIndices() {
        return new int[]{1, 2, 0};
    }

    public static int[] getUnsortedAthleteIndices() {
        return new int[]{0, 1, 2};
    }
}
