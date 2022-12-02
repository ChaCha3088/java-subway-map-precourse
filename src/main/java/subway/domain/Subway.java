package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Subway {
    LineRepository lineRepository = new Initialization().initializeLineRepository();
    StationRepository stationRepository = new StationRepository();

    public Subway() {
        System.out.println(this.lineRepository.lines().get(0).getName());
    }

    public void addStation(String name) {
        Boolean result = stationRepository.addStation(name);
        if (result) {
            SubwayController.addSuccess(name);
        }
        SubwayController.addFail(name);
    }

    public void deleteStation(String name) {
        Boolean result = stationRepository.deleteStation(name);
        if (result) {
            SubwayController.deleteSuccess(name);
        }
        SubwayController.deleteFail(name);
    }

    public void inquiryStations() {
        List<String> result = new ArrayList<>();
        lineRepository.lines().forEach(line -> {
            result.add(line.getName());
        });
        stationRepository.stations().forEach(station -> {
            result.add(station.getName());
        });
    }
}
