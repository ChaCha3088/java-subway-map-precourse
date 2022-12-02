package subway.domain;

public class SubwayLineController {
    public SubwayLineController() {
        String input = "0";
        while (!input.equals("B")) {
            OutputView.lineScreen();
            input = SubwayLineInputView.inputOptions();
            if (input.equals("1")) {
                addLine(subway);
            }
            if (input.equals("2")) {
                deleteLine(subway);
            }
            if (input.equals("3")) {
                inquiryLines(subway);
            }
        }
    }

    public void addLine(Subway subway) {
        OutputView.
        Boolean result = subway.addLine(SubwayLineInputView.inputAddLine());
        if (result) {
            OutputView.addSuccess(lineName);
        }
        OutputView.addFail(lineName);
    }

    public void deleteLine(Subway subway) {
        OutputView.
        Boolean result = subway.deleteLine(SubwayLineInputView.inputAddLine());
        if (result) {
            OutputView.deleteSuccess(lineName);
        }
        OutputView.deleteFail(lineName);
    }

    public void inquiryLines(Subway subway) {
        OutputView.
        Boolean result = subway.inquiryLines();
    }
}
