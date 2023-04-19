public class Generator {
    public static String[] stationNames = new String[]{"Paddington", "Liverpool", "Euston", "Waterloo", "King's Cross", "Victoria",
            "Brighton", "Reading", "Leeds", "Glasgow", "Bristol", "Newcastle", "York", "Oxford", "Nottingham",
            "Cambridge", "Exeter", "Derby", "Swansea", "Carlisle", "Norwich", "Birmingham", "Sheffield", "Plymouth",
            "Portsmouth", "Canterbury", "Woking", "Cheltenham", "Dover", "Milton", "Doncaster", "Warrington",
            "Harrogate", "Peterborough", "Basingstoke", "Barnstaple", "Bridgend", "Hitchin", "Lincoln", "Stirling",
            "Inverness", "Aberdeen", "Dundee", "Perth", "Edinburgh", "Gillingham", "Horsham", "Bromley", "Croydon",
            "Sutton", "Twickenham", "Hounslow", "Feltham", "Wimbledon", "Ealing", "Hayes", "Brentwood", "Colchester",
            "Folkestone", "Stoke-on-Trent", "Swindon", "Telford", "Worcester", "Wokingham", "Maidenhead", "Slough",
            "Staines", "Farnham", "Guildford", "Basing", "Chichester", "Farnborough", "Redhill", "Tonbridge", "Warwick",
            "Winchester", "Bath", "Bognor", "Dorking", "Epsom", "Haslemere", "Leamington", "Lewes", "Lichfield",
            "Newbury", "Orpington", "Oxted", "Sevenoaks", "Sutton Coldfield", "Tunbridge", "Uckfield", "Weybridge",
            "Weymouth", "Whitstable", "Windsor", "Worthing", "Crawley", "Folkestone Central", "Hastings", "St Albans"};

    public static RailwayStation[] arrayOfStations;
    public static Trainset[] arrayOfTrainsets;
    public static void createStationsAndConnections() {
        RailwayStation[] stationsArray = new RailwayStation[100];
        for(int i = 0; i < stationsArray.length; i++){
            stationsArray[i] = new RailwayStation(stationNames[i]);
        }
        for (RailwayStation railwayStation : stationsArray) {
            for (int j = 0; j < 10; j++) {
                railwayStation.addNextStation(stationsArray[(int) (Math.random() * 100)], (int) (3 + Math.random() * 6));
                while (railwayStation.nextStation.containsKey(railwayStation)) {
                    railwayStation.nextStation.remove(railwayStation);
                    railwayStation.addNextStation(stationsArray[(int) (Math.random() * 100)], (int) (3 + Math.random() * 6));
                }
            }
        }
        arrayOfStations = stationsArray;
    }

    public static void createTrainsets() throws ImpossibleToAddCar {
        Trainset[] trainsets = new Trainset[25];
        for(int i = 0; i < trainsets.length; i++){
            trainsets[i] = new Trainset(new Locomotive(arrayOfStations[(int)(Math.random()* 100)]));
            Locomotive.setArrayOfStations(arrayOfStations);
            int a = (int)(5 + Math.random() * 6);
            for(int j = 0; j < a; j++){
                int b = (int)(1 + Math.random()*12);
                switch(b){
                    case 1 -> trainsets[i].addRRCar(new PassengerRRCar((int)(2 + Math.random()*4),(int)(30 + Math.random()*11)));
                    case 2 -> trainsets[i].addRRCar(new RRPostOffice((int)(2 + Math.random()*4)));
                    case 3 -> trainsets[i].addRRCar(new BaggageMailRRCar((int)(2 + Math.random()*4)));
                    case 4 -> trainsets[i].addRRCar(new RestaurantRRCar((int)(2 + Math.random()*4)));
                    case 5 -> trainsets[i].addRRCar(new RRFreightCar((int)(3 + Math.random()*4)));
                    case 6 -> trainsets[i].addRRCar(new HeavyRRFreightCar((int)(4+Math.random()*4)));
                    case 7 -> trainsets[i].addRRCar(new RefrigeratedRRCar((int)(2+Math.random()*4)));
                    case 8 -> trainsets[i].addRRCar(new LiquidMatRRFreightCar((int)(2+Math.random()*4)));
                    case 9 -> trainsets[i].addRRCar(new GasMatRRFreightCar((int)(2+Math.random()*4)));
                    case 10 -> trainsets[i].addRRCar(new ExplosivesHeavyRRFreightCar((int)(2+Math.random()*4)));
                    case 11 -> trainsets[i].addRRCar(new ToxicMatHeavyRRFreightCar((int)(2+Math.random()*4)));
                    case 12 -> trainsets[i].addRRCar(new LiqToxicMatHeavyRRFreightCar((int)(2+Math.random()*4)));
                }
            }
        }
        arrayOfTrainsets = trainsets;
    }


}
