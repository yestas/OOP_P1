package Business;

public class CombatManager {
    private TeamManager teamManager;
    private ItemManager itemManager;
    private StatisticManager statisticsManager;

    public CombatManager(ItemManager itemManager, TeamManager teamManager, StatisticManager statisticsManager) {
        this.itemManager = itemManager;
        this.teamManager = teamManager;
        this.statisticsManager = statisticsManager;
    }

    public void prepareCombat(Team team1, Team team2) {
        System.out.println("TODO: Implement prepareCombat");
        // TODO: Implement prepareCombat

    }

    public void startCombat() {
    }

    public void createStatistic() {
    }
}
