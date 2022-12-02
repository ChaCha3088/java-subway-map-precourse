package subway.domain;

public class SubwayStationController {
    public SubwayStationController(Subway subway) {
        String input = "0";
        while (!input.equals("B")) {
            OutputView.stationScreen();
            input = SubwayStationInputView.inputOptions();
            if (input.equals("1")) {
                addStation(subway);
            }
            if (input.equals("2")) {
                deleteStation(subway);
            }
            if (input.equals("3")) {
                inquiryStation(subway);
            }
        }
    }

    public void addStation(Subway subway) {
        OutputView.
        Boolean result = subway.addStation(SubwayStationInputView.inputAddStation());
        if (result) {
            OutputView.addSuccess();
        }
        OutputView.addFail();
    }

    public void deleteStation(Subway subway) {
        OutputView.
        Boolean result = subway.deleteStation(SubwayStationInputView.inputDeleteStation());
        if (result) {
            OutputView.deleteSuccess();
        }
        OutputView.deleteFail();
    }

    public void inquiryStation(Subway subway) {
        subway.inquiryStations();
    }
}
