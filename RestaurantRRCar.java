public class RestaurantRRCar extends RailroadCar{
    public RestaurantRRCar(int netWeight) {
        super(netWeight);
        this.connectionRequired = true;
        this.type = "Restaurant car";
    }
}
