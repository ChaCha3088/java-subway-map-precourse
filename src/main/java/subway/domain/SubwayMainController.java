package subway.domain;

import subway.InputView;
import subway.OutputView;
import subway.domain.line.LineController;
import subway.domain.section.SectionController;
import subway.domain.station.StationController;

public class SubwayMainController {
    public SubwayMainController(Subway subway) {
        String input = "0";
        while (!input.equals("Q")) {
            OutputView.mainScreen();
            OutputView.selectOptions();
            input = InputView.input();
            if (input.equals("1")) {
                new StationController(subway);
            }
            if (input.equals("2")) {
                new LineController(subway);
            }
            if (input.equals("3")) {
                new SectionController(subway);
            }
//            if (input.equals("4")) {
//                new SubwayMapController();
//            }
        }
    }
}
