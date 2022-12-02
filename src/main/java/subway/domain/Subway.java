package subway.domain;

public class Subway {

    public Subway() {
        LineRepository initialLineRepository = new Initialization().initializeLineRepository();
        System.out.println(initialLineRepository.lines().get(0).getName());
    }
}
