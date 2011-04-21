package ee.ttu.decathlon.io;

import ee.ttu.decathlon.beans.Athlete;
import ee.ttu.decathlon.beans.Result;

import java.util.List;

public class ConsoleOutput implements OutputProvider {

    public void writeAthletes(List<Athlete> athletes) {
        for (Athlete athlete : athletes) {
            Result result = athlete.getResult();
            String name = athlete.getName().replaceAll("\"", "");
            if (name.length() > 15) {
                name = name.substring(0, 15);
            }
            String start = String.format("%1$3s|%2$5s|%3$-15s|%4$tm.%4$2te.%4$tY|%5$2s|",
                    result.getPlace(), result.getOverallResult(), name, athlete.getDateOfBirth(), athlete.getCountry());
            for (String r : result.getResults().values()) {
                start += String.format("%1$-8s|", r);
            }
            System.out.println(start);
        }
    }
}
