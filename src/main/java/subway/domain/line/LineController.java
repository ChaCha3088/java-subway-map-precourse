package subway.domain.line;

import static subway.domain.line.InputView.inputLine;

import java.util.ArrayList;
import java.util.List;
import subway.InputView;
import subway.OutputView;
import subway.domain.Subway;

public class LineController {
    public LineController(Subway subwayClass) {
        String input = "0";
        while (!input.equals("B")) {
            subway.domain.line.OutputView.lineScreen();
            subway.OutputView.selectOptions();
            input = InputView.input();
            if (input.equals("1")) {
                Boolean result = addLine(subwayClass);
                if (result) {
                    input = "B";
                }
            }
            if (input.equals("2")) {
                Boolean result = deleteLine(subwayClass);
                if (result) {
                    input = "B";
                }
            }
            if (input.equals("3")) {
                inquiryLines(subwayClass);
                input = "B";
            }
        }
    }

    public Boolean addLine(Subway subwayClass) {
        subway.domain.line.OutputView.addLine();
        Boolean result = subwayClass.addLine(repeatInputLineName(), repeatInputStationNames());
        if (result) {
            subway.domain.line.OutputView.addLineSuccess();
            return result;
        }
        subway.domain.line.OutputView.addLineFail();
        return result;
    }

    public Boolean deleteLine(Subway subwayClass) {
        subway.domain.line.OutputView.deleteLine();
        Boolean result = subwayClass.deleteLine(repeatInputLineName());
        if (result) {
            subway.domain.line.OutputView.deleteLineSuccess();
            return result;
        }
        subway.domain.line.OutputView.deleteLineFail();
        return result;
    }

    public void inquiryLines(Subway subwayClass) {
        subway.domain.line.OutputView.inquiryLines();
        subway.domain.line.OutputView.inquiryLinesResult(subwayClass.inquiryLines());
    }

    public static String repeatInputLineName() {
        while (true) {
            try {
                String input = inputLine();
                if (input.length() < 2) {
                    throw new IllegalArgumentException("[ERROR] 지하철 노선 이름은 2글자 이상이어야 합니다.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.output("[ERROR] 지하철 노선 이름은 2글자 이상이어야 합니다.");
            }
        }
    }

    public static List<String> repeatInputStationNames() {
        while (true) {
            try {
                List<String> result = new ArrayList<>();
                subway.domain.line.OutputView.upperStation();
                result.add(InputView.input());
                subway.domain.line.OutputView.lowerStation();
                result.add(InputView.input());
                if (result.size() < 2) {
                    throw new IllegalArgumentException("[ERROR] 노선의 역은 최소 2개 이상이어야 합니다.");
                }
                for (String str : result) {
                    if (str.length() < 2) {
                        throw new IllegalArgumentException("[ERROR] 지하철 역 이름은 2글자 이상이어야 합니다.");
                    }
                }
                return result;
            } catch (IllegalArgumentException e) {
                OutputView.output("[ERROR] 지하철 역 이름은 2글자 이상, 노선의 역은 최소 2개 이상이어야 합니다.");
            }
        }
    }
}
