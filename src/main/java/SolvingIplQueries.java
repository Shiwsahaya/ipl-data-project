import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolvingIplQueries {
    public static void main(String[] arg)
    {
        Matches matchClassObject=new Matches();
        MatchDeliveries matchDeliveriesClassObject=new MatchDeliveries();
        List<String[]> fileList=matchClassObject.getCsvFile();
        List<String []>deliveries=matchDeliveriesClassObject.getDeliveriesFile();
        TreeMap<String,Integer>mapForResult;
        mapForResult=matchClassObject.noOfMatches(fileList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("In "+key+" Total Played Match: " + value);
        }
        System.out.println("*****************************************************************************");

        mapForResult=matchClassObject.noOfWonMatch(fileList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " Total Win Match: " + value);
        }
        System.out.println("*****************************************************************************");


        mapForResult=matchDeliveriesClassObject.noOfExtraRun(fileList,deliveries);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("Total Extra run given by "+key +" In 2016: "+ value);
        }
        System.out.println("*****************************************************************************");


        TreeMap<Float,String>topEconomicBowlersResult;
        topEconomicBowlersResult=matchDeliveriesClassObject.topEconomicalBowlers(fileList,deliveries);
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
