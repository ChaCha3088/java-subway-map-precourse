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

    public static Boolean addStation(String name) {
        Integer result = stations.indexOf(name);
        if (result == -1) {
            stations.add(new Station(name));
            return true;
        }
        return false;
    }

    public static Boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
