import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws IOException, CsvException {
        Services services=new Services();
        List<Match> matchList = getMatches();
        List<Deliveries> deliveriesList= getDeliveries();
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
        }
        System.out.println("*****************************************************************************");
    }

    private static  List<String[]> parseCSV(String filePath) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        return csvReader.readAll();
    }

    private static List<Match> getMatches() throws IOException, CsvException {
        List<String[]> csvList = parseCSV(Constants.FILE_MATCHES);
        csvList.remove(0);
        List<Match> matchesList = new ArrayList<>();
        for (String[] line : csvList) {
            Match match = new Match();
            match.setMatchId(Integer.parseInt(line[Constants.MATCHES_ID]));
            match.setSession(Integer.parseInt(line[Constants.SESSION]));
            match.setBowlingTeam(line[Constants.BOWLING_TEAM]);
            match.setBowlerName(line[Constants.BOWLER_NAME]);
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
                deliveries.setDeliveriesId(Integer.parseInt(line[Constants.MATCHES_ID]));
                deliveries.setBowlingTeam(line[Constants.BOWLING_TEAM]);
                deliveries.setBowlerName(line[Constants.BOWLER_NAME]);
                deliveries.setExtraRun(Integer.parseInt(line[Constants.EXTRA_RUN]));
                deliveries.setTotalRun(Integer.parseInt(line[Constants.TOTAL_RUN]));
                deliveriesList.add(deliveries);
            }
            return deliveriesList;
        }
    }

