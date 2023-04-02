public abstract class RailroadCar {
    int id ;
    static int count = 0;
    protected boolean connectionRequired;
    int netWeight, grossWeight;
    protected boolean containsLoad;
    public RailroadCar(int id,boolean connectionRequired, int netWeight, int grossWeight, boolean containsLoad) {
        this.id = ++count;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.connectionRequired = false;
        this.containsLoad = false;
    }
}
