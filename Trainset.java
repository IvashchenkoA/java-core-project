import java.util.List;
public class Trainset {
    int id;
    static int count;
    Locomotive locomotive;
    List<RailroadCar> cars;
    private int loadedCarsWeight;
    private int connectedCarsCount;

    public Trainset(Locomotive locomotive, List<RailroadCar> cars, int loadedCarsWeight, int connectedCarsCount) {
        this.locomotive = locomotive;
        this.cars = cars;
        this.loadedCarsWeight = loadedCarsWeight;
        this.connectedCarsCount = connectedCarsCount;
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

                            this.loadedCarsWeight += car.grossWeight;
                            this.connectedCarsCount++;
                        } else throw new ImpossibleToAddCar("exceeded number of electrical connections");
                    } else {
                        cars.add(car);
                        this.loadedCarsWeight += car.grossWeight;
                    }
                } else throw new ImpossibleToAddCar("exceeded maximum weight");
            } else {
                if (this.loadedCarsWeight + car.netWeight < locomotive.getMaxLoadWeight()) {
                    if (car.connectionRequired) {
                        if (this.connectedCarsCount < locomotive.getMaxElectricRRCarNumber()) {
                            cars.add(car);

                            this.loadedCarsWeight += car.netWeight;
                            this.connectedCarsCount++;
                        } else throw new ImpossibleToAddCar("exceeded number of electrical connections");
                    } else {
                        cars.add(car);
                        this.loadedCarsWeight += car.grossWeight;
                    }
                } else throw new ImpossibleToAddCar("exceeded maximum weight");
            }
        }
        else throw new ImpossibleToAddCar("exceeded maximum number of cars in trainset");
    }
}
