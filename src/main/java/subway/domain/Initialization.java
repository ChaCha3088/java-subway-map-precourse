package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Initialization {
    LinkedHashMap<String, List<String>> initialSubwayInfo = new LinkedHashMap<>();

    public Initialization() {
        initialSubwayInfo.put("2호선", new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역")));
        initialSubwayInfo.put("3호선", new ArrayList<>(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")));
        initialSubwayInfo.put("신분당선", new ArrayList<>(Arrays.asList("강남역", "양재역", "양재시민의숲역")));
    }

    public LineRepository initializeLineRepository() {
        LineRepository lineRepository = new LineRepository();
        initialSubwayInfo.forEach((key, value)->{
            Line line = new Line(key);
            StationRepository stationRepository = new StationRepository();
            for (String station : value) { stationRepository.addStation(station); }
            line.addStationRepository(stationRepository);
            lineRepository.addLine(line);
        });
        return lineRepository;
    }

}
