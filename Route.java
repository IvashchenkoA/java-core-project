import java.util.*;

public class Route {
    public RailwayStation from;
    public RailwayStation to;
    List<RailwayStation> route;
    public int distance;

    public Route(RailwayStation from, RailwayStation to) {
        this.from = from;
        this.to = to;
        }
    public void setPath(){
        int distance = 0;
        Map<RailwayStation, Integer> neighbourStations = new HashMap<>();
        Map<RailwayStation, RailwayStation> previousStations = new HashMap<>();
        Set<RailwayStation> visited = new HashSet<>();
        PriorityQueue<RailwayStation> queue = new PriorityQueue<>(Comparator.comparingInt(neighbourStations::get));
        for (RailwayStation station : from.getNextStations().keySet()) {
            neighbourStations.put(station, from.getNextStations().get(station));
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

            for (RailwayStation neighbor : current.getNextStations().keySet()) {
                if (!visited.contains(neighbor)) {
                    distance = neighbourStations.get(current) + current.getNextStations().get(neighbor);
                    if (!neighbourStations.containsKey(neighbor) || distance < neighbourStations.get(neighbor)) {
                        neighbourStations.put(neighbor, distance);
                        previousStations.put(neighbor, current);
                        queue.offer(neighbor);
                    }
                }
               /*if(neighbor == this.to)
                   queue.clear();*/
            }
        }
        List<RailwayStation> path = new ArrayList<>();
        RailwayStation current = to;
        while (previousStations.containsKey(current)) {
            path.add(0, current);
            current = previousStations.get(current);
        }
        path.add(0, from);
        this.distance = distance;
        this.route = path;
    }
}
