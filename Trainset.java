import java.util.ArrayList;
import java.util.List;

public class Trainset extends Thread{
    int id;
    static int count;
    public Locomotive locomotive;
    List<RailroadCar> cars;
    public int loadedCarsWeight;
    public int connectedCarsCount;
    public boolean isWaiting;
    public int movedDistance;
  //  public Thread threadMain;

    public Trainset(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.cars = new ArrayList<>();
        this.id = ++count;
        this.isWaiting = false;

        Thread thread = new Thread(() -> {
            while(!Thread.interrupted()){
                locomotive.adjustSpeed();
                checkLocSpeed();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
    @Override
    public void run(){
        while(!Thread.interrupted()){
            this.locomotive.setSourceStation();
            this.locomotive.setDestinationStation();
            if(this.locomotive.currentStation == this.locomotive.destinationStation){
                System.out.println("The train " + this.id + " reached it's final destination: "
                        + this.locomotive.currentStation.name + " speed: " + this.locomotive.speed + "\n");
                Thread30 thread30 = new Thread30();
                thread30.start();
                try {
                    thread30.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                this.locomotive.setPath(this.locomotive.sourceStation, this.locomotive.destinationStation);
                if (this.locomotive.sourceStation != this.locomotive.homeStation) {
                    List<RailwayStation> tmpList;
                    tmpList = this.locomotive.route;
                    this.locomotive.setPath(this.locomotive.homeStation, this.locomotive.sourceStation);
                    this.locomotive.route.remove(locomotive.route.size() - 1);
                    this.locomotive.route.addAll(tmpList);
                }
                moveTrainSet();
            }
            if(this.locomotive.currentStation != this.locomotive.homeStation){
                this.locomotive.setPath(this.locomotive.currentStation, this.locomotive.homeStation);
                moveTrainSet();
            }
        }
    }

    public void checkLocSpeed()throws RailroadHazard{
        if(locomotive.speed > 200){
            throw new RailroadHazard(this);
        }
    }

    public synchronized void  moveTrainSet(){
        for(int i = 1; i < this.locomotive.route.size(); i++){
            this.locomotive.currentStation = this.locomotive.route.get(i-1);
            System.out.println("The train " + this.id + ", current station: " + this.locomotive.currentStation.name
            + ", speed: " + this.locomotive.speed + "\n");
            if(this.locomotive.currentStation.isRestricted){
                this.locomotive.currentStation.addTrainToQueue(this);
                while(this.locomotive.currentStation.isRestricted || this.locomotive.currentStation.getTrainFromQueue() != this){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.locomotive.currentStation.removeTrainFromQueue();
            }
            this.locomotive.currentStation.isRestricted = true;
            int currentDist = this.locomotive.currentStation.nextStation.get(locomotive.route.get(i));
            while(currentDist > 0){
                currentDist -= (this.locomotive.speed/360);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.movedDistance += currentDist;
            Thread2 thread2 = new Thread2();
            thread2.start();
            try {
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.locomotive.currentStation.isRestricted = false;
        }
        this.locomotive.currentStation = this.locomotive.destinationStation;
        System.out.println("The train " + this.id + " reached it's final destination: "
                + this.locomotive.currentStation.name + " speed: " + this.locomotive.speed + "\n");
        Thread30 thread30 = new Thread30();
        thread30.start();
        try {
            thread30.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
     }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n");
        for (RailroadCar car : cars) {
            s.append(car).append("\n");
        }
        return "Trainset { " +
                "id = " + id +
                ", " + locomotive +
                ", connected cars = " + s +
                '}';
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
                        } else throw new ImpossibleToAddCar("exceeded number of electrical connections");
                    } else {
                        cars.add(car);
                        cars.sort((car1, car2) -> car1.grossWeight - car2.grossWeight);
                        this.loadedCarsWeight += car.grossWeight;
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

                        } else throw new ImpossibleToAddCar("exceeded number of electrical connections");
                    } else {
                        cars.add(car);
                        cars.sort((car1, car2) -> car1.grossWeight - car2.grossWeight);
                        this.loadedCarsWeight += car.grossWeight;

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
