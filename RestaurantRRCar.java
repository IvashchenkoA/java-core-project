public class RestaurantRRCar extends RailroadCar{
    public RestaurantRRCar(boolean connectionRequired, int netWeight) {
        super(connectionRequired, netWeight);
        this.connectionRequired = true;
    }
}
