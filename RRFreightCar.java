public class RRFreightCar extends RailroadCar{
    public RRFreightCar( int netWeight) {
        super( netWeight);
        this.type = "Basic freight car";
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
