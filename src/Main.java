import Business.*;
import Presentation.*;
import Application.*;
import Persistence.*;

public class Main {

    private static Controller controller;
    private static UI ui;
    private static CharacterManager characterManager;
    private static CombatManager combatManager;
    private static StatisticManager statisticsManager;
    private static TeamManager teamManager;
    private static ItemManager itemManager;
    private static StatisticDAO statisticDAO;
    private static ItemDAO itemDAO;

    public static void main(String[] args) {
        ui = new UI();
        characterManager = new CharacterManager(new CharacterDAO());
        combatManager = new CombatManager(itemManager, teamManager, statisticsManager);
        statisticsManager = new StatisticManager(statisticDAO);
        itemManager = new ItemManager(itemDAO);
        controller = new Controller(ui, characterManager, teamManager, itemManager, statisticsManager, combatManager);

        controller.run();
    }
}
