package Business;

/**
 * Class for the combat manager.
 */
public class CombatManager {
    private TeamManager teamManager;
    private ItemManager itemManager;
    private StatisticManager statisticsManager;

    public CombatManager(ItemManager itemManager, TeamManager teamManager, StatisticManager statisticsManager) {
        this.itemManager = itemManager;
        this.teamManager = teamManager;
        this.statisticsManager = statisticsManager;
    }

    /**
     * Prepares the combat between two teams.
     * @param team1 The first team.
     * @param team2 The second team.
     */
    public void prepareCombat(Team team1, Team team2) {
        System.out.println("TODO: Implement prepareCombat");
        // TODO: Implement prepareCombat

    }

    public void startCombat() {
        // TODO: Implement startCombat
    }

    public void createStatistic() {
        // TODO: Implement createStatistic to call when combat ends
    }
}
