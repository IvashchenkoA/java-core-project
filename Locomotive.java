import java.util.*;

public class Locomotive {
    public RailwayStation homeStation, sourceStation, destinationStation, currentStation;
    private int id;
    static int count;
    public double speed;
    private final int maxRRCarNumber;
    private final int maxLoadWeight;
    private final int maxElectricRRCarNumber;
    public List<RailwayStation> route;
    public int distance = 0;

    public static RailwayStation[] arrayStations;


    public Locomotive(RailwayStation homeStation, RailwayStation[] a) {
        this.id = ++count;
        this.homeStation = homeStation;
        this.currentStation = homeStation;
        this.speed = 130 + Math.random()* 61;
        this.maxRRCarNumber = 10;
        this.maxElectricRRCarNumber = 10;//(int)(4 + Math.random()*5) ;
        this.maxLoadWeight = (int)(50 + Math.random() * 31);
        arrayStations = a;
    }

    public void adjustSpeed() {
        if(Math.random() > 0.5)
            speed *= 1.03;
        else speed *= 0.97;
    }

    public void setPath(RailwayStation from, RailwayStation to){
        Map<RailwayStation, Integer> neighbourStations = new HashMap<>();
        Map<RailwayStation, RailwayStation> previousStations = new HashMap<>();
        Set<RailwayStation> visited = new HashSet<>();
        PriorityQueue<RailwayStation> queue = new PriorityQueue<>(Comparator.comparingInt(neighbourStations::get));
        for (RailwayStation station : from.nextStation.keySet()) {
            neighbourStations.put(station, from.nextStation.get(station));
            previousStations.put(station, from);
            queue.offer(station);
        }
        neighbourStations.put(from, 0);
        visited.add(from);
        while (!queue.isEmpty()) {
            RailwayStation current = queue.poll();
            if (current == to) {
                break;
            }
            visited.add(current);

            for (RailwayStation neighbor : current.nextStation.keySet()) {
                if (!visited.contains(neighbor)) {
                    int distance = neighbourStations.get(current) + current.nextStation.get(neighbor);
                    if (!neighbourStations.containsKey(neighbor) || distance < neighbourStations.get(neighbor)) {
                        neighbourStations.put(neighbor, distance);
                        previousStations.put(neighbor, current);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        List<RailwayStation> path = new ArrayList<>();
        RailwayStation current = to;
        while (previousStations.containsKey(current)) {
            path.add(0, current);
            current = previousStations.get(current);
        }
        path.add(0, from);
        this.route = path;
    }
    public int calcDistance(){
        for(int i = 1; i < route.size(); i++)
            distance += route.get(i - 1).nextStation.get(route.get(i));
        return distance;
    }

    public void setSourceStation() {
        this.sourceStation = arrayStations[(int)(Math.random()*100)];
    }

    public void setDestinationStation() {
        this.destinationStation = arrayStations[(int)(Math.random()*100)];
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMaxRRCarNumber() {
        return maxRRCarNumber;
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public int getMaxElectricRRCarNumber() {
        return maxElectricRRCarNumber;
    }

    @Override
    public String toString() {
        return "Locomotive { " +
                "id=" + id +
                " }";
    }
}
