package net.azib.java.students.t110013.homework.model;

import net.azib.java.students.t110013.homework.readers.AthletesReader;
import net.azib.java.students.t110013.homework.readers.AthletesReaderTypes;
import net.azib.java.students.t110013.homework.writers.AthletesWriter;
import net.azib.java.students.t110013.homework.writers.AthletesWriterTypes;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Vadim
 */
public class Application {
    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    void run(String[] args) {
        validateNumberOfArguments(args);

        AthletesReaderTypes readerType = getReaderType(validateInputMethod(args));
        AthletesWriterTypes writerType = getWriterType(validateOutputMethod(args, readerType.isParametrizable()));

        AthletesReader reader = readerType.newInstance(validateInputParameter(args, readerType.isParametrizable()));
        AthletesWriter writer = writerType.newInstance(validateOutputParameter(args, readerType.isParametrizable(), writerType.isParametrizable()));

        List<Athlete> athletes = reader.getAthletes();

        for (Athlete athlete : athletes) {
            athlete.setTotalScore(calculateTotalScore(athlete));
        }

        Collections.sort(athletes, Collections.reverseOrder());

        for (Athlete athlete : athletes) {
            athlete.setPlace(calculatePlace(athlete, athletes));
        }

        writer.writeAthletes(athletes);
    }

    void validateNumberOfArguments(String[] args) {
        if (args.length < 2 || args.length > 4) {
            displayUsageMessage("Invalid number of arguments.");
            throw new IllegalArgumentException();
        }
    }

    String validateInputMethod(String[] args) {
        if(args[0].startsWith("-"))
            return args[0];
        else {
            displayUsageMessage("Invalid or missing input method.");
            throw new IllegalArgumentException();
        }
    }

    String validateOutputMethod(String[] args, boolean readerParametrizable) {
        if(readerParametrizable && !args[1].startsWith("-") && args.length > 2)
            return args[2];
        else if(!readerParametrizable && args[1].startsWith("-"))
            return args[1];
        else {
            displayUsageMessage("Invalid or missing output method.");
            throw new IllegalArgumentException();
        }
    }

    String validateInputParameter(String[] args, boolean readerParametrizable) {
        if(readerParametrizable && !args[1].startsWith("-") && args.length > 2)
            return args[1];
        else if(!readerParametrizable && args[1].startsWith("-"))
            return null;
        else {
            displayUsageMessage("Invalid or missing input parameter.");
            throw new IllegalArgumentException();
        }
    }

    String validateOutputParameter(String[] args, boolean readerParametrizable, boolean writerParametrizable) {
        if(readerParametrizable && writerParametrizable && args.length == 4)
            return args[3];
        else if(!readerParametrizable && writerParametrizable && args.length == 3)
            return args[2];
        else if(readerParametrizable && !writerParametrizable && args.length == 3)
            return null;
        else if(!readerParametrizable && !writerParametrizable && args.length == 2)
            return null;
        else {
            displayUsageMessage("Invalid or missing output parameter.");
            throw new IllegalArgumentException();
        }
    }

    AthletesReaderTypes getReaderType(String arg) {
        for (AthletesReaderTypes readerType : AthletesReaderTypes.values()) {
            if (arg.equals(readerType.getName()))
                return readerType;
        }

        displayUsageMessage("Unsupported input method.");
        throw new IllegalArgumentException();
    }

    AthletesWriterTypes getWriterType(String arg) {
        for (AthletesWriterTypes writerType : AthletesWriterTypes.values()) {
            if (arg.equals(writerType.getName()))
                return writerType;
        }

        displayUsageMessage("Unsupported output method.");
        throw new IllegalArgumentException();
    }

    void displayUsageMessage(String message) {
        StringBuilder sb = new StringBuilder(message);

        sb.append("\nUsage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]\n");
        sb.append("Example: -console -xml output.xml\n");
        sb.append("Currently only following input methods: ");

        for (AthletesReaderTypes readerType : AthletesReaderTypes.values()) {
            sb.append(readerType.getName()).append(" ");
        }

        sb.append("and following output methods: ");

        for (AthletesWriterTypes writerType : AthletesWriterTypes.values()) {
            sb.append(writerType.getName()).append(" ");
        }

        LOG.severe(sb.append("are supported.\n").toString());
    }

    int calculateTotalScore(Athlete athlete) {
        int totalScore = 0;

        for (Decathlon event : Decathlon.values()) {
            totalScore += event.calculateEventScore(athlete.getPerformanceResult(event.getIndex()));
        }

        return totalScore;
    }

    String calculatePlace(Athlete athlete, List<Athlete> athletes) {
        int start = athletes.indexOf(athlete) + 1;
        int end = athletes.lastIndexOf(athlete) + 1;

        if (start == end)
            return String.valueOf(start);
        else
            return start + "-" + end;
    }
}
