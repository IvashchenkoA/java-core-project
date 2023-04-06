import java.util.HashMap;
import java.util.Map;

public class RailwayStation {
    String name;
    Map<RailwayStation, Integer> nextStation;
    public RailwayStation(String name) {
        this.name = name;
        this.nextStation = new HashMap<>();
    }
    public void addNextStation(RailwayStation station, int dist){
        nextStation.put(station,dist);
    }
    public Map<RailwayStation, Integer> getNextStations(){
        return nextStation;
    }

    @Override
    public String toString() {
        return "RailwayStation{" +
                "name='" + name + '\'' +
                '}';
    }
}
