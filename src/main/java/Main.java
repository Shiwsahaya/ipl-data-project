import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
<<<<<<< HEAD
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

=======
import sun.reflect.generics.tree.Tree;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
public class Main {
    public static void main(String[] arg) throws IOException, CsvException {
        Services services=new Services();
        List<Match> matchList = getMatches();
        List<Deliveries> deliveriesList= getDeliveries();
<<<<<<< HEAD
        TreeMap<String,Integer>mapForResult;

        mapForResult=services.noOfMatches(matchList);
        System.out.println("Year"+"\t"+"No. Of Played Matches");
        printData(mapForResult);

        mapForResult=services.noOfWonMatches(matchList);
        System.out.println("Team Name"+"\t"+"No. Of Won Match");
        printData(mapForResult);

        mapForResult=services.noOfExtraRun(matchList,deliveriesList);
        System.out.println("Team Name"+"\t"+"Given No. Of Extra Run in 2016");
        printData(mapForResult);

        TreeMap<Float,String>bestEconomyBowler;
        System.out.println("Economy Rate"+"\t"+"Bowler Name");
        bestEconomyBowler=services.topEconomicalBowlers(matchList,deliveriesList);
        printData(bestEconomyBowler);
    }

    private static void printData(TreeMap<?, ?> data)
    {
        for (Map.Entry mapElement : data.entrySet()) {
            System.out.println(mapElement.getKey()+"\t"+ mapElement.getValue());
=======
        TreeMap<String,Integer>mapForResult=new TreeMap<>();

        mapForResult=services.noOfMatches(matchList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("In "+key+" Total Played Match: " + value);
        }
        System.out.println("*****************************************************************************");


        mapForResult=services.noOfWonMatches(matchList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println(key + " Total Win Match: " + value);
        }
        System.out.println("*****************************************************************************");


        mapForResult=services.noOfExtraRun(matchList,deliveriesList);
        for (Map.Entry mapElement : mapForResult.entrySet()) {
            String key = (String)mapElement.getKey();
            int value = ((int)mapElement.getValue());
            System.out.println("Total Extra run given by "+key +" In 2016: "+ value);
        }
        System.out.println("*****************************************************************************");


        TreeMap<Float,String>bestEconomyBowler=new TreeMap<>();
        bestEconomyBowler=services.topEconomicalBowlers(matchList,deliveriesList);
        int index=0;
        for (Map.Entry mapElement : bestEconomyBowler.entrySet()) {
            float key = (Float)mapElement.getKey();
            String value = (String)mapElement.getValue();
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(value + " Bowling Economy in 2016: " + df.format(key));
            index++;
            if(index>10)
                break;
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
        }
        System.out.println("*****************************************************************************");
    }

    private static  List<String[]> parseCSV(String filePath) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
<<<<<<< HEAD
        return csvReader.readAll();
=======
        List<String[]> fileList = csvReader.readAll();
        return fileList;
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
    }

    private static List<Match> getMatches() throws IOException, CsvException {
        List<String[]> csvList = parseCSV(Constants.FILE_MATCHES);
        csvList.remove(0);
        List<Match> matchesList = new ArrayList<>();
        for (String[] line : csvList) {
            Match match = new Match();
<<<<<<< HEAD
            match.setMatchId(Integer.parseInt(line[Constants.MATCHES_ID]));
            match.setSession(Integer.parseInt(line[Constants.SESSION]));
            match.setBowlingTeam(line[Constants.BOWLING_TEAM]);
            match.setBowlerName(line[Constants.BOWLER_NAME]);
=======
            match.setId(Integer.parseInt(line[Constants.MATCHES_ID]));
            match.setSession(Integer.parseInt(line[Constants.SESSION]));
            match.setBowlingTeam(line[Constants.BOWLING_TEAM]);
            match.setBowler(line[Constants.BOWLER_NAME]);
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
            match.setWinnerTeam(line[Constants.WINNER_TEAM]);
            matchesList.add(match);
        }
        return matchesList;
    }


        private static List<Deliveries> getDeliveries () throws IOException, CsvException {
            List<String[]> csvList = parseCSV(Constants.FILE_DELIVERIES);
            csvList.remove(0);
            List<Deliveries> deliveriesList = new ArrayList<>();
            for (String[] line : csvList) {
                Deliveries deliveries = new Deliveries();
<<<<<<< HEAD
                deliveries.setDeliveriesId(Integer.parseInt(line[Constants.MATCHES_ID]));
                deliveries.setBowlingTeam(line[Constants.BOWLING_TEAM]);
                deliveries.setBowlerName(line[Constants.BOWLER_NAME]);
=======
                deliveries.setId(Integer.parseInt(line[Constants.MATCHES_ID]));
                deliveries.setBowlingTeam(line[Constants.BOWLING_TEAM]);
                deliveries.setBowler(line[Constants.BOWLER_NAME]);
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
                deliveries.setExtraRun(Integer.parseInt(line[Constants.EXTRA_RUN]));
                deliveries.setTotalRun(Integer.parseInt(line[Constants.TOTAL_RUN]));
                deliveriesList.add(deliveries);
            }
            return deliveriesList;
        }
    }

