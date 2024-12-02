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

    public void prepareCombat() {
    }

    public void startCombat() {
    }

    public void createStatistic() {
    }
}
