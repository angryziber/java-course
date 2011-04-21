package ee.ttu.decathlon.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvHolder {

    private static Map<Athlete, String> csvCache = new HashMap<Athlete, String>();

    public static void putCsvLine(Athlete a, List<String> athleteData) {
        csvCache.put(a, convertToCsvLine(athleteData));
    }

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
