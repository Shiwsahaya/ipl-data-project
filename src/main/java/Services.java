import java.util.*;

class Services {

    //-------------------no of matches start----------------------
    TreeMap<String, Integer> noOfMatches (List<Match> matchList){
        TreeMap<String, Integer> map = new TreeMap<>();
        matchList.forEach(match -> {
            //System.out.println(match.getSession());
            if(map.containsKey(Integer.toString(match.getSession())))
            {
                int tmpValue=map.get(Integer.toString(match.getSession()));
                map.put(Integer.toString(match.getSession()),tmpValue+1);
            }
            else
            {
                map.put(Integer.toString(match.getSession()),1);
            }
        });
        return map;
    }
    //-------------------no of matches end-------------------------


    //-------------------no of won matches start-------------------------
    TreeMap<String, Integer> noOfWonMatches (List<Match> matchList){
        TreeMap<String, Integer> map = new TreeMap<>();
        matchList.forEach(match -> {
            //System.out.println(match.getSession());
            if(match.getWinnerTeam().equals(""))
                ;
            else {
                if (map.containsKey(match.getWinnerTeam())) {
                    int tmpValue = map.get(match.getWinnerTeam());
                    map.put(match.getWinnerTeam(), tmpValue + 1);
                } else {
                    map.put(match.getWinnerTeam(), 1);
                }
            }
        });
        return map;

    }

    //-------------------no of won matches end---------------------------

    // -----------------no of extra run start--------------------
        TreeMap<String, Integer> noOfExtraRun (List<Match> matchList,List<Deliveries>deliveriesList){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap<>();
        ArrayList<Integer> id2016;
        int Year=Constants.Year2016;
        id2016=getYearId(matchList,Year);
        deliveriesList.forEach(deliveries -> {
            int id=deliveries.getId();
            if(id2016.contains(id))
            {
                if(!totalWindOfTeam.containsKey(deliveries.getBowlingTeam()))
                {
                    int tmp=deliveries.getExtraRun();
                    totalWindOfTeam.put(deliveries.getBowlingTeam(),tmp);
                }
                else
                {
                    int tmpValue=totalWindOfTeam.get(deliveries.getBowlingTeam());
                    int tmp=deliveries.getExtraRun();
                    tmp=tmp+tmpValue;
                    totalWindOfTeam.put(deliveries.getBowlingTeam(),tmp);
                }
            }
        });
        return totalWindOfTeam;
    }
    //-----------------no of extra run end----------------------


   //-----------------top economical bowler start--------------
   TreeMap<Float, String> topEconomicalBowlers (List<Match> matchList,List<Deliveries>deliveriesList){
       TreeMap<Float,String>topEconomicBowler=new TreeMap<>();
       TreeMap<String ,Integer>totalOver=new TreeMap<>();
       TreeMap<String,Integer>totalRun=new TreeMap<>();
       ArrayList<Integer> id2015;
       int Year=Constants.Year2015;
       id2015=getYearId(matchList,Year);
       deliveriesList.forEach(deliveries -> {
           int id=deliveries.getId();
           if(id2015.contains(id))
           {
               if(totalOver.containsKey(deliveries.getBowler()))
               {
                   int tmp=totalOver.get(deliveries.getBowler());
                   tmp=tmp+1;
                   totalOver.put(deliveries.getBowler(),tmp);
               }
               else
               {
                   totalOver.put(deliveries.getBowler(),1);
               }

               if(totalRun.containsKey(deliveries.getBowler()))
               {
                   int tmp=totalRun.get(deliveries.getBowler());
                   int tmpValue=deliveries.getTotalRun();
                   tmp=tmp+tmpValue;
                   totalRun.put(deliveries.getBowler(),tmp);
               }
               else
               {
                   int tmp1=deliveries.getTotalRun();
                   totalRun.put(deliveries.getBowler(),tmp1);
               }
           }
       });

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

//    //-----------------top economical bowler end----------------

//    //-----------------for getting id start---------------------
    private static ArrayList<Integer>getYearId(List<Match> matchFile,int year)
    {
        ArrayList<Integer>id=new ArrayList<>();
        matchFile.forEach(match -> {
            int yearId=match.getId();
            if(match.getSession()==year)
            {
                id.add(yearId);
            }
        });
        return id;
    }
    //-----------------for getting id end-----------------------
}