package net.azib.java.students.t110013.homework.writers;

import net.azib.java.students.t110013.homework.model.Athlete;
import net.azib.java.students.t110013.homework.model.Decathlon;

import java.util.List;

/**
 * @author Vadim
 */
public class ConsoleAthletesWriter implements AthletesWriter {

	ConsoleAthletesWriter() {
	}

	public void writeAthletes(List<Athlete> athletes) {
        StringBuilder sb = new StringBuilder();

        for (Athlete a : athletes) {
            sb.append("Name: ").append(a.getName()).append("\n");
            sb.append("Date of birth: ").append(a.getDateOfBirth()).append("\n");
            sb.append("Country: ").append(a.getCountry()).append("\n");
            sb.append("Place: ").append(a.getPlace()).append("\n");
            sb.append("Total score: ").append(a.getTotalScore()).append("\n");

            for (Decathlon event : Decathlon.values()) {
                sb.append(event.getName()).append(": ").append(a.getPerformanceResult(event.getIndex())).append("\n");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
