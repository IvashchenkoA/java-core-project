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
                                    "\t4 - Locomotive\n");
                int b = scan.nextInt();
                    if(b == 1){
                        System.out.println("Enter a name for a station: ");
                        String name = scan.next();
                        RailwayStation station = new RailwayStation(name);
                        station.addStationToList();
                        RailwayStation.displayCreatedStations();
                    }
                    if(b == 2){
                        if(RailwayStation.stationsList.size() >=2 ){
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
                        else{
                            System.out.println("not enough stations to create a connection.\n" +
                                    "stations to create: " + (2 - RailwayStation.stationsList.size()));
                        }
                    }
                    if(b == 3) {
                        System.out.println("What type of a railroad car do you want to create?");
                        System.out.println("\t1 - Passenger car\n" +"\t2 - Railroad post office\n"
                                +"\t3 - Baggage and mail car\n" +"\t4 - Restaurant car\n"
                                +"\t5 - Basic freight car\n" +"\t6 - Heavy freight car\n"
                                +"\t7 - Refrigerated car\n" +"\t8 - Basic freight car for liquids\n"
                                +"\t9 - Basic freight car for gaseous\n" +"\t10 - Heavy freight car for explosives\n"
                                +"\t11 - Heavy freight car for toxic materials\n" +
                                "\t12 - Heavy freight car for liquid and toxic materials");
                        int d = scan.nextInt();
                        System.out.println("Enter net weight of a car: ");
                        int w = scan.nextInt();
                        switch(d){
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
                    if(b == 4){
                        if(RailwayStation.stationsList.size()<3){
                            System.out.println("not enough stations created to create a locomotive.\n" +
                                    "needed more: " + (3 - RailwayStation.stationsList.size()));
                        }else {
                            RailwayStation.displayCreatedStations();
                            System.out.println("Choose a home station for a locomotive(null if list is empty): ");
                            String c = scan.next();
                            if(c != null) {
                                Locomotive locomotive = new Locomotive(RailwayStation.getStationByName(c));
                                locomotive.addLocToList();
                                Thread trainset = new Trainset(locomotive);
                                ((Trainset) trainset).addTrainToList();
                                Locomotive.setArrayOfStations(RailwayStation.stationsList);
                                trainset.start();
                                while(((Trainset) trainset).locomotive.route == null){
                                  /*  try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }*/
                                }
                                Trainset.displayTrains();
                            }
                            else{
                                System.out.println("No stations created yet. Try again");
                            }
                        }
                    }
                    else {
                        continue;
                    }
                }
            if( a == 2 ){
                System.out.println("What do you want to do?");
                System.out.println("\t1 - load people\n" +
                                    "\t2 - load cargo\n" +
                                    "\t3 - unload people\n" +
                                    "\t4 - unload cargo\n" +
                                    "\t5 - attach a car to a locomotive\n" +
                                    "\t6 - disconnect a car from a locomotive\n" +
                                    "\t7 - display info about a trainset");
                int b = scan.nextInt();
                if(b == 1){
                    if(RailroadCar.carsList.size()>0) {
                        RailroadCar.displayCarList();
                        System.out.println("Choose a passenger car (id)");
                        int id = scan.nextInt();
                        if (RailroadCar.getCarById(id).type.equals("Passenger car")) {
                            if (PassengerRRCar.getCarById(id) != null) {
                                PassengerRRCar.getCarById(id).loadPassengers();
                            } else {
                                System.out.println("A car with such id doesn't exist");
                            }
                        }
                        else{
                            System.out.println("failed: you should choose a passenger car to perform this");
                        }
                    }
                    else{
                        System.out.println("no cars created yet");
                    }
                }
                else if(b == 2){
                    if(RailroadCar.carsList.size()>0) {
                        RailroadCar.displayCarList();
                        System.out.println("Choose a freight car(id)");
                        int id = scan.nextInt();
                        if(RailroadCar.getCarById(id).type.contains("freight") ||RailroadCar.getCarById(id).type.contains("Freight")) {
                            if (RRFreightCar.getCarById(id) != null) {
                                RRFreightCar.getCarById(id).loadCar();
                            } else {
                                System.out.println("car not found");
                            }
                        }
                        else {
                            System.out.println("failed: you should choose a freight car to perform this\"");
                        }
                    }
                    else{
                        System.out.println("no cars created yet");
                    }
                }
                else if(b == 3){
                    if(RailroadCar.carsList.size()>0) {
                        RailroadCar.displayCarList();
                        System.out.println("Choose a passenger car(id)");
                        int id = scan.nextInt();
                        if (RailroadCar.getCarById(id).type.equals("Passenger car")) {
                            if (PassengerRRCar.getCarById(id) != null) {
                                PassengerRRCar.getCarById(id).unloadPassengers();
                            } else {
                                System.out.println("A car with such id doesn't exist");
                            }
                        }
                        else {
                            System.out.println("failed: you should choose a passenger car to perform this\"");
                        }
                    }
                    else{
                        System.out.println("no cars created yet");
                    }
                }
                else if(b == 4){
                    if(RailroadCar.carsList.size()>0) {
                        RailroadCar.displayCarList();
                        System.out.println("Choose a freight car(id)");
                        int id = scan.nextInt();
                        if (RailroadCar.getCarById(id).type.contains("freight") || RailroadCar.getCarById(id).type.contains("Freight")) {
                            if (RRFreightCar.getCarById(id) != null) {
                                RRFreightCar.getCarById(id).unloadCar();
                            } else {
                                System.out.println("car not found");
                            }
                        }
                        else {
                            System.out.println("failed: you should choose a freight car to perform this\"");
                        }
                    }
                    else{
                        System.out.println("no cars created yet");
                    }
                }
                else if(b == 5){
                    if(RailroadCar.carsList.size()>0 && Trainset.trainsList.size() > 0) {
                        RailroadCar.displayCarList();
                        System.out.println("Choose a car that you'd like to attach(id): ");
                        int idCar = scan.nextInt();
                        Locomotive.displayLoclist();
                        System.out.println("Choose a locomotive(id):");
                        int idLoc = scan.nextInt();
                        if (Trainset.getTrainsetByLocId(idLoc) != null && RailroadCar.getCarById(idCar) != null) {
                            try {
                                Trainset.getTrainsetByLocId(idLoc).addRRCar(RailroadCar.getCarById(idCar));
                                System.out.println("car added successfully");
                            } catch (ImpossibleToAddCar e) {
                                e.printStackTrace();
                            }
                        } else if (Trainset.getTrainsetByLocId(idLoc) == null) {
                            System.out.println("such locomotive not found");
                        } else {
                            System.out.println("such car not found");
                        }
                    }
                    else if(Trainset.trainsList.size() > 0){
                        System.out.println("no cars created yet");
                    }
                    else {
                        System.out.println("no trainsets created yet");
                    }
                }
                else if(b == 6){
                    if(RailroadCar.carsList.size()>0 && Trainset.trainsList.size() > 0) {
                        Trainset.displayTrains();
                        RailroadCar.displayCarList();
                        System.out.println("choose a car that you'd like to disconnect");
                        int idCar = scan.nextInt();
                        if (Trainset.getTrainsetByCarID(idCar) != null) {
                            try {
                                Trainset.getTrainsetByCarID(idCar).discardRRCar(RailroadCar.getCarById(idCar));
                            } catch (ImpossibleToDiscardCar e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("such car not found");
                        }
                    }else if(Trainset.trainsList.size() > 0){
                        System.out.println("no cars created yet");
                    }
                    else {
                        System.out.println("no trainsets created yet");
                    }
                }
                else if(b == 7){
                    if(Trainset.trainsList.size() > 0) {
                        Trainset.displayTrains();
                        System.out.println("choose a trainset id to see current info:");
                        int id = scan.nextInt();
                        Trainset.displayTrainsetInfo(id);
                    }
                    else {
                        System.out.println("no trainsets created yet");
                    }
                }
                else {
                    continue;
                }
            }

            if(a == 3) {
                System.out.println("What do you want to remove?");
                System.out.println("\t1 - trainset\n" +
                        "\t2 - car\n");
                int b = scan.nextInt();
                if (b == 1) {
                    if (Trainset.trainsList.size() > 0) {
                        Trainset.displayTrains();
                        System.out.println("Which trainset do you want to remove?(id)");
                        int id = scan.nextInt();
                        if (Trainset.getTrainsetByID(id) != null) {
                            Trainset.getTrainsetByID(id).interrupt();
                            Trainset.getTrainsetByID(id).removeTrainFromQueue();
                            Trainset.getTrainsetByID(id).removeTrainset();
                            Trainset.displayTrains();
                        } else {
                            System.out.println("Trainset not found");
                        }
                    } else {
                        System.out.println("no trainsets created yet");
                    }
                } else if (b == 2) {
                    if (RailroadCar.carsList.size() > 0) {
                        RailroadCar.displayCarList();
                        System.out.println("Which car do you want to remove(id)?");
                        int id = scan.nextInt();
                        if(RailroadCar.getCarById(id)!= null) {
                            if (Trainset.isConnected(RailroadCar.getCarById(id))) {
                                try {
                                    Trainset.getTrainsetByCarID(id).discardRRCar(RailroadCar.getCarById(id));
                                    RailroadCar.getCarById(id).removeCar();
                                    RailroadCar.displayCarList();
                                } catch (ImpossibleToDiscardCar e) {
                                    e.printStackTrace();
                                }
                            } else {
                                RailroadCar.getCarById(id).removeCar();
                                RailroadCar.displayCarList();
                            }
                        }
                        else{
                            System.out.println("such car not found");
                        }
                    }
                    else{
                        System.out.println("no cars created yet");
                    }
                }
            }
            if (a == 0) {
                for(Trainset tr : Trainset.trainsList){
                    tr.interrupt();
                }
                Trainset.clearList();
                Locomotive.clearList();
                RailroadCar.clearList();
                RailwayStation.clearList();
                break;
            }
        }

    }
}
