public class RestaurantRRCar extends RailroadCar{
    public RestaurantRRCar(boolean connectionRequired, int netWeight) {
        super(netWeight);
        this.connectionRequired = true;
        this.type = "Restaurant car";
    }
}
