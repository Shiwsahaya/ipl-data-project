import java.sql.*;
import static java.lang.System.out;
public class Main {
    private static void queryResult(ResultSet rs) throws SQLException {
        while(rs.next()) {
            out.println(rs.getString(1) + "  " + rs.getString(2));
        }
    }
    public static void main(String[] arsg) throws SQLException {
        Con ob=new Con();
        Connection con=ob.createConnection();
        Statement noOfMatchStatement= con.createStatement();
        Statement noOfWonMatchStatement= con.createStatement();
        Statement extraRunStatement= con.createStatement();
        Statement bestBowlerStatement= con.createStatement();

        ResultSet noOfMatchRS=noOfMatchStatement.executeQuery(Constants.noOfMatch);
        ResultSet noOfWonMatchRS=noOfWonMatchStatement.executeQuery(Constants.noOfWonMatch);
        ResultSet extraRunRS=extraRunStatement.executeQuery(Constants.extraRun);
        ResultSet bewBowlerRS=bestBowlerStatement.executeQuery(Constants.topBowler);
        queryResult(noOfMatchRS);
        out.println("*******************************************************");
        queryResult(noOfWonMatchRS);
        out.println("*******************************************************");
        queryResult(extraRunRS);
        out.println("*******************************************************");
        queryResult(bewBowlerRS);
        out.println("*******************************************************");
        con.close();
    }
}
