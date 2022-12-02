package subway.domain;

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
}
