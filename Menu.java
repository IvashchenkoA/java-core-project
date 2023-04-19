import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int a;
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("\t1 - create an object\n" +
                                "\t2 - test functions\n" +
                                "\t3 - remove an object\n" +
                                "\t0 - exit");
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();
            if( a == 1 ){
                System.out.println("What do you want to create?");
                System.out.println("\t1 - Railway Station\n" +
                                    "\t2 - Connection between stations\n" +
                                    "\t3 - Railroad Car\n" +
                                    "\t4 - Locomotive\n" +
                                    "\t5 - Trainset");
                a = scan.nextInt();
                    if(a == 1){
                        System.out.println("Enter a name for a station: ");
                        String name = scan.next();
                        RailwayStation station = new RailwayStation(name);
                        station.addStationToList();
                        RailwayStation.displayCreatedStations();
                    }
                    if(a == 2){
                        RailwayStation.displayCreatedStations();
                        System.out.println("Enter a name of a station from: ");
                        String name = scan.next();
                        System.out.println("Enter a name of a station to: ");
                        String nameTo = scan.next();
                        System.out.println("Enter a distance from station from to station to: ");
                        int dist = scan.nextInt();
                        if (RailwayStation.getStationByName(name) != null && RailwayStation.getStationByName(nameTo) != null)  {
                            RailwayStation.getStationByName(name).addNextStation(RailwayStation.getStationByName(nameTo),dist);
                        }
                        else if(RailwayStation.getStationByName(name) != null){
                            System.out.println("station to doesn't exist");
                        }
                        else {
                            System.out.println("station from doesn't exist");
                        }
                    }
                    if(a == 3) {
                        System.out.println("What type of a railroad car do you want to create?");
                        System.out.println("\t1 - Passenger car\n" +"\t2 - Railroad post office\n"
                                +"\t3 - Baggage and mail car\n" +"\t4 - Restaurant car\n"
                                +"\t5 - Basic freight car\n" +"\t6 - Heavy freight car\n"
                                +"\t7 - Refrigerated car\n" +"\t8 - Basic freight car for liquids\n"
                                +"\t9 - Basic freight car for gaseous\n" +"\t10 - Heavy freight car for explosives\n"
                                +"\t11 - Heavy freight car for toxic materials\n" +
                                "\t12 - Heavy freight car for liquid and toxic materials");
                        int b = scan.nextInt();
                        System.out.println("Enter net weight of a car: ");
                        int w = scan.nextInt();
                        switch(b){
                            case 1 -> {
                                System.out.println("Enter number of seats: ");
                                int s = scan.nextInt();
                                RailroadCar car = new PassengerRRCar(w,s);
                                car.addCarToList();
                            }
                            case 2 -> {
                                RailroadCar car = new RRPostOffice(w);car.addCarToList();
                            }
                            case 3 -> {
                                RailroadCar car = new BaggageMailRRCar(w);car.addCarToList();
                            }
                            case 4 -> {
                                RailroadCar car = new RestaurantRRCar(w);car.addCarToList();
                            }
                            case 5 -> {
                                RailroadCar car = new RRFreightCar(w);car.addCarToList();
                            }
                            case 6 -> {
                                RailroadCar car = new HeavyRRFreightCar(w);car.addCarToList();
                            }
                            case 7 -> {
                                RailroadCar car = new RefrigeratedRRCar(w);car.addCarToList();
                            }
                            case 8 -> {
                                RailroadCar car = new LiquidMatRRFreightCar(w);car.addCarToList();
                            }
                            case 9 -> {
                                RailroadCar car = new GasMatRRFreightCar(w);car.addCarToList();
                            }
                            case 10 -> {
                                RailroadCar car = new ExplosivesHeavyRRFreightCar(w);car.addCarToList();
                            }
                            case 11 -> {
                                RailroadCar car = new ToxicMatHeavyRRFreightCar(w);car.addCarToList();
                            }
                            case 12 -> {
                                RailroadCar car = new LiqToxicMatHeavyRRFreightCar(w);car.addCarToList();
                            }
                        }
                        RailroadCar.displayCarList();
                    }
                    if(a == 4){
                        System.out.println("Choose a home station for a locomotive(null if list is empty): ");
                        String c = scan.next();
                        if(c != null) {
                            Locomotive locomotive = new Locomotive(RailwayStation.getStationByName(c));
                            locomotive.addLocToList();
                        }
                        else{
                            System.out.println("No stations created yet. Try again");
                        }
                        Locomotive.displayLoclist();
                    }
                    if(a == 5){
                        System.out.println("Which locomotive would you like to assign to a trainset?(enter id):");
                        int id = scan.nextInt();
                        if(Locomotive.getLocByID(id) != null){
                            Trainset trainset = new Trainset(Locomotive.getLocByID(id));
                        }
                        else {
                            System.out.println("such locomotive doesn't exist");
                        }
                    }
                }
            if( a == 2 ){
                System.out.println("What do you want to do?");
                System.out.println("\t1 - load people\n" +
                                    "\t2 - load cargo\n" +
                                    "\t3 - unload people\n" +
                                    "\t4 - unload cargo\n" +
                                    "\t5 - attach a car to a locomotive\n" +
                                    "\t6 - disconnect a car from a locomotive\n");
            }
        }
    }
}
