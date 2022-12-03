package subway.domain.station;

import static subway.domain.line.InputView.inputLine;

import subway.InputView;
import subway.OutputView;
import subway.domain.Subway;

public class StationController {
    public StationController(Subway subwayClass) {
        String input = "0";
        while (!input.equals("B")) {
            subway.domain.station.OutputView.stationScreen();
            input = InputView.input();
            if (input.equals("1")) {
                Boolean result = addStation(subwayClass);
                if (result) {
                    input = "B";
                }
            }
            if (input.equals("2")) {
                Boolean result = deleteStation(subwayClass);
                if (result) {
                    input = "B";
                }
            }
            if (input.equals("3")) {
                inquiryStation(subwayClass);
                input = "B";
            }
        }
    }

    public Boolean addStation(Subway subwayClass) {
        subway.domain.station.OutputView.addStation();
        Boolean result = subwayClass.addStation(repeatInputStationName());
        if (result) {
            subway.domain.station.OutputView.addStationSuccess();
            return result;
        }
        subway.domain.station.OutputView.addStationFail();
        return result;
    }

    public Boolean deleteStation(Subway subwayClass) {
        subway.domain.station.OutputView.deleteStation();
        Boolean result = subwayClass.deleteStation(repeatInputStationName());
        if (result) {
            subway.domain.station.OutputView.deleteStationSuccess();
            return result;
        }
        subway.domain.station.OutputView.deleteStationFail();
        return result;
    }

    public void inquiryStation(Subway subwayClass) {
        subwayClass.inquiryStations();
    }

    public static String repeatInputStationName() {
        while (true) {
            try {
                String input = inputLine();
                if (input.length() < 2) {
                    throw new IllegalArgumentException("[ERROR] 지하철 역 이름은 2글자 이상이어야 합니다.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.output("[ERROR] 지하철 역 이름은 2글자 이상이어야 합니다.");
            }
        }
    }
}
