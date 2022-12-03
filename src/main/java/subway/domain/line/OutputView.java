package subway.domain.line;

import java.util.List;

public class OutputView {
    public static void lineScreen() {
        System.out.println("## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기");
    }

    public static void addLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
    }

    public static void addLineSuccess() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void addLineFail() {
        System.out.println("[ERROR] 지하철 노선 등록에 실패하였습니다.");
    }

    public static void deleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
    }

    public static void deleteLineSuccess() {
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public static void deleteLineFail() {
        System.out.println("[INFO] 지하철 노선이 삭제에 실패하였습니다.");
    }

    public static void inquiryLines() {
        System.out.println("## 노선 목록");
    }

    public static void inquiryLinesResult(List<String> input) {
        for (String str : input) {
            System.out.println("[INFO] "+str+"\n");
        }
    }

    public static void upperStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void lowerStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }
}
