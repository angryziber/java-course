package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.DecathlonException;
import net.azib.java.students.t073756.homework.validator.ResultValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class ConsoleProcessor extends AbstractInputProcessor<BufferedReader> {

    public ConsoleProcessor(BufferedReader source) {
        super(source);
    }

    final Map<String, ResultValidator> questionsWithRegexp;

	{
		Map<String, ResultValidator> questionsValidators = new LinkedHashMap<String, ResultValidator>();

		questionsValidators.put("Athlete name", ResultValidator.NAME_VALIDATOR);
		questionsValidators.put("Athlete birthday in format \"dd.MM.yyyy\" (d-day, M-month, y-year digits)", ResultValidator.BIRTHDAY_VALIDATOR);
		questionsValidators.put("Country (ISO 2-letter code)", ResultValidator.ISO2_COUNTRY_VALIDATOR);
		questionsValidators.put("100 m sprint (sec) in format ss.ms", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("Long jump (m) in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("Shot put (m) in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("High jump (m) in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("400 m sprint in format min:sec.ms", ResultValidator.TIME_RESULT_VALIDATOR);
		questionsValidators.put("110 m hurdles in format sec.ms", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("Discus throw in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("Pole vault in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("Javelin throw in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
		questionsValidators.put("1500 m race in format min:sec.ms", ResultValidator.TIME_RESULT_VALIDATOR);

		questionsWithRegexp = Collections.unmodifiableMap(questionsValidators);
	}

    public List<Athlete> readAthletes() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        do {
            List<String> athleteData = new ArrayList<String>();
            for (Map.Entry<String, ResultValidator> questionEntry : questionsWithRegexp.entrySet()) {
                String answer;
                do {
                    answer = askQuestion(questionEntry.getKey());
                } while (!questionEntry.getValue().validate(answer));
                athleteData.add(answer);
            }
            athletes.add(createAthlete(athleteData));
        } while (askYesNoQuestion("Want to add one more athlete? (yes/no)"));
        return athletes;
    }

    String askQuestion(String question) {
        System.out.println(question);
        try {
            return getSource().readLine();
        } catch (IOException e) {
            throw new DecathlonException("Unable to receive input from console");
        }
    }

    private boolean askYesNoQuestion(String question) {
        String answer;
        do {
            answer = askQuestion(question);
        } while (!"yes".equalsIgnoreCase(answer) && !"no".equalsIgnoreCase(answer));
        return answer.equals("yes");
    }
}
