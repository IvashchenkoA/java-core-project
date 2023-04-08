import java.util.Scanner;

public class PassengerRRCar extends RailroadCar{
    public int numOfSeats;
    public int peopleCount;

    public PassengerRRCar(int netWeight, int numOfSeats) {
        super( netWeight);
        this.numOfSeats = numOfSeats;
        this.connectionRequired = true;
        this.peopleCount = 0;
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
        /*if(!(people > numOfSeats))
            peopleCount += people;
        else System.out.println("\t\tFailed to load passengers:\n\ttry adding smaller number.");*/
    }
}
