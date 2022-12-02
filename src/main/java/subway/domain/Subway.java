package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Subway {
    LineRepository lineRepository = new Initialization().initializeLineRepository();
    StationRepository stationRepository = new StationRepository();

    public Subway() {
        System.out.println(this.lineRepository.lines().get(0).getName());
    }

    public void addStation(String stationName) {
        Boolean result = stationRepository.addStation(stationName);
        if (result) {
            SubwayController.addSuccess(stationName);
        }
        SubwayController.addFail(stationName);
    }

    public void deleteStation(String stationName) {
        Boolean result = stationRepository.deleteStation(stationName);
        if (result) {
            SubwayController.deleteSuccess(stationName);
        }
        SubwayController.deleteFail(stationName);
    }

    public void inquiryStations() {
        List<String> result = new ArrayList<>();
        lineRepository.lines().forEach(line -> {
            line.getStationRepository().stations().forEach(station -> {
                result.add(station.getName());
            });
        });
        stationRepository.stations().forEach(station -> {
            result.add(station.getName());
        });
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
            SubwayController.addSuccess(lineName);
            return true;
        }
        SubwayController.addFail(lineName);
        return false;
    }

    public Boolean deleteLine(String lineName) {
        return lineRepository.deleteLineByLineName(lineName);
    }

    public void inquiryLines() {
        List<String> result = new ArrayList<>();
        lineRepository.lines().forEach(line -> {
            result.add(line.getName());
        });
    }

    public Boolean putInLine(String lineName, String stationName, Integer index) {
        return lineRepository.putInLine(lineName, stationName, index);
    }
}
