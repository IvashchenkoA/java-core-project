public class RestaurantRRCar extends RailroadCar{
    public int dishCount;
    public int drinksCount;
    public RestaurantRRCar(int netWeight) {
        super(netWeight);
        this.connectionRequired = true;
        this.type = "Restaurant car";
        this.dishCount = (int)(8 + Math.random()*8);
        this.drinksCount = (int)(8 + Math.random()*8);
    }
    public void orderDish(int c){
        if(c <= this.dishCount){
            dishCount-=c;
            System.out.println("dish is ordered");
        }
        System.out.println("exceeded number of possible dishes");
    }
    public void orderDrink(int d){
        if(d <= this.drinksCount){
            drinksCount-=d;
            System.out.println("drink is ordered");
        }
        else{
            System.out.println("exceeded number of possible drinks");
        }
    }
}
