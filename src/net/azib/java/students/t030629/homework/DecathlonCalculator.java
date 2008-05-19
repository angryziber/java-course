package net.azib.java.students.t030629.homework;

import net.azib.java.students.t030629.homework.io.*;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;
import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.utils.AthleteResultComparator;
import net.azib.java.students.t030629.homework.base.utils.OrderedAthleteWrapper;
import net.azib.java.students.t030629.homework.utils.LoggingException;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Main class for calculating statistics of Decathlon competition.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 10.05.2008
 * <br>Time: 14:18:10
 */
public class DecathlonCalculator {
    private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class.getName());
    public static final String ENCODING_KEY = DecathlonCalculator.class.getName() + ".encoding";
    public static final String DATE_PATTERN_KEY = DecathlonCalculator.class.getName() + ".datePattern";
    static final String DEFAULT_ENCODING = "UTF-8";
    static final String DEFAULT_DATE_PATTERN = "d.MM.yyyy";

    private Arguments arguments;
    private final OutputStream errorStream;

    /**
     * Shortcut constructor with System.out as error stream
     * @param args program parameters
     */
    public DecathlonCalculator(String[] args) {
        // System.out as error stream, since the System.err will be occupied by Loggers
        this(System.out, args);
    }

    /**
     * Main constructor
     * @param errorStream stream to write errors to
     * @param args program parameters
     */
    public DecathlonCalculator(OutputStream errorStream, String[] args) {
        initProperties();
        this.errorStream = errorStream;
        try {

            /* Parse input arguments */
            arguments = new Arguments(args);

        } catch (IllegalArgumentException e) {
            showErrorAndExit(new LoggingException("Error occurred while parsing arguments: " + e.getMessage(), LOG));
        } 

    }

    public void calculate() {
        try {
            /* Load athletes from source */
            List<Athlete> athlets = loadAthleteResults();
            /* Sort athletes by result */
            sortAthletesByResult(athlets);
            /* Wrap athletes into orderedAthletes containing places */
            OrderedAthlete[] orderedAthletes = new OrderedAthleteWrapper().wrap(athlets.toArray(new Athlete[athlets.size()]));
            /* Save athletes to destination */
            saveAthleteResults(orderedAthletes);

            System.out.println("Success!");
        } catch (Exception e) {
            showErrorAndExit(new LoggingException(e.getMessage(), LOG));
        }


    }

    /**
     * @param orderedAthletes array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes} to save
     * @throws IOException if {@link java.io.FileOutputStream#FileOutputStream(java.io.File)} throws it
     */
    private void saveAthleteResults(OrderedAthlete[] orderedAthletes) throws IOException {
        OutputMethod outputMethod = arguments.getOutMethod();
        AthleteSaver saver;
        switch (outputMethod) {
            case CONOLE:
                saver = new PlainDataSaver(new ConsoleFormatter(), System.out);
                break;
            case CSV:
                saver = new PlainDataSaver(new CSVFormatter(), new FileOutputStream(arguments.getOutFile()));
                break;
            case HTML:
                saver = new HTMLSaver(arguments.getOutFile());
                break;
            case XML:
                saver = new XMLSaver(arguments.getOutFile());
                break;
            default:
                throw new LoggingException("Concrete implementation of AthleteSaver is missing for the following output method: " + outputMethod, LOG);
        }

        saver.save(orderedAthletes);
    }

    /**
     * Sorts specified athletes by result so that the higher the results, the earlier the position of the athlete is 
     * @param athlets array of {@link net.azib.java.students.t030629.homework.base.Athlete Athletes} to sort
     */
    public static void sortAthletesByResult(List<Athlete> athlets) {
        Collections.sort(athlets, new AthleteResultComparator());
    }


    private List<Athlete> loadAthleteResults() {
        InputMethod inMethod = arguments.getInMethod();
        AthleteLoader loader;
        /* Initialize concrete loader */
        switch (inMethod) {
            case CONSOLE:
                loader= new ConsoleLoader();
                break;
            case CSV:
                loader = new CSVLoader(arguments.getInFile(), new AthleteBuilder(), new DefaultNormalizer());
                break;
            case DB:
                loader = arguments.isCompetitionNameSet()
                        ? new DBLoader(arguments.getCompetitionName())
                        : new DBLoader(arguments.getCompetitionId());
                break;
            default:
                throw new LoggingException("Concrete implementation of AthleteLoader is missing for the following input method: " + inMethod, LOG);
        }

        /* Load competition data */
        loader.load();
        return loader.getAthletes();

    }

    public static void initProperties() {
        System.setProperty(ENCODING_KEY, DEFAULT_ENCODING);
        System.setProperty(DATE_PATTERN_KEY, DEFAULT_DATE_PATTERN);
    }

    private void showErrorAndExit(LoggingException e) {
        try {
            String message = e.getMessage();
            errorStream.write(message.getBytes());
            errorStream.flush();
            e.getLog().severe(message);
            System.exit(1);
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, "Error writing an error message", ioe);
        }
    }

    /**
     * Main method of the application
     * @param args program parameters
     */
    public static void main(String[] args) {
        new DecathlonCalculator(args).calculate();
    }

}
