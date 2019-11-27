import java.text.DecimalFormat;
import java.util.*;
class Services {

    //-------------------no of matches start----------------------

    TreeMap<String, Integer> noOfMatches (List<Match> matchList){
        TreeMap<String, Integer> noOfMatchesMap = new TreeMap<>();
        matchList.forEach(match -> {
            //System.out.println(match.getSession());
            if(noOfMatchesMap.containsKey(Integer.toString(match.getSession())))
            {
                int tmpValue=noOfMatchesMap.get(Integer.toString(match.getSession()));
                noOfMatchesMap.put(Integer.toString(match.getSession()),tmpValue+1);
            }
            else
            {
                noOfMatchesMap.put(Integer.toString(match.getSession()),1);
            }
        });
        return noOfMatchesMap;
    }

    //-------------------no of matches end-------------------------


    //-------------------no of won matches start-------------------------

    TreeMap<String, Integer> noOfWonMatches (List<Match> matchList){
        TreeMap<String, Integer> noOfWonMap = new TreeMap<>();
        matchList.forEach(match -> {
            if(!match.getWinnerTeam().equals(""))
            {
                if (noOfWonMap.containsKey(match.getWinnerTeam())) {
                    int tmpValue = noOfWonMap.get(match.getWinnerTeam());
                    noOfWonMap.put(match.getWinnerTeam(), tmpValue + 1);
                } else {
                    noOfWonMap.put(match.getWinnerTeam(), 1);
                }
            }
        });
        return noOfWonMap;

    }

    //-------------------no of won matches end---------------------------


    // -----------------no of extra run start--------------------

    TreeMap<String, Integer> noOfExtraRun (List<Match> matchList,List<Deliveries>deliveriesList){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap<>();
        ArrayList<Integer> id2016;
        int Year=Constants.Year2016;
        id2016=getYearId(matchList,Year);
        deliveriesList.forEach(deliveries -> {
            int matchId=deliveries.getDeliveriesId();
            if(id2016.contains(matchId))
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
            int id=deliveries.getDeliveriesId();
            if(id2015.contains(id))
            {
                if(totalOver.containsKey(deliveries.getBowlerName()))
                {
                    int tmp=totalOver.get(deliveries.getBowlerName());
                    tmp=tmp+1;
                    totalOver.put(deliveries.getBowlerName(),tmp);
                }
                else
                {
                    totalOver.put(deliveries.getBowlerName(),1);
                }

                if(totalRun.containsKey(deliveries.getBowlerName()))
                {
                    int tmp=totalRun.get(deliveries.getBowlerName());
                    int tmpValue=deliveries.getTotalRun();
                    tmp=tmp+tmpValue;
                    totalRun.put(deliveries.getBowlerName(),tmp);
                }
                else
                {
                    int tmp1=deliveries.getTotalRun();
                    totalRun.put(deliveries.getBowlerName(),tmp1);
                }
            }
        });

        for (Map.Entry mapElement : totalRun.entrySet()) {
            String key = (String) mapElement.getKey();
            int run = (int) mapElement.getValue();
            float over = (float) totalOver.get(key);
            over = over / (float) 6;
            float averageEconomy = (float) run / over;
            DecimalFormat df = new DecimalFormat("#.##"); //for taking decimal on two point
            String avgEcoOnTwoPointDecimal = df.format(averageEconomy);
            topEconomicBowler.put(Float.parseFloat(avgEcoOnTwoPointDecimal), key);
        }
        return topEconomicBowler;
    }

    //-----------------top economical bowler end----------------


    //-----------------for getting id start---------------------
    private static ArrayList<Integer>getYearId(List<Match> file,int year)
    {
        ArrayList<Integer>id=new ArrayList<>();
        file.forEach(match -> {
            int yearId=match.getMatchId();
            if(match.getSession()==year)
            {
                id.add(yearId);
            }
        });
        return id;
    }
    //-----------------for getting id end-----------------------
}