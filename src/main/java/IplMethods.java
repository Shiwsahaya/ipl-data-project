import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class IplMethods {
    //-------------------no of matches start----------------------
    TreeMap<String, Integer> noOfMatches (List < String[]>fileList){
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String[] record : fileList) {
            if (map.containsKey(record[Constants.SESSION])) {
                int tmp = map.get(record[Constants.SESSION]);
                tmp = tmp + 1;
                map.put(record[Constants.SESSION], tmp);
            } else {
                map.put(record[Constants.SESSION], 1);
            }
        }
        return map;

    }
    //-------------------no of matches end-------------------------

    //-------------------no of won matches start-------------------------
    TreeMap<String, Integer> noOfWonMatch (List < String[]>fileList){
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String[] record : fileList) {
            if (record[Constants.WINNER_TEAM].equals(""))
                continue;
            if (map.containsKey(record[Constants.WINNER_TEAM])) {
                int tmp = map.get(record[Constants.WINNER_TEAM]);
                tmp = tmp + 1;
                map.put(record[Constants.WINNER_TEAM], tmp);
            } else {
                map.put(record[Constants.WINNER_TEAM], 1);
            }
        }
        return map;

    }
    //-------------------no of won matches end---------------------------

    //-----------------no of extra run start--------------------
    TreeMap<String,Integer> noOfExtraRun(List<String[]> matchFile,List<String []>deliveriesFile){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap<>();
        ArrayList<String> id2016;
        String Year="2016";
        id2016=getYearId(matchFile,Year);
        for(String[]winner:deliveriesFile)
        {
            String id=winner[Constants.MATCHES_ID];
            if(id2016.contains(id))
            {
                if(!totalWindOfTeam.containsKey(winner[Constants.BOWLING_TEAM]))
                {
                    int tmp=Integer.parseInt(winner[Constants.EXTRA_RUN]);
                    totalWindOfTeam.put(winner[Constants.BOWLING_TEAM],tmp);
                }
                else {
                    int value=totalWindOfTeam.get(winner[Constants.BOWLING_TEAM]);
                    int tmp=Integer.parseInt(winner[Constants.EXTRA_RUN]);
                    tmp=tmp+value;
                    totalWindOfTeam.put(winner[Constants.BOWLING_TEAM],tmp);
                }
            }
        }
        return totalWindOfTeam;
    }
    //-----------------no of extra run end----------------------

    //-----------------top economical bowler start--------------
    TreeMap<Float,String> topEconomicalBowlers(List<String[]> matchFile,List<String []>deliveriesFile){
        TreeMap<String ,Integer>totalOver=new TreeMap<>();
        TreeMap<String,Integer>totalRun=new TreeMap<>();
        TreeMap<Float,String>topEconomicBowler=new TreeMap<>();
        ArrayList<String>id2015;
        String Year="2015";
        id2015=getYearId(matchFile,Year);
        for(String[]winner:deliveriesFile)
        {
            String allYearId=winner[Constants.MATCHES_ID];
            if(id2015.contains(allYearId))
            {
                if (totalOver.containsKey(winner[Constants.BOWLER_NAME])) {
                    int tmp = totalOver.get(winner[Constants.BOWLER_NAME]);
                    tmp = tmp + 1;
                    totalOver.put(winner[Constants.BOWLER_NAME], tmp);
                }
                else {
                    totalOver.put(winner[Constants.BOWLER_NAME], 1); //over 4 index
                }
                if(totalRun.containsKey(winner[Constants.BOWLER_NAME]))
                {
                    int tmp=totalRun.get(winner[Constants.BOWLER_NAME]);
                    int tmp1=Integer.parseInt(winner[Constants.TOTAL_RUN]);
                    tmp=tmp+tmp1;
                    totalRun.put(winner[Constants.BOWLER_NAME],tmp);
                }
                else {
                    int tmp1=Integer.parseInt(winner[Constants.TOTAL_RUN]);
                    totalRun.put(winner[Constants.BOWLER_NAME],tmp1);
                }
            }
        }
        for (Map.Entry mapElement : totalRun.entrySet()) {
            String key = (String)mapElement.getKey();
            int run = (int)mapElement.getValue();
            float over=(float)totalOver.get(key);
            over=over/(float)6;
            float comp=(float) run/over;
            topEconomicBowler.put(comp,key);
        }
        return topEconomicBowler;
    }

    //-----------------top economical bowler end----------------


    //-----------------for getting id start---------------------
    private static ArrayList<String>getYearId(List<String[]> matchFile,String year)
    {
        ArrayList<String>id=new ArrayList<>();
        for(String[]winner:matchFile)
        {
            String yearId=winner[Constants.MATCHES_ID];
            if(winner[Constants.SESSION].equals(year))
                id.add(yearId);
        }
        return id;
    }
    //-----------------for getting id end-----------------------


    public static void main(String[]args) {


    }
}