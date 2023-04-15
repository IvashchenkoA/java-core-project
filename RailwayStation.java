import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RailwayStation {
    public String name;
    public Map<RailwayStation, Integer> nextStation;
    public Queue<Trainset> trainQueue;
    public boolean isRestricted;
    public RailwayStation(String name) {
        this.name = name;
        this.nextStation = new HashMap<>();
        this.trainQueue = new LinkedList<>();
        this.isRestricted = false;
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
    public void addNextStation(RailwayStation station, int dist){
        nextStation.put(station,dist);
    }


    @Override
    public String toString() {
        return "RailwayStation {" +
                "name = '" + name + '\'' +
                '}';
    }
}
