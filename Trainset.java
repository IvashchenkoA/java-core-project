import java.util.ArrayList;
import java.util.List;

public class Trainset extends Thread{
    int id;
    static int count;
    Locomotive locomotive;
    List<RailroadCar> cars;
    private int loadedCarsWeight;
    private int connectedCarsCount;
    public boolean isWaiting;
    public int movedDistance;
  //  public Thread threadMain;

    public Trainset(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.cars = new ArrayList<>();
        this.id = ++count;
        this.isWaiting = false;
      //  this.threadMain = new Thread();
    }
    @Override
    public void run(){
        while(!Thread.interrupted()){
            this.locomotive.setSourceStation();
            this.locomotive.setDestinationStation();
            if(locomotive.currentStation == locomotive.destinationStation){
                System.out.println("The train " + this.id + "reached it's final destination: "
                        + locomotive.currentStation);
                Thread30 thread30 = new Thread30();
                thread30.start();
                try {
                    thread30.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.locomotive.setPath(this.locomotive.destinationStation, this.locomotive.homeStation);
            }
            else if (this.locomotive.sourceStation != this.locomotive.homeStation) {
                this.locomotive.setPath(locomotive.sourceStation, locomotive.destinationStation);
                List<RailwayStation> tmpList = new ArrayList<>();
                tmpList = this.locomotive.route;
                this.locomotive.setPath(locomotive.homeStation, locomotive.sourceStation);
                this.locomotive.route.addAll(tmpList);
            }
            else {
                this.locomotive.setPath(locomotive.sourceStation, locomotive.destinationStation);
            }
            for(int i = 1; i < this.locomotive.route.size(); i++){
                this.locomotive.currentStation = this.locomotive.route.get(i-1);
                if(this.locomotive.currentStation.isRestricted){
                    this.locomotive.currentStation.addTrainToQueue(this);
                    while(this.locomotive.currentStation.isRestricted){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else{
                    this.locomotive.currentStation.isRestricted = true;
                    int currentDist = this.locomotive.currentStation.getNextStations().get(locomotive.route.get(i));
                    while(currentDist > 0){
                        currentDist -= this.locomotive.speed;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Trainset " + this.id + " current station: " + this.locomotive.currentStation.name);
                    this.movedDistance += currentDist;
                    Thread2 thread2 = new Thread2();
                    thread2.start();
                    try {
                        thread2.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void checkLocSpeed()throws RailroadHazard{
        if(locomotive.speed > 200){
            throw new RailroadHazard(this);
        }
    }

    /*public void moveTrainSet(RailwayStation from, RailwayStation to){
        int distance = from.getNextStations().get(to);
        distance -=
     }*/
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
