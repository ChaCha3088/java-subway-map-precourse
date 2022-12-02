package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Boolean findLineByLineName(String lineName) {
        List<String> lineNames = new ArrayList<>();
        lines.forEach(line -> {
            lineNames.add(line.getName());
        });
        Integer result = lineNames.indexOf(lineName);
        if (result == -1) { return false; }
        return true;
    }

    public static Boolean addLine(Line line) {
        Boolean result = findLineByLineName(line.getName());
        if (!result) {
            SubwayController.addSuccess(line.getName());
            lines.add(line);
            return true;
        }
        if (result) {
            SubwayController.addFail(line.getName());
            return false;
        }
        return false;
    }

    public static Boolean deleteLineByStationName(String stationName) {
        return lines.removeIf(line -> Objects.equals(line.getName(), stationName));
    }
}
