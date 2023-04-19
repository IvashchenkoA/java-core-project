import java.util.ArrayList;
import java.util.List;

public abstract class RailroadCar {
    int id ;
    static int count = 0;
    protected boolean connectionRequired;
    int netWeight, grossWeight;
    protected boolean containsLoad;
    public String type;
    public static List<RailroadCar> carsList = new ArrayList<>();
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
    public static RailroadCar getCarById(int id){
        for(RailroadCar car : carsList){
            if(car.id == id){
                return car;
            }
        }
        return null;
    }
    public void removeCar(){
        carsList.remove(this);
    }
    public static void clearList(){
        carsList.clear();
    }
    public static void displayCarList(){
        System.out.println("created cars: ");
        for(RailroadCar car : carsList){
            System.out.println(car.toString());
        }
    }

    @Override
    public String toString() {
        return this.type +" id:  "+this.id + " { weight: " + this.grossWeight + " }";
    }

}
