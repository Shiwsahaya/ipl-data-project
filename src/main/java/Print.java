import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import  java.util.*;
public class Print {

    public static TreeMap<String,Integer>noOfMatches(ArrayList<String >list)
    {
        int size=list.size();
        TreeMap<String,Integer>map=new TreeMap<>();
        for(int i=0;i<size;i++)
        {
            if(map.containsKey(list.get(i)))
            {
                int tmp=map.get(list.get(i));
                tmp=tmp+1;
                map.put(list.get(i),tmp);
            }
            else {
                map.put(list.get(i),1);
            }
        }

        return map;
    }


    public static TreeMap<String,Integer> noOfWonMatch(ArrayList<String>list)
    {
        int size=list.size();
        TreeMap<String,Integer>map=new TreeMap<>();
        for(int i=0;i<size;i++)
        {

            if((list.get(i)).equals(""))
                continue;
            if(!map.containsKey(list.get(i)))
            {
                map.put(list.get(i),1);
            }
            else
            {
                int tmp=map.get(list.get(i));
                tmp=tmp+1;
                map.put(list.get(i),tmp);
            }

        }
        return map;
    }


    public  static TreeMap<String,Integer> noOfExtraRun(ArrayList<String>list) throws IOException {
        BufferedReader deliveries = new BufferedReader(new FileReader("fileCsv/deliveries.csv"));
        String deliveriesLine = deliveries.readLine();
        TreeMap<String,Integer>map=new TreeMap<>();
        while ((deliveriesLine = deliveries.readLine()) != null && !deliveriesLine.isEmpty())
        {
            String[]fields= deliveriesLine.split(",");
            String id=fields[0];
            if(list.contains(id))
            {

                if(!map.containsKey(fields[3]))
                {
                    int tmp=Integer.parseInt(fields[16]);
                    map.put(fields[3],tmp);
                }
                else
                {
                    int value=map.get(fields[3]);
                    int tmp=Integer.parseInt((fields[16]));
                    tmp=tmp+value;
                    map.put(fields[3],tmp);
                }
            }

        }
       return map;

    }

    public  static TreeMap<Float,String> topEconomicalBowlers(ArrayList<String>list,BufferedReader br) throws IOException {
        int size=list.size();
        LinkedHashMap<String,Integer>tOver=new LinkedHashMap<String, Integer>();
        LinkedHashMap<String,Integer>tRun=new LinkedHashMap<String, Integer>();
        TreeMap<Float,String>top=new TreeMap<>();
        String line = br.readLine();
        while ((line = br.readLine()) != null && !line.isEmpty())
        {
            String[]fields= line.split(",");
            String id=fields[0];
            if(list.contains((id))) {
                if (tOver.containsKey(fields[8])) {
                    int tmp = tOver.get(fields[8]);
                    if(tmp!=Integer.parseInt(fields[4]));
                    {
                        tmp = tmp + 1;
                        tOver.put(fields[8], tmp);
                    }
                }
                else {
                    tOver.put(fields[8], 1); //over 4 index
                }

                if(tRun.containsKey(fields[8]))
                {
                    int tmp=tRun.get(fields[8]);
                    int tmp1=Integer.parseInt(fields[17]);
                    tmp=tmp+tmp1;
                    tRun.put(fields[8],tmp);
                }
                else {
                    int tmp1=Integer.parseInt(fields[17]);
                    tRun.put(fields[8],tmp1);
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
    public static  void main(String args[]) throws IOException {
        BufferedReader matchesFile = new BufferedReader(new FileReader("fileCsv/matches.csv"));
        String matchesLine = matchesFile.readLine();
        BufferedReader deliveries = new BufferedReader(new FileReader("fileCsv/deliveries.csv"));
        String deliveriesLine = deliveries.readLine();
        ArrayList<String>team1List=new ArrayList<>();
        ArrayList<String>team2List=new ArrayList<>();
        ArrayList<String>wonList=new ArrayList<>();
        ArrayList<String>session=new ArrayList<>();
        ArrayList<String>id2016=new ArrayList<>();
        ArrayList<String>id2015=new ArrayList<>();
        while ((matchesLine = matchesFile.readLine()) != null && !matchesLine.isEmpty()) {
            String[]fields= matchesLine.split(",");
            String id=fields[0];
            String ses=fields[1];
            String team1=fields[4];
            String won=fields[10];
            String str1=fields[1];
            if(str1.equals("2016"))
            {
                id2016.add(id);
            }
            if(str1.equals("2015"))
            {
                id2015.add(id);
            }

            wonList.add(won);
            team1List.add(team1);
            session.add(ses);
        }
        TreeMap<String,Integer>map=new TreeMap<String, Integer>();

        map=noOfMatches(session);
        System.out.println("Year\tNoOFMatches");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + "\t" + value);
        }
        System.out.println("*****************************************************************************");

        System.out.println("TeamName\tNoOfWonMatch");
        map=noOfWonMatch(wonList);
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
        System.out.println("*****************************************************************************");

        System.out.println("TeamName\tGivenExtraRunIn2016");
        map=noOfExtraRun(id2016);
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
        System.out.println("*****************************************************************************");


        TreeMap<Float,String>economy=new TreeMap<Float, String>();
        economy=topEconomicalBowlers(id2015,deliveries);
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
