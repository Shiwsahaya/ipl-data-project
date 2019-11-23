<<<<<<< HEAD
class Match {
    private int matchId;
    private int session;
    private String bowlingTeam;
    private String bowlerName;
    private String winnerTeam;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
=======
import java.util.List;
class Match {
    private int id;
    private int session;
    private String bowlingTeam;
    private String bowler;
    private String winnerTeam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

<<<<<<< HEAD
    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
=======
    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
>>>>>>> 4c9a1f5bf33bace51e28449a1b3633bfe87dd035
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }
}