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
       // System.out.println(list);
        int kxip=0,rcb=0,mi=0,kkr=0,srh=0,gl=0,dd=0,rps=0,csk=0,rr=0,other=0,dc=0,pw=0,ktk=0;
        int size=list.size();
        for(int i=0;i<size;i++)
        {
            if(list.get(i).contains("Punjab")||list.get(i).contains("punjab"))
                kxip++;
            else if(list.get(i).contains("Bangalore"))
                rcb++;
            else if(list.get(i).equals("Mumbai Indians"))
                mi++;
            else if(list.get(i).equals("Kolkata Knight Riders"))
                kkr++;
            else if(list.get(i).equals("Sunrisers Hyderabad"))
                srh++;
            else if(list.get(i).equals("Gujarat Lions"))
                gl++;
            else if(list.get(i).equals("Delhi Daredevils"))
                dd++;
            else if(list.get(i).contains("Pune"))
                rps++;
            else if(list.get(i).equals("Chennai Super Kings"))
                csk++;
            else if(list.get(i).equals("Rajasthan Royals"))
                rr++;
            else if(list.get(i).equals("Deccan Chargers"))
                dc++;
            else if(list.get(i).equals("Kochi Tuskers Kerala"))
                ktk++;
            else if(list.get(i).equals(""))   //if any column not contain any value
               ;
            else
            {
                System.out.print(": other: "+list.get(i));
                other++;
            }


        }
        System.out.println("2.Number of matches won of all teams over all the years of IPL");
        System.out.println("Rising Pune Supergiant: "+rps);
        System.out.println("Kings XI Punjab: "+kxip);
        System.out.println("Sunrisers Hyderabad: "+srh);
        System.out.println("Mumbai Indians: "+mi);
        System.out.println("Kolkata Knight Riders: "+kkr);
        System.out.println("Gujarat Lions: "+gl);
        System.out.println("Delhi Daredevils: "+dd);
        System.out.println("Royal Challengers Bangalore"+rcb);
        System.out.println("Chennai Super Kings"+csk);
        System.out.println("Deccan Chargers: "+dc);
        System.out.println("Rajasthan Royals: "+rr);
        System.out.println("Kochi Tuskers Kerala: "+ktk);
        System.out.println("No. of team left (if any team left then other count increment): "+other);

    }
    public static  void main(String args[]) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("fileCsv/matches.csv"));
        ArrayList<String>idList=new ArrayList<>();
        ArrayList<String>team1List=new ArrayList<>();
        ArrayList<String>team2List=new ArrayList<>();
        ArrayList<String>wonList=new ArrayList<>();
        String line1 = br1.readLine();
        while ((line1 = br1.readLine()) != null && !line1.isEmpty()) {
            String[]fields= line1.split(",");
            String id=fields[0];
            String won=fields[10];
            String team1=fields[4];
            idList.add(id);
            wonList.add(won);
            team1List.add(team1);
        }
        //System.out.println(team1List);
        noOfMatches(team1List);
        noOfWonMatch(wonList);


    }

}
