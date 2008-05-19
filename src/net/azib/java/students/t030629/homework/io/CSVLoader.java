package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.utils.QuietCloser;
import net.azib.java.students.t030629.homework.utils.LoggingException;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Logger;
import java.text.ParseException;
import java.math.BigDecimal;

/**
 * Class loads athletes from CSV file and proposes a set of static methods
 * for loading athletes from CSV lines with the default {@link AthleteBuilder}
 * and {@link ResultNormalizer} implementations ({@link AthleteBuilder} and
 * {@link DefaultNormalizer}, respectively).
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 2:04:05
 */
public class CSVLoader implements AthleteLoader {
    private static final Logger LOG = Logger.getLogger(CSVLoader.class.getName());

    private static final String INCOMPLETE_ATHLETE_LINE_TEXT = "Corrupted Athlete declaring line. The following line doesn't contain all the data: ";

    static final Class DEFAULT_ATHLETE_BUILDER_CLASS = AthleteBuilder.class;
    static final Class DEFAULT_RESULT_NORMALIZER_CLASS = DefaultNormalizer.class;

    private final File inFile;
    private final AthleteBuilder athleteBuilder;
    private ResultNormalizer normalizer;

    private List<Athlete> athlets;

    /**
     * Constructor
     * @param inFile source CSV file to read the athletes' data from
     * @param athleteBuilder athlete builder to use for building {@link Athlete Athletes}
     * @param normalizer result normalizer to use for normalizing results
     */
    public CSVLoader(File inFile, AthleteBuilder athleteBuilder, ResultNormalizer normalizer) {
        this.inFile = inFile;
        this.athleteBuilder = athleteBuilder;
        this.normalizer = normalizer;
        athlets = new LinkedList<Athlete>();
    }

    /**
     * {@inheritDoc}
     */
    public void load() {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), System.getProperty(DecathlonCalculator.ENCODING_KEY)));
            while ((line = in.readLine()) != null && line.length() > 0) {

                athlets.add(loadAthleteFromLine(line, athleteBuilder, normalizer));

            }

        } catch (Exception e) {
            throw new LoggingException(ERROR_LOADING_MESSAGE + e.getMessage(), LOG);
        } finally {
            QuietCloser.closeSilently(in, LOG);
        }

    }

    /**
     * Builds an {@link Athlete} from the sourceLine using athleteBuilder and normalizer, all specified as input parameters.
     * <p>
     * Has a shortcut method {@link #loadAthleteFromLine(String)}.
     *
     * @param sourceLine CSV line containing the athlete's data
     * @param athleteBuilder builder to use for building athletes
     * @param normalizer for normalizing results for the competitions
     * @return an object of Athlete
     * @throws IOException if the athlete declaring line is corrupted (doesn't contain all the data)
     * @throws ParseException if {@link StringParser#parseBirthday(String)} throws it
     * @throws AthleteBuilder.UnsupportedCountryException if {@link AthleteBuilder#addCountry(String)} throws it
     * @throws AthleteBuilder.IncompleteAthleteException if {@link AthleteBuilder#getAthlete()} throws it
     */
    public static Athlete loadAthleteFromLine(String sourceLine, AthleteBuilder athleteBuilder, ResultNormalizer normalizer) throws IOException, ParseException, AthleteBuilder.UnsupportedCountryException, AthleteBuilder.IncompleteAthleteException {

        athleteBuilder.newAthlete();
        String[] tokens = sourceLine.split(",");
        if (tokens.length != 13)
            throw new IOException(INCOMPLETE_ATHLETE_LINE_TEXT + sourceLine);

        // Parse and add PERSONAL DATA
        athleteBuilder.addName(StringParser.parseName(tokens[0]));
        athleteBuilder.addBirthday(StringParser.parseBirthday(tokens[1]));
        athleteBuilder.addCountry(tokens[2]);
        // Parse and add RESULTS
        DecathlonEvent event = DecathlonEvent.getFirstEvent();
        for (int i = 3; i < tokens.length; i++) {
            BigDecimal result = StringParser.parseResult(event, tokens[i]);
            athleteBuilder.addResult(event, normalizer.normalize(event, result));
            event = event.next();
        }

        return athleteBuilder.getAthlete();
    }

    /**
     * Shortcut method for {@link #loadAthleteFromLine(String, net.azib.java.students.t030629.homework.base.utils.AthleteBuilder , ResultNormalizer)},
     * which uses default implementations of {@link AthleteBuilder} and {@link ResultNormalizer} ({@link AthleteBuilder} and {@link DefaultNormalizer},
     * respectively).
     * @param sourceLine CSV line containing the athlete's data
     * @return an object of Athlete
     * @throws java.io.IOException if it is thrown in {@link #loadAthleteFromLine(String, net.azib.java.students.t030629.homework.base.utils.AthleteBuilder, ResultNormalizer)}
     * @throws java.text.ParseException if it is thrown in {@link #loadAthleteFromLine(String, net.azib.java.students.t030629.homework.base.utils.AthleteBuilder, ResultNormalizer)}
     * @throws net.azib.java.students.t030629.homework.base.utils.AthleteBuilder.IncompleteAthleteException if it is thrown in {@link #loadAthleteFromLine(String, net.azib.java.students.t030629.homework.base.utils.AthleteBuilder, ResultNormalizer)}
     * @throws net.azib.java.students.t030629.homework.base.utils.AthleteBuilder.UnsupportedCountryException if it is thrown in {@link #loadAthleteFromLine(String, net.azib.java.students.t030629.homework.base.utils.AthleteBuilder, ResultNormalizer)}
     */
    public static Athlete loadAthleteFromLine(String sourceLine) throws IOException, ParseException, AthleteBuilder.UnsupportedCountryException, AthleteBuilder.IncompleteAthleteException {
        Athlete athlete;
        try {
            athlete = loadAthleteFromLine(
                    sourceLine,
                    (AthleteBuilder) DEFAULT_ATHLETE_BUILDER_CLASS.newInstance(),
                    (ResultNormalizer) DEFAULT_RESULT_NORMALIZER_CLASS.newInstance()
            );
        } catch (Exception e) {
            throw new LoggingException(ERROR_LOADING_MESSAGE + e.getMessage(), LOG);
        }
        return athlete;
    }

    /**
     * {@inheritDoc}
     */
    public List<Athlete> getAthletes() {
        return athlets;
    }
}
