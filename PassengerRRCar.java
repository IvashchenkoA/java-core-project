import java.util.Scanner;

public class PassengerRRCar extends RailroadCar{
    public int numOfSeats;
    public int peopleCount;

    public PassengerRRCar(int netWeight, int numOfSeats) {
        super( netWeight);
        this.numOfSeats = numOfSeats;
        this.connectionRequired = true;
        this.peopleCount = 0;
        this.type = "Passenger car";
    }
    public void loadPassengers(){
        Scanner scan = new Scanner(System.in);
        int scanPpl = 0;
        while(scanPpl < this.numOfSeats){
            System.out.println("\tHow many passengers would you like to load? ");
            int a = scan.nextInt();
            if( a + scanPpl <= this.numOfSeats ) {
                scanPpl += a;
                this.peopleCount += scanPpl;
                this.grossWeight += scanPpl * 80;
                System.out.println("Passengers added successfully.\n\tvacant seats: " + (this.numOfSeats - this.peopleCount) +
                        "\nWould you like to continue?\n\t1 - yes\n\t2 - no");
                a = scan.nextInt();
                if (a == 2) return;
            }
            else {
                scanPpl -= a;
                System.out.println("Exceeded possible number of passengers. Maximum is: " + (this.numOfSeats - this.peopleCount) +
                        "\nWould you like to try again?\n\t1 - yes\n\t2 - no");
                a = scan.nextInt();
                if (a == 2) return;
            }
        }
    }
    public void loadPeople(){
        this.peopleCount = this.numOfSeats;
    }
    public void unloadPassengers(){
        Scanner scan = new Scanner(System.in);
        int scanned = 0;
        while(scanned <= this.peopleCount){
            System.out.println("\tHow many passengers would you like to unload?");
            int a = scan.nextInt();
            if(a + scanned <= this.peopleCount){
                scanned += a;
                this.peopleCount -= scanned;
                this.grossWeight -= scanned * 80;
                System.out.println("Passengers unloaded successfully.\n\tpassenger left: " + (this.peopleCount)+
                        "\nWould you like to continue?\n\t1 - yes\n\t2 - no");
                a = scan.nextInt();
                if(a == 2) return;
            }
            else {
                System.out.println("Too many passengers inserted. Maximum is: " + (this.peopleCount) +
                        "\nTry again?\n\t1 - yes\n\t2 - no");
                a = scan.nextInt();
                if(a == 2) return;
            }
        }
    }

    public void unloadPeople(){
        this.peopleCount = 0;
    }
    @Override
    public String toString() {
        return super.toString() + " number of people: " + peopleCount;
    }
}
