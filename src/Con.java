import java.sql.*;
import static java.lang.System.out;
public class Con {
    Connection con;
   public Connection createConnection()
   {
       Connection con=null;
       try{
           Class.forName("org.postgresql.Driver");
           con =  DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
           if(con==null)
               System.out.println("Database not Connected");
       }catch(Exception e){ out.println(e);
       }
       return con;
   }

}
