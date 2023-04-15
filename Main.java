import java.util.Scanner;
public class Main {
    public void menu(){
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("\tHello!\nWhat would you like to do?" +
                    "- create an object -> 1\n- test functionalities ->2");
            int a = scan.nextInt();
            if(a == 1){
                System.out.println("1 - create a station\n2 - create a car\n3 - create ");
            }
        }
    }
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

        Locomotive loc1 = new Locomotive(station1);

        PassengerRRCar c1 = new PassengerRRCar(1,50);
        RailroadCar c2 = new RRFreightCar(1);
        RailroadCar c3 = new BaggageMailRRCar(2);
        RailroadCar c4 = new RRPostOffice(2);

        Thread trainset1 = new Trainset(loc1);
        try {
            ((Trainset) trainset1).addRRCar(c1);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }
        try {
            ((Trainset) trainset1).addRRCar(c2);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }try {
            ((Trainset) trainset1).addRRCar(c3);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }try {
            ((Trainset) trainset1).addRRCar(c4);
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }
       // System.out.println(trainset1);

        ((Trainset) trainset1).checkLocSpeed();
        RailwayStation[] a = new RailwayStation[6];
        a[0] = station1;
        a[1] = station2;
        a[2] = station3;
        a[3] = station4;
        a[4] = station5;
        a[5] = station6;

        Locomotive.setArrayStations(a);



       trainset1.start();

        /*System.out.println(trainset1.cars);
        c1.loadPassengers();
        System.out.println(c1.peopleCount);*/
    }

}
