package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static Boolean addStation(String stationName) {
        Integer result = findStationByStationName(stationName);
        if (result == -1) {
            stations.add(new Station(stationName));
            return true;
        }
        return false;
    }

    public static Boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Integer findStationByStationName(String stationName) {
        return stations.indexOf(stationName);
    }
}
