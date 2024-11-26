import Business.*;
import Presentation.*;
import Application.*;

public class Main {

    private Controller controller;
    private UI ui;
    private CharacterManager characterManager;
    private CombatManager combatManager;
    private StatisticsManager statisticsManager;
    private ItemManager itemManager;

    public static void main(String[] args) {
        controller = new Controller();
        ui = new UI();
        characterManager = new CharacterManager(new CharacterDAO());
        combatManager = new CombatManager();
        statisticsManager = new StatisticsManager();
        itemManager = new ItemManager();
    }
}
