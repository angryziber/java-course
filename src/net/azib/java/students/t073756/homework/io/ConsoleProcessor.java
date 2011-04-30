package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.DecathlonException;
import net.azib.java.students.t073756.homework.validator.ResultValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConsoleProcessor extends AbstractInputProcessor<BufferedReader> {

    public ConsoleProcessor(BufferedReader source) {
        super(source);
    }

    private Map<String, ResultValidator> questionsWithRegexp = new LinkedHashMap<String, ResultValidator>();

    {
        questionsWithRegexp.put("Athlete name", ResultValidator.NAME_VALIDATOR);
        questionsWithRegexp.put("Athlete birthday in format \"dd.MM.yyyy\" (d-day, M-month, y-year digits)", ResultValidator.BIRTHDAY_VALIDATOR);
        questionsWithRegexp.put("Country (ISO 2-letter code)", ResultValidator.ISO2_COUNTRY_VALIDATOR);
        questionsWithRegexp.put("100 m sprint (sec) in format ss.ms", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("Long jump (m) in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("Shot put (m) in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("High jump (m) in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("400 m sprint in format min:sec.ms", ResultValidator.TIME_RESULT_VALIDATOR);
        questionsWithRegexp.put("110 m hurdles in format sec.ms", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("Discus throw in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("Pole vault in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("Javelin throw in format m.sm", ResultValidator.SIMPLE_RESULT_VALIDATOR);
        questionsWithRegexp.put("1500 m race in format min:sec.ms", ResultValidator.TIME_RESULT_VALIDATOR);
    }

    public List<Athlete> readAthletes() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        do {
            List<String> athleteData = new ArrayList<String>();
            for (Map.Entry<String, ResultValidator> questionEntry : questionsWithRegexp.entrySet()) {
                String answer;
                do {
                    answer = askQuestion(questionEntry.getKey(), getSource());
                } while (!questionEntry.getValue().validate(answer));
                athleteData.add(answer);
            }
            athletes.add(createAthlete(athleteData));
        } while (askYesNoQuestion("Want to add one more athlete? (yes/no)", getSource()));
        return athletes;
    }

    private String askQuestion(String question, BufferedReader source) {
        System.out.println(question);
        try {
            return source.readLine();
        } catch (IOException e) {
            throw new DecathlonException("");
        }
    }

    private boolean askYesNoQuestion(String question, BufferedReader source) {
        String answer;
        do {
            answer = askQuestion(question, source);
        } while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
        return answer.equals("yes");
    }
}
