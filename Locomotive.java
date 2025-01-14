import java.util.*;

public class Locomotive {
    public RailwayStation homeStation, sourceStation, destinationStation, currentStation;
    int id;
    static int count;
    public double speed;
    private final int maxRRCarNumber;
    private final int maxLoadWeight;
    private final int maxElectricRRCarNumber;
    public List<RailwayStation> route;
    public static List<Locomotive> locList = new ArrayList<>();
    public static RailwayStation[] arrayOfStations;


    public Locomotive(RailwayStation homeStation) {
        this.id = ++count;
        this.homeStation = homeStation;
        this.currentStation = homeStation;
        this.speed = 130 + Math.random()* 61;
        this.maxRRCarNumber = 10;
        this.maxElectricRRCarNumber = 10;
        this.maxLoadWeight = (int)(50 + Math.random() * 31);
    }
    public static void clearList(){
        locList.clear();
    }
    public synchronized void adjustSpeed() {
        if(Math.random() > 0.5)
            speed *= 1.03;
        else speed *= 0.97;
    }
    public static void setArrayOfStations(List<RailwayStation> list){
        arrayOfStations = new RailwayStation[list.size()];
        for(int i = 0; i < list.size(); i++){
            arrayOfStations[i] = list.get(i);
        }
    }
    public static void setArrayOfStations(RailwayStation[] a) {
        arrayOfStations = a;
    }
    public void addLocToList() {
        locList.add(this);
    }
    public static void displayLoclist() {
        System.out.println("created locomotives: ");
        for(Locomotive loc : locList){
            System.out.println(loc);
        }
    }

    public void setPath(RailwayStation from, RailwayStation to){
        Map<RailwayStation, Double> neighbourStations = new HashMap<>();
        Map<RailwayStation, RailwayStation> previousStations = new HashMap<>();
        Set<RailwayStation> visited = new HashSet<>();
        PriorityQueue<RailwayStation> queue = new PriorityQueue<>(Comparator.comparingDouble(neighbourStations::get));
        for (RailwayStation station : from.nextStation.keySet()) {
            neighbourStations.put(station, from.nextStation.get(station));
            previousStations.put(station, from);
            queue.offer(station);
        }
        neighbourStations.put(from, (double)0);
        visited.add(from);
        while (!queue.isEmpty()) {
            RailwayStation current = queue.poll();
            if (current == to) {
                break;
            }
            visited.add(current);
            for (RailwayStation neighbor : current.nextStation.keySet()) {
                if (!visited.contains(neighbor)) {
                    double distance = neighbourStations.get(current) + current.nextStation.get(neighbor);
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
    public double calcDistance(){
        double distance = 0;
        for(int i = 1; i < route.size(); i++)
            distance += route.get(i - 1).nextStation.get(route.get(i));
        return distance;
    }

    public void setSourceStation() {
        this.sourceStation = arrayOfStations[(int)(Math.random()*arrayOfStations.length)];
    }

    public void setDestinationStation() {
        this.destinationStation = arrayOfStations[(int)(Math.random()*arrayOfStations.length)];
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
