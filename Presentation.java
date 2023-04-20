import java.util.List;

public class Presentation {
    public static void main(String[] args) {
        Generator.createStationsAndConnections();
        try {
            Generator.createTrainsets();
        } catch (ImpossibleToAddCar e) {
            throw new RuntimeException(e);
        }
        RailwayStation[] stations = Generator.arrayOfStations;
        Thread[] trainsets = Generator.arrayOfTrainsets;
        for (Thread trainset : trainsets) {
            trainset.start();
        }
        WriteToFile obj = new WriteToFile((Trainset[]) trainsets);
        obj.start();
        PassengerRRCar car1 = new PassengerRRCar(8,20);
        System.out.println(car1);
        car1.loadPeople();
        System.out.println(car1);
        car1.unloadPeople();
        System.out.println(car1);
        HeavyRRFreightCar car2 = new HeavyRRFreightCar(10);
        System.out.println(car2);
        car2.loadCar();
        System.out.println(car2);
        car2.unloadCar();
        System.out.println(car2);
        RestaurantRRCar car3 = new RestaurantRRCar(8);
        car3.orderDish(9);
        car3.orderDrink(7);
        BaggageMailRRCar car4 = new BaggageMailRRCar(12);
        car4.addWeight(4);
        car4.addWeight(2);
        car4.addWeight(3);
        car4.sortBaggageByWeight();
    }
}