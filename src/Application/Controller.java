package Application;

import Business.*;
import Presentation.*;
import Persistence.*;

public class Controller {
    private UI ui;
    private CharacterManager characterManager;
    private TeamManager teamManager;
    private ItemManager itemManager;
    private StatisticManager statisticManager;
    private CombatManager combatManager;

    public Controller(UI ui, CharacterManager characterManager, TeamManager teamManager, ItemManager itemManager, StatisticManager statisticManager, CombatManager combatManager) {
        this.ui = ui;
        this.characterManager = characterManager;
        this.teamManager = teamManager;
        this.itemManager = itemManager;
        this.statisticManager = statisticManager;
        this.combatManager = combatManager;
    }

    public void run(){
        try {
            ui.printMessage("Checking if file exists...");
            characterManager.checkFileExists();
            ui.printMessage("File validation succesfull!");
        } catch (PersonalizedException e) {
            ui.printMessage(e.getMessage());
        }
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


