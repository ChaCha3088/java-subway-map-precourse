package subway.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class Line {
    private String name;
    private StationRepository stationRepository;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
}
