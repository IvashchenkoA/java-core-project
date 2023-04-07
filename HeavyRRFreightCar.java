public class HeavyRRFreightCar extends RailroadCar{
    public HeavyRRFreightCar( int netWeight) {
        super(netWeight);
    }
    public void loadCar(double loadWeight){
        this.grossWeight += loadWeight;
        this.containsLoad = true;
    }
    public void unloadCar(){
        this.grossWeight = this.netWeight;
        this.containsLoad = false;
    }
}
