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
   private static LinkedHashMap<String ,String>parseLine(String sql) throws SQLException {
       String str="";
       return parseLine(sql,str);
   }
   private static LinkedHashMap<String,String>parseLine( String sql, String change) throws SQLException {
       Connection con=null;
       try{
           Class.forName("org.postgresql.Driver");
           con =  DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
           if(con==null)
               System.out.println("Database not Connected");
       }catch(Exception e){ out.println(e);
       }
       LinkedHashMap<String ,String>queryResult=new LinkedHashMap<>();
       PreparedStatement preparedStatement=con.prepareStatement(sql);
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
      return queryResult;
   }
    public static void main(String[] args) throws SQLException {
        LinkedHashMap<String,String> mapForResult;
        mapForResult=parseLine(Constants.NO_OF_MATCHES);
        printResult(mapForResult);

        mapForResult=parseLine(Constants.NO_OF_WON_MATCHES);
        printResult(mapForResult);

        mapForResult=parseLine(Constants.EXTRA_RUN,Constants.YEAR_16);
        printResult(mapForResult);

        mapForResult=parseLine(Constants.TOP_BOWLER,Constants.YEAR_15);
        printResult(mapForResult);
    }
}
