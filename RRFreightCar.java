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
        System.out.println("car is loaded");
    }
    public void unloadCar(){
        this.grossWeight = this.netWeight;
        this.containsLoad = false;
        System.out.println("car is unloaded");
    }
    public static RRFreightCar getCarById(int i){
        for(RailroadCar car : carsList){
            if(car.id == i)
                return (RRFreightCar) car;
        }
        return null;
    }
}
