import java.util.List;

public abstract class RailroadCar {
    int id ;
    static int count = 0;
    protected boolean connectionRequired;
    int netWeight, grossWeight;
    protected boolean containsLoad;
    public String type;
    public static List<RailroadCar> carsList;
    public RailroadCar( int netWeight) {
        this.id = ++count;
        this.netWeight = netWeight;
        this.grossWeight = netWeight;
        this.connectionRequired = false;
        this.containsLoad = false;
    }
    public void addCarToList(){
        carsList.add(this);
    }
    public static void displayCarList(){
        System.out.println("created cars: ");
        for(RailroadCar car : carsList){
            System.out.println(car);
        }
    }
    @Override
    public String toString() {
        return this.type + "{ weight: " + this.grossWeight + " }";
    }
}
