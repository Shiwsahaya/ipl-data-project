public final class Constants {
   public static String noOfMatch="select season, count(m_id) as total_match_played from matches group by season order by season ASC";
    public static String noOfWonMatch="select winner, count(m_id) as total_wins from matches where winner is not null group by winner";
    public static  String extraRun="select bowling_team,sum(cast(extra_runs as int)) as Total_extra_runs from deliveries where id in(select m_id from matches where season='2016') group by bowling_team";
    public static String topBowler="select bowler, cast(sum(cast(total_runs as float))/((count(cast(ball as float)))/6.0)as decimal(10,2)) as economy from deliveries where id in(select m_id from matches where season='2015') group by bowler order by economy limit 10";

}
