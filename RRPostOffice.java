public class RRPostOffice extends RailroadCar{
    public RRPostOffice(int id, boolean connectionRequired, int netWeight, int grossWeight, boolean containsLoad) {
        super(id, connectionRequired, netWeight, grossWeight, containsLoad);
        this.connectionRequired = true;
    }
}
