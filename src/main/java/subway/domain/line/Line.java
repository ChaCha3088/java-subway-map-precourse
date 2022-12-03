package subway.domain.line;

import subway.domain.station.StationRepository;

public class Line {
    private String name;
    private StationRepository stationRepository;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StationRepository getStationRepository() {
        return this.stationRepository;
    }

    public void addStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
}
