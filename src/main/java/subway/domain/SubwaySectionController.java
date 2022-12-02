package subway.domain;

public class SubwaySectionController {
    public SubwaySectionController() {
        String input = "0";
        while (!input.equals("B")) {
            OutputView.sectionScreen();
            input = SubwaySectionInputView.inputOptions();
            if (input.equals("1")) {
                putStationInLine(subway);
            }
            if (input.equals("2")) {
                pullStationOutFromLine(subway);
            }
        }
    }

    public void putStationInLine(Subway subway) {
        OutputView.
        Boolean result = subway.putStationInLine(
            SubwaySectionInputView.inputPutLineName(),
            SubwaySectionInputView.inputPutStationName(),
            SubwaySectionInputView.inputPutIndex());
        if (result) {
            OutputView.putSuccess(lineName);
        }
        OutputView.putFail(lineName);
    }

    public void pullStationOutFromLine(Subway subway) {
        OutputView.
        Boolean result = subway.pullStationOutFromLine(
            SubwaySectionInputView.inputPutLineName(),
            SubwaySectionInputView.inputPutStationName());
        if (result) {
            OutputView.pullSuccess(lineName);
        }
        OutputView.pullFail(lineName);
    }
}
