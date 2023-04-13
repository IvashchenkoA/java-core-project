public abstract class RailroadCar {
    int id ;
    static int count = 0;
    protected boolean connectionRequired;
    int netWeight, grossWeight;
    protected boolean containsLoad;
    public String type;
    public RailroadCar( int netWeight) {
        this.id = ++count;
        this.netWeight = netWeight;
        this.grossWeight = netWeight;
        this.connectionRequired = false;
        this.containsLoad = false;
    }

    @Override
    public String toString() {
        return this.type + "{ weight: }" + this.grossWeight;
    }
}
