package subway.domain.section;

import static java.lang.Integer.parseInt;

import subway.InputView;
import subway.domain.Subway;
import subway.domain.line.LineController;
import subway.domain.station.StationController;

public class SectionController {
    public SectionController(Subway subwayClass) {
        String input = "0";
        while (!input.equals("B")) {
            OutputView.sectionScreen();
            subway.OutputView.selectOptions();
            input = InputView.input();
            if (input.equals("1")) {
                Boolean result = putStationInLine(subwayClass);
                if (result) {
                    input = "B";
                }
            }
            if (input.equals("2")) {
                Boolean result = pullStationOutFromLine(subwayClass);
                if (result) {
                    input = "B";
                }
            }
        }
    }

    public Boolean putStationInLine(Subway subwayClass) {
        OutputView.inputPutLineName();
        OutputView.inputPutStationName();
        OutputView.inputPutIndex();
        Boolean result = subwayClass.putStationInLine(
                LineController.repeatInputLineName(),
                StationController.repeatInputStationName(),
                repeatInputIndex());
        if (result) {
            OutputView.putStationInLineSuccess();
            return result;
        }
        OutputView.putStationInLineFail();
        return result;
    }

    public Boolean pullStationOutFromLine(Subway subwayClass) {
        OutputView.pullStationOutFromLineLineName();
        OutputView.pullStationOutFromLineStationName();
        Boolean result = subwayClass.pullStationOutFromLine(
                LineController.repeatInputLineName(),
                StationController.repeatInputStationName());
        if (result) {
            OutputView.pullStationOutFromLineSuccess();
            return result;
        }
        OutputView.pullStationOutFromLineFail();
        return result;
    }

    public static Integer repeatInputIndex() {
        while (true) {
            try {
                Integer input = parseInt(InputView.input());
                return input;
            } catch (NumberFormatException e) {
                subway.OutputView.output("[ERROR] 순서는 정수를 입력해야 합니다.");
            }
        }
    }
}
