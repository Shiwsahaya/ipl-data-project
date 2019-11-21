import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static int winnerTeamColumn=10;
    static int sessionColumn=1;
    static String cvsSplitBy = ",";
    static int matchesId=0;
    static int bowlingTeam=3;
    static int extraRun=16;
    static int bowler=8;
    static int totalRun=17;

    public static TreeMap<String,Integer>noOfMatches(String matchesFile){
        TreeMap<String,Integer>totalMatches=new TreeMap();
        try (BufferedReader matchesFile1 = new BufferedReader(new FileReader(matchesFile))) {
            String matchesLine=matchesFile1.readLine();
            while ((matchesLine = matchesFile1.readLine()) != null) {
                String[] winner = matchesLine.split(cvsSplitBy);
                if(winner[sessionColumn].equals(""))
                    continue;
                if(totalMatches.containsKey(winner[sessionColumn]))
                {
                    int MatchesCount=totalMatches.get(winner[sessionColumn]);
                    MatchesCount=MatchesCount+1;
                    totalMatches.put(winner[sessionColumn],MatchesCount);
                }
                else
                {
                    totalMatches.put(winner[sessionColumn],1);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalMatches;
    }


    public static TreeMap<String,Integer>noOfWonMatch(String matchesFile){
        TreeMap<String,Integer>totalWindOfTeam=new TreeMap();
        try (BufferedReader matchesFile1 = new BufferedReader(new FileReader(matchesFile))) {
            String matchesLine=matchesFile1.readLine();
            while ((matchesLine = matchesFile1.readLine()) != null) {
                String[] winner = matchesLine.split(cvsSplitBy);
                if(winner[winnerTeamColumn].equals(""))
                    continue;
                if(totalWindOfTeam.containsKey(winner[winnerTeamColumn]))
                {
                    int MatchesCount=totalWindOfTeam.get(winner[winnerTeamColumn]);
                    MatchesCount=MatchesCount+1;
                    totalWindOfTeam.put(winner[winnerTeamColumn],MatchesCount);
                }
                else
                {
                    totalWindOfTeam.put(winner[winnerTeamColumn],1);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return totalWindOfTeam;
    }


    public static TreeMap<String,Integer>noOfExtraRun(String matchesFile,String deliveriesFile) {
        TreeMap<String, Integer> totalWindOfTeam = new TreeMap();
        ArrayList<String>id2016=new ArrayList<>();
        String year="2016";
        id2016=getYearId(matchesFile,year);
        try (BufferedReader deliveriesFile1 = new BufferedReader(new FileReader(deliveriesFile))) {
            String deliveriesLine = deliveriesFile1.readLine();
            while ((deliveriesLine = deliveriesFile1.readLine()) != null) {
                String[] winner = deliveriesLine.split(cvsSplitBy);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalWindOfTeam;
    }

    public static TreeMap<Float,String>topEconomicalBowlers(String matchesFile,String deliveriesFile) {
        TreeMap<String, String> totalWindOfTeam = new TreeMap();
        ArrayList<String>id2015=new ArrayList<>();
        String year="2015";
        id2015=getYearId(matchesFile,year);

        TreeMap<String ,Integer>tOver=new TreeMap<>();
        TreeMap<String,Integer>tRun=new TreeMap<>();
        TreeMap<Float,String>top=new TreeMap<>();
        try (BufferedReader deliveriesFile1 = new BufferedReader(new FileReader(deliveriesFile))) {
            String deliveriesLine = deliveriesFile1.readLine();
            while ((deliveriesLine = deliveriesFile1.readLine()) != null) {
                String[] winner = deliveriesLine.split(cvsSplitBy);
                String id=winner[matchesId];
                if(id2015.contains((id))) {
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return top;
    }


    public static ArrayList<String>getYearId(String matchesFile,String year)
    {
        ArrayList<String>id=new ArrayList<>();
        try (BufferedReader matchesFile1 = new BufferedReader(new FileReader(matchesFile))) {
            String matchesLine = matchesFile1.readLine();
            while ((matchesLine = matchesFile1.readLine()) != null) {
                String[] winner = matchesLine.split(cvsSplitBy);
                if(winner[sessionColumn].equals("2016"))
                {
                    id.add(winner[matchesId]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }
    public static void main(String args[]) throws IOException {
        String matchesFile = "fileCsv/matches.csv";
        String deliveriesFile="fileCsv/deliveries.csv";

        TreeMap<String,Integer>map=new TreeMap<String, Integer>();
        map=noOfMatches(matchesFile);
        System.out.println("Year\tNoOFMatches");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + "\t" + value);
        }
        System.out.println("*****************************************************************************");

        map=noOfWonMatch(matchesFile);
        System.out.println("TeamName\tNoOfWonMatch");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
        System.out.println("*****************************************************************************");

        map=noOfExtraRun(matchesFile,deliveriesFile);
        System.out.println("TeamName\tGivenExtraRunIn2016");
        for (Map.Entry mapElement : map.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " : " + value);
        }
        System.out.println("*****************************************************************************");

        TreeMap<Float,String>economy=new TreeMap<>();
        economy=topEconomicalBowlers(matchesFile,deliveriesFile);
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