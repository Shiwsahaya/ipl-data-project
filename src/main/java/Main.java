import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] arg) {
        TreeMap<String, Integer> mapForResult;

        String matchesFile = Constants.FILE_MATCHES;
        List<String[]> matchFileList;
        Match matchClassObject = new Match();
        matchClassObject.setFile(matchesFile);
        matchFileList = matchClassObject.getMatchFileData();

        String deliveriesFile = Constants.FILE_DELIVERIES;
        List<String[]> deliveriesFileList;
        Deliveries deliveriesClassObject = new Deliveries();
        deliveriesClassObject.setFile(deliveriesFile);
        deliveriesFileList = deliveriesClassObject.getMatchFileData();

        IplMethods iplMethodObject = new IplMethods();

        mapForResult = iplMethodObject.noOfMatches(matchFileList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String) mapElement.getKey();
            int value = ((int) mapElement.getValue());
            System.out.println("In " + key + " Total Played Match: " + value);
        }
        System.out.println("*****************************************************************************");

        mapForResult = iplMethodObject.noOfWonMatch(matchFileList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String) mapElement.getKey();
            int value = ((int) mapElement.getValue());
            System.out.println(key + " Total Win Match: " + value);
        }
        System.out.println("*****************************************************************************");


        mapForResult = iplMethodObject.noOfExtraRun(matchFileList,deliveriesFileList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("Total Extra run given by "+key +" In 2016: "+ value);
        }
        System.out.println("*****************************************************************************");

        TreeMap<Float,String>topEconomicBowlersResult;
        topEconomicBowlersResult= iplMethodObject.topEconomicalBowlers(matchFileList,deliveriesFileList);
        int index=0;
        for (Map.Entry mapElement : topEconomicBowlersResult.entrySet()) {
            float key = (Float)mapElement.getKey();
            String value = (String)mapElement.getValue();
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(value + " Bowling Economy in 2016: " + df.format(key));
            index++;
            if(index>10)
                break;
        }
        System.out.println("*****************************************************************************");





    }
}
