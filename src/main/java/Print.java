import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  java.util.*;
public class Print {


    public  static  void noOfMatches(ArrayList<String >list)
    {
        int size=list.size();
        int count=0;
        for(int i=0;i<size;i++)
        {
            if(!list.get(i).equals(""))    //if any row empty in the coloumn then count not increase
                count++;
        }
        System.out.println("1. No. of matched played per year:" +count);
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

                if(!map.containsKey(fields[2]))
                {
                    int tmp=Integer.parseInt(fields[16]);
                    map.put(fields[2],tmp);
                }
                else
                {
                    int value=map.get(fields[2]);
                    int tmp=Integer.parseInt((fields[16]));
                    tmp=tmp+value;
                    map.put(fields[2],tmp);
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
    public static  void main(String args[]) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("fileCsv/matches.csv"));
        ArrayList<String>team1List=new ArrayList<>();
        ArrayList<String>team2List=new ArrayList<>();
        ArrayList<String>wonList=new ArrayList<>();
        ArrayList<String>session=new ArrayList<>();
        //for third query
        ArrayList<String>id2016=new ArrayList<>();
        HashMap<String,String>map2=new HashMap<>();
        //third query end
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

            wonList.add(won);
            team1List.add(team1);
            session.add(ses);
        }
       // System.out.println(id2016);
        System.out.println("1st Query");
        noOfMatches(team1List);
        System.out.println();


        System.out.println("2nd Query");
        noOfWonMatch(wonList);
        System.out.println();

        System.out.println("3rd Query:Extra run");
        noOfExtraRun(id2016);
        System.out.println();

        


    }

}
