public class RRFreightCar extends RailroadCar{
    public RRFreightCar(boolean connectionRequired, int netWeight) {
        super(connectionRequired, netWeight);
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
