public class PassengerRRCar extends RailroadCar{
    public int numOfSeats;
    public int peopleCount;

    public PassengerRRCar(int netWeight, int numOfSeats) {
        super( netWeight);
        this.numOfSeats = numOfSeats;
        this.connectionRequired = true;
        this.peopleCount = 0;
    }
    public void loadPassengers(int people){
        if(!(people > numOfSeats))
            peopleCount += people;
        else System.out.println("\t\tFailed to load passengers:\n\ttry adding smaller number.");
    }
}
