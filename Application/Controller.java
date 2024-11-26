package Application;

public class Controller {
    private UI ui;
    private TeamManager teamManager;
    private ItemManager itemManager;
    private StatisticManager statisticManager;
    private CombatManager combatManager;

    public Controller(UI ui, TeamManager teamManager, ItemManager itemManager, StatisticManager statisticManager, CombatManager combatManager) {
        this.ui = ui;
        this.teamManager = teamManager;
        this.itemManager = itemManager;
        this.statisticManager = statisticManager;
        this.combatManager = combatManager;
    }

    public void run(){

    }

    public void createTeam(String name, int[] members) {

    }

    public void deleteTeam(int id) {

    }

    public void runOption (int option){

    }

    public void fetchInfo(int option){

    }

}


