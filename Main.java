public class Main {
    public static void main(String[] args) {
        /*RailwayStation station1 = new RailwayStation("Kharkiv");
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
        System.out.println(route1_5.distance);*/

        Locomotive loc1 = new Locomotive("loc1");
        loc1.setMaxElectricRRCarNumber(2);
        loc1.setMaxLoadWeight(1000);
        loc1.setMaxRRCarNumber(5);

        PassengerRRCar c1 = new PassengerRRCar(250,50);
        RailroadCar c2 = new RRFreightCar(100);
        RailroadCar c3 = new BaggageMailRRCar(200);
        RailroadCar c4 = new RRPostOffice(220);

        Trainset trainset1 = new Trainset(loc1);
        try {
            trainset1.addRRCar(c1);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }
        try {
            trainset1.addRRCar(c2);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }try {
            trainset1.addRRCar(c3);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }try {
            trainset1.addRRCar(c4);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }
        System.out.println(trainset1.cars);
        c1.loadPassengers(45);
        System.out.println(c1.peopleCount);
    }
}
