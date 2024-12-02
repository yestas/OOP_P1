package Business;

public class Statistic {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private int koDone;
    private int koReceived;

    public Statistic(String name, int gamesPlayed, int gamesWon, int koDone, int koReceived) {
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.koDone = koDone;
        this.koReceived = koReceived;
    }
}

