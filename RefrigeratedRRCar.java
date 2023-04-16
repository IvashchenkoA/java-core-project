public class RefrigeratedRRCar extends RRFreightCar{
    public RefrigeratedRRCar( int netWeight) {
        super(netWeight);
        this.connectionRequired = true;
        this.type = "Refrigerated car";
    }
}
