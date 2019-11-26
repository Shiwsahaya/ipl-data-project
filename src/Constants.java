public final class Constants {
    public static final String NO_OF_MATCHES="select season, count(m_id) as total_match_played from matches group by season order by season ASC";
    public static final  String NO_OF_WON_MATCHES="select winner, count(m_id) as total_wins from matches where winner is not null group by winner";
    public static  final  String EXTRA_RUN="select bowling_team,sum(cast(extra_runs as int)) as Total_extra_runs from deliveries where id in(select m_id from matches where season=?) group by bowling_team";
    public static final String TOP_BOWLER="select bowler, cast(sum(cast(total_runs as float))/((count(cast(ball as float)))/6.0)as decimal(10,2)) as economy from deliveries where id in(select m_id from matches where season=?) group by bowler order by economy limit 10";
    public static  final String URL="jdbc:postgresql://localhost:5432/postgres";
    public static  final  String USER="postgres";
    public static final  String PASSWORD="2214@11";
    public static final  String YEAR_16="2016";
    public static final  String YEAR_15="2015";


}
