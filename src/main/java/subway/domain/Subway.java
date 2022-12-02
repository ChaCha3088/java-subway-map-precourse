package subway.domain;

public class Subway {
    LineRepository lineRepository = new Initialization().initializeLineRepository();
    StationRepository stationRepository = new StationRepository();

    public Subway() {
        System.out.println(this.lineRepository.lines().get(0).getName());
    }

    public void registerStation(String name) {
        String result = stationRepository.findStation(name);
        if (result == null) {
            this.stationRepository.addStation(new Station(name));
        }
        if (result != null) {
            SubwayController.existAlready(result);
        }
    }
}
