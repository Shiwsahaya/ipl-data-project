import java.sql.*;
import static java.lang.System.out;
public class Con {
    Connection con;
   public Connection createConnection()
   {
       Connection con=null;
       try{
           Class.forName("org.postgresql.Driver");
           con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","2214@11");
           if(con==null)
               System.out.println("Database not Connected");
       }catch(Exception e){ out.println(e);
       }
       return con;
   }

}
