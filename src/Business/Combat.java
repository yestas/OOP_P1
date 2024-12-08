package Business;

/**
 * Entity class for the combat.
 */
public class Combat {
    private Team team1;
    private Team team2;

    /**
     * Constructor for the Combat class.
     * @param team1 The first team.
     * @param team2 The second team.
     */
    public Combat(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
}
