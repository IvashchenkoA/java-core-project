public class RRPostOffice extends RailroadCar{
    public RRPostOffice(int netWeight) {
        super(netWeight);
        this.connectionRequired = true;
        this.type = "Railroad Post Office";
    }

}
