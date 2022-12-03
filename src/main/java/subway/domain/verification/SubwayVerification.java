package subway.domain.verification;

public class SubwayVerification {
    public static String verifyStationName(String stationName) {
        if (stationName.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 지하철 역 이름은 2글자 이상이어야 한다.");
        }
        return stationName;
    }
}
