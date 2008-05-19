package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;
import net.azib.java.students.t030629.homework.utils.QuietCloser;
import net.azib.java.students.t030629.homework.utils.LoggingException;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Logger;
import java.sql.*;
import java.math.BigDecimal;


/**
 * Class loads athletes from Database with the connection string specified in the
 * {@link #DEFAULT_DB_PROPERTIES_FILE_PATH}.
 * and proposes a set of static methods
 * for loading athletes from CSV lines *
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 16.05.2008
 * <br>Time: 14:22:55
 */
public class DBLoader implements AthleteLoader {
    private static final Logger LOG = Logger.getLogger(DBLoader.class.getName());

    private static final String ERROR_DB_PARAMETERS = "Erro loading/storing db System Parameters: \n";
    private static final String PROPERTY_FILE_COMMENT = "Properties for DBLoader containing default URL, USER and PASSWORD fields";

    private static final String MISSING_DB_PROPERTY_FILE_TEXT = "File with DB properties (db.properties) is missing";
    private static final String ERROR_LOADING_COMPETITION_ID_TEXT = "Error loading competition id with name=";
    private static final String ERROR_LOADING_PERSONAL_DATA_TEXT = "Error loading personal data with athlete_id=";

    private static final String DEFAULT_DB_PROPERTIES_FILE_PATH = "." + File.separator + ".." + File.separator + "db.properties";
    static final String URL_KEY = DBLoader.class.getName() + ".url";
    static final String USER_KEY = DBLoader.class.getName() + ".user";
    static final String PASSWORD_KEY = DBLoader.class.getName() + ".password";
    private static final String DEFAULT_URL_VALUE = "jdbc:mysql://srv.azib.net:3306/decathlon";
    private static final String DEFAULT_USER_VALUE = "java";
    private static final String DEFAULT_PASSWORD_VALUE = "java";

    int competitionId;

    private final AthleteBuilder athleteBuilder = new AthleteBuilder();
    private static ResultNormalizer normalizer = new DefaultNormalizer();
    private final List<Athlete> athletes = new LinkedList<Athlete>();

    /**
     * Private constructor for initialization of DB-related System Properties
     */
    private DBLoader() {
        try {
            InputStream propertyStream = DBLoader.class.getResourceAsStream(DEFAULT_DB_PROPERTIES_FILE_PATH);
            if (propertyStream != null) {
                /* Load Properties from the file */
                System.getProperties().load(propertyStream);

                /* If some property is missing, load the default value and save it back to file */
                boolean saveNeeded = false;
                if (System.getProperty(URL_KEY) == null) {
                    System.setProperty(URL_KEY, DEFAULT_URL_VALUE); saveNeeded = true;
                }
                if (System.getProperty(USER_KEY) == null) {
                    System.setProperty(USER_KEY, DEFAULT_USER_VALUE); saveNeeded = true;
                }
                if (System.getProperty(PASSWORD_KEY) == null) {
                    System.setProperty(PASSWORD_KEY, DEFAULT_PASSWORD_VALUE); saveNeeded = true;
                }
                if (saveNeeded) {
                    System.getProperties().store(
                            new FileOutputStream(new File(DBLoader.class.getResource(DEFAULT_DB_PROPERTIES_FILE_PATH).toURI())),
                            PROPERTY_FILE_COMMENT);
                }
            } else {
                throw new LoggingException(MISSING_DB_PROPERTY_FILE_TEXT, LOG);
            }
        } catch (Exception e) {
            throw new LoggingException(ERROR_LOADING_MESSAGE + ERROR_DB_PARAMETERS + e.getMessage(), LOG);
        }
    }

    /**
     * Contructor with DB competition NAME
     * @param competitionName name of the competition in database for what to load data
     */
    public DBLoader(String competitionName) {
        this();
        this.competitionId = getCompetitionId(competitionName);
    }

    /**
     * Constructor with DB competition ID
     * @param competitionId id of the competition in the database for what to load data
     */
    public DBLoader(int competitionId) {
        this();
        this.competitionId = competitionId;
    }

    /**
     * Method queries DB for the ID of the competition with the specified name
     * @param competitionName name of the competition to obtain ID for
     * @return id of the competition with the specified name
     */
    private int getCompetitionId(String competitionName) {
        Connection connection = null;
        RuntimeException errorLoadingNameException = new LoggingException(ERROR_LOADING_COMPETITION_ID_TEXT + competitionName, LOG);
        try {
            connection = openConnection();
            PreparedStatement statement = connection.prepareStatement("select * from competitions where name = ?");
            statement.setString(1, competitionName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            } else {
                throw errorLoadingNameException;
            }
        } catch (SQLException e) {
            throw errorLoadingNameException;
        } finally {
            QuietCloser.closeSilently(connection, LOG);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void load() {
        Connection connection = null;
        try {
            connection = openConnection();
            PreparedStatement resultQuery = connection.prepareStatement("select * from results where competition_id=?");
            resultQuery.setInt(1, competitionId);
            ResultSet results = resultQuery.executeQuery();
            while (results.next()) {
                /* Collect RESULTS */
                athleteBuilder.newAthlete();
                for (DecathlonEvent event : DecathlonEvent.values()) {
                    athleteBuilder.addResult(event, extractResultFor(event, results));
                }
                /* Collect PERSONAL DATA */
                int atheteId = results.getInt("athlete_id");
                PreparedStatement athleteQuery = connection.prepareStatement("select * from athletes where id=?");
                athleteQuery.setInt(1, atheteId);
                ResultSet personalData = athleteQuery.executeQuery();
                if (personalData.next()) {
                    athleteBuilder.addName(personalData.getString("name"));
                    athleteBuilder.addCountry(personalData.getString("country_code"));
                    athleteBuilder.addBirthday(personalData.getDate("dob"));
                } else {
                    throw new LoggingException(ERROR_LOADING_PERSONAL_DATA_TEXT + atheteId, LOG);
                }
                
                athletes.add(athleteBuilder.getAthlete());
            }

        } catch (Exception e) {
            throw new LoggingException(ERROR_LOADING_MESSAGE + e.getMessage(), LOG);
        } finally {
            QuietCloser.closeSilently(connection, LOG);
        }


    }

    /**
     * Extracts event result from {@link java.sql.ResultSet} and normalizes it 
     * using {@link net.azib.java.students.t030629.homework.io.DefaultNormalizer}
     * @param event for which to extract the result
     * @param results where to extract from
     * @return normalized result as {@link java.math.BigDecimal}
     * @throws SQLException if {@link java.sql.ResultSet#getString(String)} throws it
     */
    static BigDecimal extractResultFor(DecathlonEvent event, ResultSet results) throws SQLException {
        String columnLabel;
        switch (event) {
            case SPRINT_100M:
                columnLabel = "race_100m"; break;
            case SPRINT_400M:
                columnLabel = "race_400m"; break;
            default:
                columnLabel = event.name().toLowerCase(Locale.US);
        }
        String valueAsString = results.getString(columnLabel);
        return normalizer.normalize(event, new BigDecimal(valueAsString));
    }

    /**
     * {@inheritDoc}
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }

    /**
     * Opens connection to the db with the parameters specified in System Properties
     * with the following keys: {@link #URL_KEY}, {@link #PASSWORD_KEY} and {@link #USER_KEY}.
     * @return a connection to the URL
     * @throws SQLException if {@link java.sql.DriverManager#getConnection(String, String, String)} throws it
     */
    Connection openConnection() throws SQLException {
        return DriverManager.getConnection(System.getProperty(URL_KEY), System.getProperty(USER_KEY), System.getProperty(PASSWORD_KEY));
    }

}
