import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class Trainset {
    int id;
    static int count;
    Locomotive locomotive;
    List<RailroadCar> cars;
    private int loadedCarsWeight;
    private int connectedCarsCount;

    public Trainset(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.cars = new ArrayList<>();
        this.id = ++count;
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
}
