<<<<<<< HEAD
import java.text.DecimalFormat;
import java.util.*;
class Services {

    //-------------------no of matches start----------------------

=======
import java.util.*;

class Services {

    //-------------------no of matches start----------------------
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
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
<<<<<<< HEAD

=======
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
    //-------------------no of matches end-------------------------


    //-------------------no of won matches start-------------------------
<<<<<<< HEAD

    TreeMap<String, Integer> noOfWonMatches (List<Match> matchList){
        TreeMap<String, Integer> map = new TreeMap<>();
        matchList.forEach(match -> {
            if(!match.getWinnerTeam().equals(""))
            {
=======
    TreeMap<String, Integer> noOfWonMatches (List<Match> matchList){
        TreeMap<String, Integer> map = new TreeMap<>();
        matchList.forEach(match -> {
            //System.out.println(match.getSession());
            if(match.getWinnerTeam().equals(""))
                ;
            else {
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
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

<<<<<<< HEAD

    // -----------------no of extra run start--------------------

=======
    // -----------------no of extra run start--------------------
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
        TreeMap<String, Integer> noOfExtraRun (List<Match> matchList,List<Deliveries>deliveriesList){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap<>();
        ArrayList<Integer> id2016;
        int Year=Constants.Year2016;
        id2016=getYearId(matchList,Year);
        deliveriesList.forEach(deliveries -> {
<<<<<<< HEAD
            int matchId=deliveries.getDeliveriesId();
            if(id2016.contains(matchId))
=======
            int id=deliveries.getId();
            if(id2016.contains(id))
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
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
<<<<<<< HEAD

=======
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
    //-----------------no of extra run end----------------------


   //-----------------top economical bowler start--------------
<<<<<<< HEAD

=======
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
   TreeMap<Float, String> topEconomicalBowlers (List<Match> matchList,List<Deliveries>deliveriesList){
       TreeMap<Float,String>topEconomicBowler=new TreeMap<>();
       TreeMap<String ,Integer>totalOver=new TreeMap<>();
       TreeMap<String,Integer>totalRun=new TreeMap<>();
       ArrayList<Integer> id2015;
       int Year=Constants.Year2015;
       id2015=getYearId(matchList,Year);
       deliveriesList.forEach(deliveries -> {
<<<<<<< HEAD
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
=======
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
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
               }
               else
               {
                   int tmp1=deliveries.getTotalRun();
<<<<<<< HEAD
                   totalRun.put(deliveries.getBowlerName(),tmp1);
=======
                   totalRun.put(deliveries.getBowler(),tmp1);
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
               }
           }
       });

       for (Map.Entry mapElement : totalRun.entrySet()) {
<<<<<<< HEAD
               String key = (String) mapElement.getKey();
               int run = (int) mapElement.getValue();
               float over = (float) totalOver.get(key);
               over = over / (float) 6;
               float averageEconomy = (float) run / over;
               DecimalFormat df = new DecimalFormat("#.##"); //for taking decimal on two point
               String avgEcoOnTwoPointDecimal = df.format(averageEconomy);
               topEconomicBowler.put(Float.parseFloat(avgEcoOnTwoPointDecimal), key);
=======
           String key = (String)mapElement.getKey();
           int run = (int)mapElement.getValue();
           float over=(float)totalOver.get(key);
           over=over/(float)6;
           float comp=(float) run/over;
           topEconomicBowler.put(comp,key);
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
       }
       return topEconomicBowler;
   }

<<<<<<< HEAD
    //-----------------top economical bowler end----------------


    //-----------------for getting id start---------------------
    private static ArrayList<Integer>getYearId(List<Match> file,int year)
    {
        ArrayList<Integer>id=new ArrayList<>();
        file.forEach(match -> {
            int yearId=match.getMatchId();
=======
//    //-----------------top economical bowler end----------------

//    //-----------------for getting id start---------------------
    private static ArrayList<Integer>getYearId(List<Match> matchFile,int year)
    {
        ArrayList<Integer>id=new ArrayList<>();
        matchFile.forEach(match -> {
            int yearId=match.getId();
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
            if(match.getSession()==year)
            {
                id.add(yearId);
            }
        });
        return id;
    }
    //-----------------for getting id end-----------------------
}