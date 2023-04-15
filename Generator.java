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
    public static RailwayStation[] createStationsAndConnections() {
        RailwayStation[] stationsArray = new RailwayStation[100];
        for(int i = 0; i < stationsArray.length; i++){
            stationsArray[i] = new RailwayStation(stationNames[i]);
        }
        for(int i = 0; i < stationsArray.length; i++){
            for(int j = 0; j < 6; j++){
                stationsArray[i].addNextStation(stationsArray[(int)(Math.random()*100)], (int)(3 + Math.random()*6));
                while(stationsArray[i].nextStation.containsKey(stationsArray[i])){
                    stationsArray[i].nextStation.remove(stationsArray[i]);
                    stationsArray[i].addNextStation(stationsArray[(int)(Math.random()*100)], (int)(3 + Math.random()*6));
                }
            }
        }
        return stationsArray;
    }

}
