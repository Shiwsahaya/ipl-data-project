import java.util.List;
import java.util.TreeMap;

public class Matches {
    static int winnerTeamColumn=10;
    static int sessionColumn=1;
    static int matchesId=0;
    static int bowlingTeam=3;
    static int extraRun=16;
    static int bowler=8;
    static int totalRun=17;

    private  List<String[]> fileList=null;
    Matches()
    {
        String file="matches.csv";
        ReadFile ob=new ReadFile();
        fileList=ob.getFileData(file);
    }
    public List<String[]>getCsvFile()
    {
        return fileList;
    }
    //-------------------no of matches start-----------------------
    public static TreeMap<String,Integer> noOfMatches(List<String[]> fileList){
        TreeMap<String,Integer>map=new TreeMap<>();
        for(String[]record:fileList)
        {
           if(map.containsKey(record[sessionColumn]))
           {
               int tmp=map.get(record[sessionColumn]);
               tmp=tmp+1;
               map.put(record[sessionColumn],tmp);
           }
           else
           {
               map.put(record[sessionColumn],1);
           }
        }
        return  map;

    }
    //-------------------no of matches end-------------------------

    //-------------------no of won matches start-------------------------
    public static TreeMap<String,Integer> noOfWonMatch(List<String[]> fileList){
        TreeMap<String,Integer>map=new TreeMap<>();
        for(String[]record:fileList)
        {
            if(record[winnerTeamColumn].equals(""))
                continue;
            if(map.containsKey(record[winnerTeamColumn]))
            {
                int tmp=map.get(record[winnerTeamColumn]);
                tmp=tmp+1;
                map.put(record[winnerTeamColumn],tmp);
            }
            else
            {
                map.put(record[winnerTeamColumn],1);
            }
        }
        return  map;

    }
    //-------------------no of won matches end---------------------------


}
