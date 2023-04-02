public class PassengerRRCar extends RailroadCar{
    private int numOfSeats;

    public PassengerRRCar(int id, boolean connectionRequired, int netWeight, int grossWeight, int numOfSeats, boolean containsLoad) {
        super(id, connectionRequired, netWeight, grossWeight,containsLoad);
        this.numOfSeats = numOfSeats;
        this.connectionRequired = true;
    }
}
