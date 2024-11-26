package Business;

public class CombatManager {
    private TeamManager teamManager;
    private ItemManager itemManager;
    private StatisticsManager statisticsManager;

    public CombatManager(ItemManager itemManager, TeamManager teamManager, StatisticsManager statisticsManager) {
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
