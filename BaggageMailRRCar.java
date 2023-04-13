import java.util.List;

public class BaggageMailRRCar extends RailroadCar{
    private int maxMailNum;
    private int maxBaggageWeight;
    List<Shipment> ships;
    class Shipment{
        int weight;
    }
    public BaggageMailRRCar(int netWeight) {
        super(netWeight);
        this.type = "Baggage and Mail Car";
    }


    public void setMaxBaggageWeight(int maxBaggageWeight) {
        this.maxBaggageWeight = maxBaggageWeight;
    }

    public void setMaxMailNum(int maxMailNum) {
        this.maxMailNum = maxMailNum;
    }

    public int getMaxMailNum() {
        return maxMailNum;
    }

    public int getMaxBaggageWeight() {
        return maxBaggageWeight;
    }

}
