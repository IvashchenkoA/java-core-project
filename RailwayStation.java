import java.util.*;

public class RailwayStation {
    public String name;
    public Map<RailwayStation, Double> nextStation;
    public Queue<Trainset> trainQueue;
    public boolean isRestricted;
    public static List<RailwayStation> stationsList = new ArrayList<>();
    public RailwayStation(String name) {
        this.name = name;
        this.nextStation = new HashMap<>();
        this.trainQueue = new LinkedList<>();
        this.isRestricted = false;
    }
    public void addStationToList(){
        stationsList.add(this);
    }
    public static void displayCreatedStations() {
        System.out.println("created stations: ");
        for(RailwayStation station : stationsList){
            System.out.print(station.toString() + "\n ");
        }
        System.out.println();
    }
    public synchronized void addTrainToQueue(Trainset trset) {
        trainQueue.offer(trset);
    }

    public synchronized void removeTrainFromQueue() {
        trainQueue.poll();
    }

    public synchronized Trainset getTrainFromQueue() {
        return trainQueue.peek();
    }
    public void addNextStation(RailwayStation station, double dist){
        nextStation.put(station,dist);
    }
    public static RailwayStation getStationByName(String name){
        for(RailwayStation station : stationsList){
            if(station.name.equals(name)){
                return station;
            }
        }
        return null;
    }
    public static void clearList(){
        stationsList.clear();
    }

    @Override
    public String toString() {
        return "RailwayStation {" +
                "name = '" + name + '\'' +
                '}';
    }
}
