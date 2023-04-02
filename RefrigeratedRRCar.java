public class RefrigeratedRRCar extends RRFreightCar{
    public RefrigeratedRRCar(int id, boolean connectionRequired, int netWeight, int grossWeight, boolean containsLoad) {
        super(id, connectionRequired, netWeight, grossWeight, containsLoad);
        this.connectionRequired = true;
    }
}
