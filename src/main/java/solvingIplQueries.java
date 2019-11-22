import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class solvingIplQueries {
    public static void main(String args[])
    {
        Matches m=new Matches();
        MatchDeliveries MD=new MatchDeliveries();
        List<String[]> fileList=m.getCsvFile();
        List<String []>deliveriFile=MD.getDelveiesFile();

        TreeMap<String,Integer>map=new TreeMap<String, Integer>();
        map=m.noOfMatches(fileList);
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + "\t" + value);
        }
        System.out.println("*****************************************************************************");

        map=m.noOfWonMatch(fileList);
        System.out.println("TeamName\tNoOfWonMatch");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
        System.out.println("*****************************************************************************");


        map=MD.noOfExtraRun(fileList,deliveriFile);
        System.out.println("TeamName\tGivenExtraRunIn2016");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
        System.out.println("*****************************************************************************");


        TreeMap<Float,String>economy=new TreeMap<>();
        economy=MD.topEconomicalBowlers(fileList,deliveriFile);
        int index=0;
        System.out.println("BowlerName\t Economy");
        for (Map.Entry mapElement : economy.entrySet()) {
            float key = (Float)mapElement.getKey();
            String value = (String)mapElement.getValue();
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(value + " : " + df.format(key));
            index++;
            if(index>10)
                break;
        }
        System.out.println("*****************************************************************************");
    }
}
