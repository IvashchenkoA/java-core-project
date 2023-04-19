public class RRFreightCar extends RailroadCar{
    public int maxWeightToCarry;
    public RRFreightCar( int netWeight) {
        super( netWeight);
        this.maxWeightToCarry =(int)(1 + Math.random()*4);
        this.type = "Basic freight car";
    }
    public void loadCar(){
        this.grossWeight += this.maxWeightToCarry;
        this.containsLoad = true;
    }
    public void unloadCar(){
        this.grossWeight = this.netWeight;
        this.containsLoad = false;
    }
}
