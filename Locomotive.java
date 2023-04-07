public class Locomotive {
    String name;
    RailwayStation HomeStation, SourceStation, DestinationStation;
    private final int id;
    static int count;
    double speed;
    private int maxRRCarNumber;
    private int maxLoadWeight;
    private int maxElectricRRCarNumber;

    public Locomotive(String name) {
        this.name = name;
        this.id = ++count;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void adjustSpeed(){
        if(Math.random() > 0.5)
            speed *= 1.03;
        else speed *= 0.97;
    }

    public void setMaxRRCarNumber(int maxRRCarNumber) {
        this.maxRRCarNumber = maxRRCarNumber;
    }

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public void setMaxElectricRRCarNumber(int maxElectricRRCarNumber) {
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

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public int getMaxElectricRRCarNumber() {
        return maxElectricRRCarNumber;
    }
}
