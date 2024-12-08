package Business;

/**
 * Class for the statistics of a team.
 */
public class Statistic {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private int koDone;
    private int koReceived;

    /**
     * Constructor for the Statistic class.
     * @param name The name of the player.
     * @param gamesPlayed The number of games played.
     * @param gamesWon The number of games won.
     * @param koDone The number of KOs done.
     * @param koReceived The number of KOs received.
     */
    public Statistic(String name, int gamesPlayed, int gamesWon, int koDone, int koReceived) {
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.koDone = koDone;
        this.koReceived = koReceived;
    }

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getKoDone() {
        return koDone;
    }

    public int getKoReceived() {
        return koReceived;
    }
    
}

