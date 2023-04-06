public class Main {
    public static void main(String[] args) {
        RailwayStation station1 = new RailwayStation("Kharkiv");
        RailwayStation station2 = new RailwayStation("Dnipro");
        RailwayStation station3 = new RailwayStation("Poltava");
        RailwayStation station4 = new RailwayStation("Kropivnytski");
        RailwayStation station5 = new RailwayStation("Uman");
        RailwayStation station6 = new RailwayStation("Kyiv");
        RailwayStation station7 = new RailwayStation("Chernyhiv");


        station1.addNextStation(station3, 9);
        station1.addNextStation(station2,10);
        station2.addNextStation(station4,3);
        station3.addNextStation(station5, 2);
        station4.addNextStation(station6, 5);
        station5.addNextStation(station6, 10);
        station5.addNextStation(station7, 30);
        station6.addNextStation(station7, 15);

        Route route1_6 = new Route(station1, station6);
        route1_6.setPath();
        System.out.println(route1_6.route);
        System.out.println(route1_6.distance);

        Route route1_5 = new Route(station1, station5);
        route1_5.setPath();
        System.out.println(route1_5.route);
        System.out.println(route1_5.distance);

     /*   RailwayStation station1 = new RailwayStation("Nastya1");
        RailwayStation station2 = new RailwayStation("Nastya2");
        RailwayStation station3 = new RailwayStation("Nastya3");
        RailwayStation station4 = new RailwayStation("Nastya4");
        RailwayStation station5 = new RailwayStation("Nastya5");
        RailwayStation station6 = new RailwayStation("Nastya6");
        RailwayStation station7 = new RailwayStation("Nastya7");

        station1.addNextStation(station2,1);
        station1.addNextStation(station4,3);
        station4.addNextStation(station5,7);
        station2.addNextStation(station7,2);
        station7.addNextStation(station5,3);
        station2.addNextStation(station3,10);
        station3.addNextStation(station6,7);

        Route route = new Route(station1,station5);
        route.setPath();
        System.out.println(route.route);

        Route route2 = new Route(station1,station6);
        route2.setPath();
        System.out.println(route2.route);

        System.out.println(route.distance);
        System.out.println(route2.distance);*/
    }
}
