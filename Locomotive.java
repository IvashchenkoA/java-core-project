public class Locomotive {
    RailwayStation homeStation, sourceStation, destinationStation;
    private final int id;
    static int count;
    double speed;
    private int maxRRCarNumber;
    private int maxLoadWeight;
    private int maxElectricRRCarNumber;

    public Locomotive(RailwayStation homeStation) {
        this.id = ++count;
        this.homeStation = homeStation;
        this.speed = 210;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()){
                    adjustSpeed();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();
    }

    public void adjustSpeed() {
        if(Math.random() > 0.5)
            speed *= 1.03;
        else speed *= 0.97;
    }


    public void setMaxRRCarNumber(int maxRRCarNumber) {
        this.maxRRCarNumber = maxRRCarNumber;
    }

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public void setMaxElectricRRCarNumber(int maxElectricRRCarNumber) {
        this.maxElectricRRCarNumber = maxElectricRRCarNumber;
    }

    public void setHomeStation(RailwayStation homeStation) {
        homeStation = homeStation;
    }

    public void setSourceStation(RailwayStation sourceStation) {
        sourceStation = sourceStation;
    }

    public void setDestinationStation(RailwayStation destinationStation) {
        destinationStation = destinationStation;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMaxRRCarNumber() {
        return maxRRCarNumber;
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public int getMaxElectricRRCarNumber() {
        return maxElectricRRCarNumber;
    }

    @Override
    public String toString() {
        return "Locomotive { " +
                "id=" + id +
                " }";
    }
}
