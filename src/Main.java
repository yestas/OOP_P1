import Business.*;
import Presentation.*;
import Application.*;
import Persistence.*;

public class Main {

    private static Controller controller;
    private static UI ui;
    private static UiManager uiManager;
    private static CharacterManager characterManager;
    private static CombatManager combatManager;
    private static StatisticManager statisticsManager;
    private static TeamManager teamManager;
    private static ItemManager itemManager;


    public static void main(String[] args) {
        ui = new UI();
        uiManager = new UiManager();
        characterManager = new CharacterManager(new CharacterDAO());
        combatManager = new CombatManager(itemManager, teamManager, statisticsManager);
        statisticsManager = new StatisticManager(new StatisticDAO());
        teamManager = new TeamManager(new TeamDAO());
        itemManager = new ItemManager(new ItemDAO());
        controller = new Controller(ui, uiManager, characterManager, teamManager, itemManager, statisticsManager, combatManager);

        controller.run();
    }
}
