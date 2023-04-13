import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class Trainset implements Runnable{
    int id;
    static int count;
    Locomotive locomotive;
    List<RailroadCar> cars;
    private int loadedCarsWeight;
    private int connectedCarsCount;
    private Route route;
    public boolean isWaiting;
    public Trainset(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.cars = new ArrayList<>();
        this.id = ++count;
        this.isWaiting = false;

    }
    @Override
    public void run(){

        while(true){

        }
    }
    public void checkLocSpeed()throws RailroadHazard{
        if(locomotive.speed > 200){
            throw new RailroadHazard(this);
        }
    }
    public void setRoute(Route route) {
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    @Override
    public String toString() {
        String s = "\n";
        for(int i = 0; i < cars.size(); i++){
            s += cars.get(i) + "\n";
        }
        return "Trainset { " +
                "id = " + id +
                ", " + locomotive +
                ", connected cars = " + s +
                '}';
    }

    public int getConnectedCarsCount() {
        return connectedCarsCount;
    }

    public void setConnectedCarsCount(int connectedCarsCount) {
        this.connectedCarsCount = connectedCarsCount;
    }

    public int getLoadedCarsWeight() {
        return loadedCarsWeight;
    }

    public void setLoadedCarsWeight(int loadedCarsWeight) {
        this.loadedCarsWeight = loadedCarsWeight;
    }

    public void addRRCar(RailroadCar car) throws ImpossibleToAddCar{
        if(this.cars.size() < locomotive.getMaxRRCarNumber()) {
            if (!car.containsLoad) {
                if (this.loadedCarsWeight + car.netWeight < locomotive.getMaxLoadWeight()) {
                    if (car.connectionRequired) {
                        if (this.connectedCarsCount < locomotive.getMaxElectricRRCarNumber()) {
                            cars.add(car);
                            cars.sort((car1, car2) -> car1.grossWeight - car2.grossWeight);
                            this.loadedCarsWeight += car.grossWeight;
                            this.connectedCarsCount++;
                            System.out.println("car is added successfully");
                        } else throw new ImpossibleToAddCar("exceeded number of electrical connections");
                    } else {
                        cars.add(car);
                        cars.sort((car1, car2) -> car1.grossWeight - car2.grossWeight);
                        this.loadedCarsWeight += car.grossWeight;
                        System.out.println("car is added successfully");
                    }
                } else throw new ImpossibleToAddCar("exceeded maximum weight");
            } else {
                if (this.loadedCarsWeight + car.netWeight < locomotive.getMaxLoadWeight()) {
                    if (car.connectionRequired) {
                        if (this.connectedCarsCount < locomotive.getMaxElectricRRCarNumber()) {
                            cars.add(car);
                            cars.sort((car1, car2) -> car1.grossWeight - car2.grossWeight);
                            this.loadedCarsWeight += car.netWeight;
                            this.connectedCarsCount++;
                            System.out.println("car is added successfully");
                        } else throw new ImpossibleToAddCar("exceeded number of electrical connections");
                    } else {
                        cars.add(car);
                        cars.sort((car1, car2) -> car1.grossWeight - car2.grossWeight);
                        this.loadedCarsWeight += car.grossWeight;
                        System.out.println("car is added successfully");
                    }
                } else throw new ImpossibleToAddCar("exceeded maximum weight");
            }
        }
        else throw new ImpossibleToAddCar("exceeded maximum number of cars in trainset");
    }
    public void discardRRCar(RailroadCar car) throws ImpossibleToDiscardCar{
        if(this.cars.size() == 0){
            throw new ImpossibleToDiscardCar("\terror: No cars are connected to the locomotive");
        }
        else {
            boolean isFound = false;
            for(int i = 0; i < cars.size(); i++){
                if(cars.get(i).equals(car)){
                    cars.remove(i);
                    isFound = true;
                    System.out.println("\tCar is discarded successfully.");
                    return;
                }
            }
            throw new ImpossibleToDiscardCar("\terror: Car is not found in this trainset.");
        }
    }
}
