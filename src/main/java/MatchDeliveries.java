import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
class MatchDeliveries {
    private List<String []> fileListDeliveries;
    MatchDeliveries()
    {
        ReadFile ob=new ReadFile();
        ob.setFileData(Constants.FILE_DELIVERIES);
        fileListDeliveries =ob.getFileData();
    }
      List<String[]> getDeliveriesFile()
    {
        return fileListDeliveries;
    }

    //-----------------no of extra run start--------------------
        static TreeMap<String,Integer> noOfExtraRun(List<String[]> matchFile,List<String []>deliveriesFile){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap<>();
        ArrayList<String>id2016;
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
        static TreeMap<Float,String> topEconomicalBowlers(List<String[]> matchFile,List<String []>deliveriesFile){
        TreeMap<String ,Integer>tOver=new TreeMap<>();
        TreeMap<String,Integer>tRun=new TreeMap<>();
        TreeMap<Float,String>top=new TreeMap<>();
        ArrayList<String>id2015;
        String Year="2015";
        id2015=getYearId(matchFile,Year);
        for(String[]winner:deliveriesFile)
        {
            String id=winner[Constants.MATCHES_ID];
            if(id2015.contains(id))
            {
                if (tOver.containsKey(winner[Constants.BOWLER_NAME])) {
                    int tmp = tOver.get(winner[Constants.BOWLER_NAME]);
                    tmp = tmp + 1;
                    tOver.put(winner[Constants.BOWLER_NAME], tmp);
                }
                else {
                    tOver.put(winner[Constants.BOWLER_NAME], 1); //over 4 index
                }
                if(tRun.containsKey(winner[Constants.BOWLER_NAME]))
                {
                    int tmp=tRun.get(winner[Constants.BOWLER_NAME]);
                    int tmp1=Integer.parseInt(winner[Constants.TOTAL_RUN]);
                    tmp=tmp+tmp1;
                    tRun.put(winner[Constants.BOWLER_NAME],tmp);
                }
                else {
                    int tmp1=Integer.parseInt(winner[Constants.TOTAL_RUN]);
                    tRun.put(winner[Constants.BOWLER_NAME],tmp1);
                }
            }
        }
        for (Map.Entry mapElement : tRun.entrySet()) {
            String key = (String)mapElement.getKey();
            int run = (int)mapElement.getValue();
            float over=(float)tOver.get(key);
            over=over/(float)6;
            float comp=(float) run/over;
            top.put(comp,key);
        }
        return top;
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

    }


