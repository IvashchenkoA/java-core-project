public class RRPostOffice extends RailroadCar{
    public RRPostOffice(boolean connectionRequired, int netWeight) {
        super(connectionRequired, netWeight);
        this.connectionRequired = true;
    }
}
