package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract class AbstractInputProcessor<T> implements InputProcessor {
    private T source;

    AbstractInputProcessor(T source) {
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
	    Iterator<String> i = athleteData.iterator();
	    for (DecathlonEvent event : DecathlonEvent.values()) {
		    results.put(event, i.next());
	    }

        CsvHolder.putCsvLine(a, athleteData);
        return a;
    }

    public T getSource() {
        return source;
    }
}
