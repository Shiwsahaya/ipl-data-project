import java.util.List;
class Deliveries {
    private int id;
    private String bowlingTeam;
    private String bowler;
    private int extraRun;
    private int totalRun;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public int getExtraRun() {
        return extraRun;
    }

    public void setExtraRun(int extraRun) {
        this.extraRun = extraRun;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }
}