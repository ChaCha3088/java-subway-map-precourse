package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;

public class Subway {
    LineRepository lineRepository = new Initialization().initializeLineRepository();
    StationRepository stationRepository = new StationRepository();

    public Subway() {
    }

    public Boolean addStation(String stationName) {
        Boolean result = stationRepository.addStation(stationName);
        if (result) {
            return result;
        }
        return result;
    }

    public Boolean deleteStation(String stationName) {
        Boolean result = stationRepository.deleteStation(stationName);
        if (result) {
            return result;
        }
        return result;
    }

    public List<String> inquiryStations() {
        List<String> result = new ArrayList<>();
        lineRepository.lines().forEach(line -> {
            line.getStationRepository().stations().forEach(station -> {
                result.add(station.getName());
            });
        });
        stationRepository.stations().forEach(station -> {
            result.add(station.getName());
        });
        return result;
    }

    public Boolean addLine(String lineName, List<String> stationNames) {
        StationRepository newStationRepository = new StationRepository();
        for (String stationName : stationNames) {
            Boolean result = newStationRepository.addStation(stationName);
            if (!result) {
                return false;
            }
        }
        Line line = new Line(lineName);
        line.addStationRepository(newStationRepository);
        Boolean result = lineRepository.addLine(line);
        if (result) {
            return true;
        }
        return false;
    }

    public Boolean deleteLine(String lineName) {
        return lineRepository.deleteLineByLineName(lineName);
    }

    public List<String> inquiryLines() {
        List<String> result = new ArrayList<>();
        lineRepository.lines().forEach(line -> {
            result.add(line.getName());
        });
        return result;
    }

    public Boolean putStationInLine(String lineName, String stationName, Integer index) {
        return lineRepository.putStationInLine(lineName, stationName, index);
    }

    public Boolean pullStationOutFromLine(String lineName, String stationName) {
        return lineRepository.pullStationOutFromLine(lineName, stationName);
    }
}
