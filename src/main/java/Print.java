import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.util.*;
public class Print {
    public  static  void noOfMatches(ArrayList<String >list)
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

        System.out.println("----------------------------------");
        System.out.println("Year\t"+"Total Match");
        System.out.println("----------------------------------");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + "\t" + value);
        }
    }


    public static void noOfWonMatch(ArrayList<String>list)
    {
        int size=list.size();
        HashMap<String,Integer>map=new HashMap<>();
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
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
    }


    public  static void noOfExtraRun(ArrayList<String>list) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fileCsv/deliveries.csv"));
        String line = br.readLine();
        HashMap<String,Integer>map=new HashMap<>();
        while ((line = br.readLine()) != null && !line.isEmpty())
        {
            String[]fields= line.split(",");
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
      //  System.out.println(map);
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }

    }

    public  static void topEconomicalBowlers(ArrayList<String>list) throws IOException {
        int size=list.size();
        LinkedHashMap<String,Integer>tOver=new LinkedHashMap<String, Integer>();
        LinkedHashMap<String,Integer>tRun=new LinkedHashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader("fileCsv/deliveries.csv"));
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
        float min=(float) Integer.MAX_VALUE;
        String bowlerName="";
        int totalOver=0;
        int totalRun=0;
        for (Map.Entry mapElement : tRun.entrySet()) {
            String key = (String)mapElement.getKey();
            int run = (int)mapElement.getValue();
            int over=(int)tOver.get(key);
            over=over/6;
            float comp=(float) run/(float) over;
            if(comp<min) {
                min=comp;
                bowlerName=key;
                totalOver=over;
                totalRun=run;
            }
        }
        System.out.println("Bowler Name: "+bowlerName);
        System.out.println("Total No. Of Over: "+totalOver);
        System.out.println("Toatal No. Given Run: "+totalRun);
        System.out.println(totalOver);
     //   System.out.println(tRun);
       // System.out.println(tOver);
    }
    public static  void main(String args[]) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("fileCsv/matches.csv"));
        ArrayList<String>team1List=new ArrayList<>();
        ArrayList<String>team2List=new ArrayList<>();
        ArrayList<String>wonList=new ArrayList<>();
        ArrayList<String>session=new ArrayList<>();

        ArrayList<String>id2016=new ArrayList<>();
        ArrayList<String>id2015=new ArrayList<>();
        String line1 = br1.readLine();
        while ((line1 = br1.readLine()) != null && !line1.isEmpty()) {
            String[]fields= line1.split(",");
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
       // System.out.println(id2016);
        System.out.println(" 1st. Number of matches played per year of all the years in IPL.");
        noOfMatches(session);
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("2nd. Number of matches won of all teams over all the years of IPL");
        noOfWonMatch(wonList);
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("3rd. For the year 2016 get the extra runs conceded per team.");
        noOfExtraRun(id2016);
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("4th. For the year 2015 get the top economical bowlers");
        topEconomicalBowlers(id2015);
        System.out.println("*****************************************************************************");
    }

}
