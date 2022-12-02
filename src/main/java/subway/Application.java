package subway;

import subway.domain.Subway;
import subway.domain.SubwayMainController;

public class Application {
    public static void main(String[] args) {
        Subway subway = new Subway();
        new SubwayMainController(subway);
    }
}
