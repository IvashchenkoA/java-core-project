public class HeavyRRFreightCar extends RailroadCar{
    public HeavyRRFreightCar(boolean connectionRequired, int netWeight) {
        super( connectionRequired, netWeight);
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
