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
        PreparedStatement noOfMatchPS=con.prepareStatement(Constants.NO_OF_MATCHES);
        ResultSet noOfMatchRS=noOfMatchPS.executeQuery();
        queryResult(noOfMatchRS);
        out.println("*******************************************************");

        PreparedStatement noOfWonMatchPS=con.prepareStatement(Constants.NO_OF_WON_MATCHES);
        ResultSet noOfWonMatchRS=noOfWonMatchPS.executeQuery();
        queryResult(noOfWonMatchRS);
        out.println("*******************************************************");

        PreparedStatement extraRunPS=con.prepareStatement(Constants.EXTRA_RUN);
        extraRunPS.setString(1,Constants.YEAR_16);
        ResultSet extraRunRS=extraRunPS.executeQuery();
        queryResult(extraRunRS);
        out.println("*******************************************************");

        PreparedStatement bestBowlerPS=con.prepareStatement(Constants.TOP_BOWLER);
        bestBowlerPS.setString(1,Constants.YEAR_15);
        bestBowlerPS.setInt(2,Constants.limit);
        ResultSet bestBowlerRS=bestBowlerPS.executeQuery();
        queryResult(bestBowlerRS);
        out.println("*******************************************************");
    }
}
