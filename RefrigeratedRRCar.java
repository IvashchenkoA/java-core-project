public class RefrigeratedRRCar extends RRFreightCar{
    public RefrigeratedRRCar(boolean connectionRequired, int netWeight) {
        super(netWeight);
        this.connectionRequired = true;
    }
}
