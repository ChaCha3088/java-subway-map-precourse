package subway.domain.station;

public class OutputView {
    public static void stationScreen() {
        System.out.println("## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기");
    }

    public static void addStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public static void addStationSuccess() {
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public static void addStationFail() {
        System.out.println("[INFO] 지하철 역 등록에 실패하였습니다.");
    }

    public static void deleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

    public static void deleteStationSuccess() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public static void deleteStationFail() {
        System.out.println("[INFO] 지하철 역 삭제에 실패하였습니다.");
    }
}
