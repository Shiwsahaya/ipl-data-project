import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    java.sql.Connection connection;
    public java.sql.Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection =  DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
        if(connection==null)
            System.out.println("Database not Connected");
        return connection;
    }
}
