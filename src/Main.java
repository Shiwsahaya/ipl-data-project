import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static void printResult(LinkedHashMap<?, ?> data)
    {
        for (Map.Entry mapElement : data.entrySet()) {
            System.out.println(mapElement.getKey()+"\t"+ mapElement.getValue());
        }
        System.out.println("*****************************************************************************");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Services services=new Services();
        LinkedHashMap<String,String> mapForResult;
        mapForResult= services.executeQuery(Constants.NO_OF_MATCHES);
        printResult(mapForResult);

        mapForResult= services.executeQuery(Constants.NO_OF_WON_MATCHES);
        printResult(mapForResult);

        mapForResult= services.executeQuery(Constants.EXTRA_RUN,Constants.YEAR_16);
        printResult(mapForResult);

        mapForResult= services.executeQuery(Constants.TOP_BOWLER,Constants.YEAR_15);
        printResult(mapForResult);

    }
}
