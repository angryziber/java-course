package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.DecathlonException;
import net.azib.java.students.t073756.homework.beans.Athlete;
import net.azib.java.students.t073756.homework.beans.CsvHolder;
import net.azib.java.students.t073756.homework.beans.Result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public interface InputProcessor {
    abstract List<Athlete> readAthletes();
}

abstract class AbstractInputProcessor<T> implements InputProcessor {
    private T source;

    protected AbstractInputProcessor(T source) {
        this.source = source;
    }

    final Athlete createAthlete(List<String> athleteData) {
        Athlete a = new Athlete();
        a.setName(athleteData.get(0));
        try {
            a.setDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse(athleteData.get(1)));
        } catch (ParseException e) {
            throw new DecathlonException("unable to parse date. date should be in format dd.MM.yyyy");
        }
        a.setCountry(athleteData.get(2));
        a.setResult(new Result());

        Map<DecathlonEvent, String> results = a.getResult().getResults();
        results.put(DecathlonEvent.M_100, athleteData.get(3));
        results.put(DecathlonEvent.LONG_JUMP, athleteData.get(4));
        results.put(DecathlonEvent.SHOT_PUT, athleteData.get(5));
        results.put(DecathlonEvent.HIGH_JUMP, athleteData.get(6));
        results.put(DecathlonEvent.M_400, athleteData.get(7));
        results.put(DecathlonEvent.HURDLES_110, athleteData.get(8));
        results.put(DecathlonEvent.DISCUS_THROW, athleteData.get(9));
        results.put(DecathlonEvent.POLE_VAULT, athleteData.get(10));
        results.put(DecathlonEvent.JAVELIN_THROW, athleteData.get(11));
        results.put(DecathlonEvent.M_1500, athleteData.get(12));

        CsvHolder.putCsvLine(a, athleteData);
        return a;
    }

    public T getSource() {
        return source;
    }
}