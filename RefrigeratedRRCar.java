public class RefrigeratedRRCar extends RRFreightCar{
    public RefrigeratedRRCar(boolean connectionRequired, int netWeight) {
        super(connectionRequired, netWeight);
        this.connectionRequired = true;
    }
}
