package subway.domain.station;

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

    public static Boolean putStationInLine(Integer index, String stationName) {
        try {
            Integer result = findStationByStationName(stationName);
            if (result == -1) {
                stations.add(index - 1, new Station(stationName));
                return true;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static Boolean pullStationOutFromLine(String stationName) {
        if (stations.size() <= 2) {
            return false;
        }
        Integer result = findStationByStationName(stationName);
        if (result == -1) {
            return false;
        }
        stations.remove(result);
        return true;
    }

}
