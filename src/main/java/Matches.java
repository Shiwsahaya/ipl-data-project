import java.util.List;
import java.util.TreeMap;

    class Matches {
    private  List<String[]> fileList;
    Matches()
    {
        String file=Constants.FILE_MATCHES;
        ReadFile ob=new ReadFile();
        fileList=ob.getFileData(file);
    }
     List<String[]>getCsvFile()
    {
        return fileList;
    }
    //-------------------no of matches start-----------------------
     static TreeMap<String,Integer> noOfMatches(List<String[]> fileList){
        TreeMap<String,Integer>map=new TreeMap<>();
        for(String[]record:fileList)
        {
           if(map.containsKey(record[Constants.SESSION]))
           {
               int tmp=map.get(record[Constants.SESSION]);
               tmp=tmp+1;
               map.put(record[Constants.SESSION],tmp);
           }
           else
           {
               map.put(record[Constants.SESSION],1);
           }
        }
        return  map;

    }
    //-------------------no of matches end-------------------------

    //-------------------no of won matches start-------------------------
     static TreeMap<String,Integer> noOfWonMatch(List<String[]> fileList){
        TreeMap<String,Integer>map=new TreeMap<>();
        for(String[]record:fileList)
        {
            if(record[Constants.WINNER_TEAM].equals(""))
                continue;
            if(map.containsKey(record[Constants.WINNER_TEAM]))
            {
                int tmp=map.get(record[Constants.WINNER_TEAM]);
                tmp=tmp+1;
                map.put(record[Constants.WINNER_TEAM],tmp);
            }
            else
            {
                map.put(record[Constants.WINNER_TEAM],1);
            }
        }
        return  map;

    }
    //-------------------no of won matches end---------------------------


}
