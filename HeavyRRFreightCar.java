public class HeavyRRFreightCar extends RRFreightCar{
    public int maxWeightToCarry;
    public HeavyRRFreightCar( int netWeight) {
        super(netWeight);
        this.maxWeightToCarry = (int)(3 + Math.random()*5);
        this.type = "Heavy freight car";
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
