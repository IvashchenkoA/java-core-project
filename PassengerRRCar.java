public class PassengerRRCar extends RailroadCar{
    public int numOfSeats;

    public PassengerRRCar(boolean connectionRequired, int netWeight, int numOfSeats) {
        super(connectionRequired, netWeight);
        this.numOfSeats = numOfSeats;
        this.connectionRequired = true;
    }
}
