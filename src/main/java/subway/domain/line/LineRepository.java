package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Integer findLineByLineName(String lineName) {
        List<String> lineNames = new ArrayList<>();
        lines.forEach(line -> {
            lineNames.add(line.getName());
        });
        Integer result = lineNames.indexOf(lineName);
        return result;
    }

    public static Boolean addLine(Line line) {
        Integer result = findLineByLineName(line.getName());
        if (result == -1) {
            lines.add(line);
            return true;
        }
        return false;
    }

    public static Boolean deleteLineByLineName(String lineName) {
        return lines.removeIf(line -> Objects.equals(line.getName(), lineName));
    }

    public static Boolean deleteLineByStationName(String stationName) {
        return lines.removeIf(line -> Objects.equals(line.getName(), stationName));
    }

    public static Boolean putStationInLine(String lineName, String stationName, Integer index) {
        Integer lineResult = findLineByLineName(lineName);
        if (lineResult == -1) {
            return false;
        }
        Boolean stationResult = lines.get(lineResult).getStationRepository().putStationInLine(index, stationName);
        if (!stationResult) {
            return false;
        }
        return true;
    }

    public static Boolean pullStationOutFromLine(String lineName, String stationName) {
        Integer lineResult = findLineByLineName(lineName);
        if (lineResult == -1) {
            return false;
        }
        Boolean stationResult = lines.get(lineResult).getStationRepository().pullStationOutFromLine(stationName);
        if (!stationResult) {
            return false;
        }
        return true;
    }
}
