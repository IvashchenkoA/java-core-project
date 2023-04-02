public class Locomotive {
    private final String name;
    private RailwayStation HomeStation, SourceStation, DestinationStation;
    private final int id;
    static int count;
    double speed;
    private final int maxRRCarNumber;
    private final double maxLoadWeight;
    private final int maxElectricRRCarNumber;

    public Locomotive(String name, RailwayStation homeStation, RailwayStation sourceStation, RailwayStation destinationStation,
                      int id, double speed, int maxRRCarNumber, double maxLoadWeight, int maxElectricRRCarNumber) {
        this.name = name;
        HomeStation = homeStation;
        SourceStation = sourceStation;
        DestinationStation = destinationStation;
        this.id = ++count;
        this.speed = speed;
        this.maxRRCarNumber = maxRRCarNumber;
        this.maxLoadWeight = maxLoadWeight;
        this.maxElectricRRCarNumber = maxElectricRRCarNumber;
    }

    public void setHomeStation(RailwayStation homeStation) {
        HomeStation = homeStation;
    }

    public void setSourceStation(RailwayStation sourceStation) {
        SourceStation = sourceStation;
    }

    public void setDestinationStation(RailwayStation destinationStation) {
        DestinationStation = destinationStation;
    }

    public String getName() {
        return name;
    }

    public RailwayStation getHomeStation() {
        return HomeStation;
    }

    public RailwayStation getSourceStation() {
        return SourceStation;
    }

    public RailwayStation getDestinationStation() {
        return DestinationStation;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMaxRRCarNumber() {
        return maxRRCarNumber;
    }

    public double getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public int getMaxElectricRRCarNumber() {
        return maxElectricRRCarNumber;
    }
}
