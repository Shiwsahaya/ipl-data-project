import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class MatchDeliveries {
    private List<String[]> fileListMatch=null;
    private List<String []>fileListDelveries=null;
    static int matchesId=0;
    static int bowlingTeam=3;
    static int extraRun=16;
    static int bowler=8;
    static int sessionColumn=1;
    static int totalRun=17;
    static String fileMatches="matches.csv";
    static String fileDelveries="deliveries.csv";
    MatchDeliveries()
    {
        ReadFile ob=new ReadFile();
        fileListMatch=ob.getFileData(fileMatches);
        fileListDelveries=ob.getFileData(fileDelveries);
    }
    public List<String[]>getCsvFile()
    {
        return fileListMatch;
    }
    public List<String[]>getDelveiesFile()
    {
        return fileListDelveries;
    }

    //-----------------no of extra run start--------------------
    public static TreeMap<String,Integer> noOfExtraRun(List<String[]> matchFile,List<String []>delveryFile){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap<>();
        ArrayList<String>id2016=new ArrayList<>();
        id2016=getYearId(matchFile,"2016");
        for(String[]winner:delveryFile)
        {
            String id=winner[matchesId];
            if(id2016.contains(id))
            {
                if(!totalWindOfTeam.containsKey(winner[bowlingTeam]))
                {
                    int tmp=Integer.parseInt(winner[extraRun]);
                    totalWindOfTeam.put(winner[bowlingTeam],tmp);
                }
                else {
                    int value=totalWindOfTeam.get(winner[bowlingTeam]);
                    int tmp=Integer.parseInt(winner[extraRun]);
                    tmp=tmp+value;
                    totalWindOfTeam.put(winner[bowlingTeam],tmp);
                }
            }
        }
        return totalWindOfTeam;
    }
    //-----------------no of extra run end----------------------

    //-----------------top economical bowler start--------------
    public static TreeMap<Float,String> topEconomicalBowlers(List<String[]> matchFile,List<String []>deliveriesFile){
        TreeMap<String ,Integer>tOver=new TreeMap<>();
        TreeMap<String,Integer>tRun=new TreeMap<>();
        TreeMap<Float,String>top=new TreeMap<>();
        ArrayList<String>id2015=new ArrayList<>();
        id2015=getYearId(matchFile,"2015");
        for(String[]winner:deliveriesFile)
        {
            String id=winner[matchesId];
            if(id2015.contains(id))
            {
                if (tOver.containsKey(winner[bowler])) {
                    int tmp = tOver.get(winner[bowler]);
                    tmp = tmp + 1;
                    tOver.put(winner[bowler], tmp);
                }
                else {
                    tOver.put(winner[bowler], 1); //over 4 index
                }
                if(tRun.containsKey(winner[bowler]))
                {
                    int tmp=tRun.get(winner[bowler]);
                    int tmp1=Integer.parseInt(winner[totalRun]);
                    tmp=tmp+tmp1;
                    tRun.put(winner[bowler],tmp);
                }
                else {
                    int tmp1=Integer.parseInt(winner[totalRun]);
                    tRun.put(winner[bowler],tmp1);
                }
            }
        }
        for (Map.Entry mapElement : tRun.entrySet()) {
            String key = (String)mapElement.getKey();
            int run = (int)mapElement.getValue();
            float over=(float)tOver.get(key);
            over=over/(float)6;
            float comp=(float) run/(float) over;
            top.put(comp,key);
        }
        return top;
    }

    //-----------------top economical bowler end----------------


    //-----------------for getting id start---------------------
    public static ArrayList<String>getYearId(List<String[]> matchFile,String year)
    {
        ArrayList<String>id=new ArrayList<>();
        for(String[]winner:matchFile)
        {
            String yearId=winner[matchesId];
            if(winner[sessionColumn].equals(year))
                id.add(yearId);
        }
        return id;
    }
    //-----------------for getting id end-----------------------

    }


