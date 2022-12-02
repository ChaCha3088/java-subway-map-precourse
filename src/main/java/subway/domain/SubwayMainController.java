package subway.domain;

import subway.InputView;

public class SubwayMainController {
    public SubwayMainController(Subway subway) {
        String input = "0";
        while (!input.equals("Q")) {
            OutputView.mainScreen();
            input = InputView.inputOptions();
            if (input.equals("1")) {
                new SubwayStationController(subway);
            }
            if (input.equals("2")) {
                new SubwayLineController(subway);
            }
            if (input.equals("3")) {
                new SubwaySectionController();
            }
            if (input.equals("4")) {
                new SubwayMapController();
            }
        }
    }
}
