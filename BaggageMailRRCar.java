import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BaggageMailRRCar extends RailroadCar{
    private final int maxMailNum;
    private final int maxBaggageWeight;
    public List<Integer> weights;


    public BaggageMailRRCar(int netWeight) {
        super(netWeight);
        this.type = "Baggage and Mail Car";
        this.maxMailNum = (int)(3+ Math.random()*4);
        this.maxBaggageWeight = (int)(6+ Math.random()*4);
        this.weights = new ArrayList<>();
    }
    public void addWeight(int w){
        if((this.grossWeight-this.netWeight) <=this.maxBaggageWeight) {
            this.weights.add(w);
            this.grossWeight += w;
        }
        else {
            System.out.println("exceeded max weight number");
        }
    }

    public void sortBaggageByWeight(){
        Collections.sort(weights);
        System.out.println("weights: " + weights.toString());
    }


}
