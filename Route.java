import java.util.ArrayList;
import java.util.List;

public class Route {
    public RailwayStation start;
    public RailwayStation end;
    List<RailwayStation> route;

    public Route(RailwayStation start, RailwayStation end) {
        this.start = start;
        this.end = end;
        route = setPath(start,end);
        }

}
