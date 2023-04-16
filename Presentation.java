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
        /*Thread trainset = new Trainset(new Locomotive(stations[(int)(Math.random()* 100)], stations));
        int a = (int)(5 + Math.random() * 6);
        for(int j = 0; j < a; j++){
            int b = (int)(1 + Math.random()*12);
            switch(b){
                case 1 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new PassengerRRCar((int)(2 + Math.random()*4),(int)(30 + Math.random()*11)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new RRPostOffice((int)(2 + Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new BaggageMailRRCar((int)(2 + Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 4 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new RestaurantRRCar((int)(2 + Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 5 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new RRFreightCar((int)(3 + Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 6 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new HeavyRRFreightCar((int)(4+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 7 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new RefrigeratedRRCar((int)(2+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 8 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new LiquidMatRRFreightCar((int)(2+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 9 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new GasMatRRFreightCar((int)(2+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 10 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new ExplosivesHeavyRRFreightCar((int)(2+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 11 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new ToxicMatHeavyRRFreightCar((int)(2+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
                case 12 -> {
                    try {
                        ((Trainset) trainset).addRRCar(new LiqToxicMatHeavyRRFreightCar((int)(2+Math.random()*4)));
                    } catch (ImpossibleToAddCar e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        trainset.start();*/
    }
}
