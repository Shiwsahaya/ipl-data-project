import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.lang.System.out;

public class Main {
    private static void printResult(LinkedHashMap<?, ?> data)
    {
        for (Map.Entry mapElement : data.entrySet()) {
            System.out.println(mapElement.getKey()+"\t"+ mapElement.getValue());
        }
        System.out.println("*****************************************************************************");
    }
   private static LinkedHashMap<String ,String> executeQuery(String sql) throws SQLException {
       String str="";
       return executeQuery(sql,str);
   }
   private static LinkedHashMap<String,String> executeQuery(String sql, String change) throws SQLException {
       Connection connection=null;
       try{
           Class.forName("org.postgresql.Driver");
           connection =  DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
           if(connection==null)
               System.out.println("Database not Connected");
       }catch(Exception e){ out.println(e);
       }
       LinkedHashMap<String ,String>queryResult=new LinkedHashMap<>();
       assert connection != null;
       PreparedStatement preparedStatement=connection.prepareStatement(sql);
       ResultSet resultSet;
      if(change.equals(""))
      {
             resultSet=preparedStatement.executeQuery();
      }
      else
      {
          preparedStatement.setString(1,change);
          resultSet=preparedStatement.executeQuery();
      }
       while (resultSet.next())
       {
           queryResult.put(resultSet.getString(1),resultSet.getString(2));
       }
       connection.close();
       preparedStatement.close();
       resultSet.close();
       return queryResult;
   }
    public static void main(String[] args) throws SQLException {
        LinkedHashMap<String,String> mapForResult;
        mapForResult= executeQuery(Constants.NO_OF_MATCHES);
        printResult(mapForResult);

        mapForResult= executeQuery(Constants.NO_OF_WON_MATCHES);
        printResult(mapForResult);

        mapForResult= executeQuery(Constants.EXTRA_RUN,Constants.YEAR_16);
        printResult(mapForResult);

        mapForResult= executeQuery(Constants.TOP_BOWLER,Constants.YEAR_15);
        printResult(mapForResult);

    }
}
