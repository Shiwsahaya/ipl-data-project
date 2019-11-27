import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class Services {
    public static LinkedHashMap<String ,String> executeQuery(String sql) throws SQLException, ClassNotFoundException {
        String str="";
        return executeQuery(sql,str);
    }
    public static LinkedHashMap<String,String> executeQuery(String sql, String change) throws SQLException, ClassNotFoundException {
        Connection connection;
        Conn con=new Conn();
        connection=con.createConnection();
        LinkedHashMap<String ,String>queryResult=new LinkedHashMap<>();
        assert connection != null;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet;
        if(!change.equals(""))
        {
            preparedStatement.setString(1,change);
        }
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next())
        {
            queryResult.put(resultSet.getString(1),resultSet.getString(2));
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();
        return queryResult;
    }
}
