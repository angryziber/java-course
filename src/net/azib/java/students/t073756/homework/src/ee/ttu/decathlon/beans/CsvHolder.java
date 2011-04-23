package ee.ttu.decathlon.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class represents storage for csv strings,
 * as this data is immutable and can be reused later in output.
 * //todo probably no need to hold if output is not csv
 */
public class CsvHolder {

    private static Map<Athlete, String> csvCache = new HashMap<Athlete, String>();

    /**
     * Converts list of athlete data to csv string and saves it for future
     * @param a Athlete for whom data is saved
     * @param athleteData data which will be converted to csv string
     */
    public static void putCsvLine(Athlete a, List<String> athleteData) {
        csvCache.put(a, convertToCsvLine(athleteData));
    }

    /**
     * Retrieve csv string back from storage
     * @param a Athlete for whom data is searched
     * @return csv string with data about this Athlete results.
     */
    public static String getCsvLine(Athlete a) {
        return csvCache.get(a);
    }

    private static String convertToCsvLine(List<String> athleteData) {
        StringBuilder result = new StringBuilder();
        for (String s : athleteData.subList(1, athleteData.size() - 1)) {
            result.append(s).append(" ");
        }
        return athleteData.get(0) + "," + result.toString().trim().replaceAll(" ", ",");
    }

}
