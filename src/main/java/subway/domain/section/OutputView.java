package subway.domain.section;

public class OutputView {
    public static void sectionScreen() {
        System.out.println("## 구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기");
    }

    public static void inputPutLineName() {
        System.out.println("## 노선을 입력하세요.");
    }

    public static void inputPutStationName() {
        System.out.println("## 역이름을 입력하세요.");
    }

    public static void inputPutIndex() {
        System.out.println("## 순서를 입력하세요.");
    }

    public static void putStationInLineSuccess() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public static void putStationInLineFail() {
        System.out.println("[INFO] 구간 등록에 실패하였습니다.");
    }

    public static void pullStationOutFromLineLineName() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
    }

    public static void pullStationOutFromLineStationName() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
    }

    public static void pullStationOutFromLineSuccess() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public static void pullStationOutFromLineFail() {
        System.out.println("[INFO] 구간 삭제에 실패하였습니다.");
    }
}
