package Application;

import Business.*;
import Business.Character;
import Presentation.*;
import Persistence.*;

import java.util.List;

public class Controller {
    private UI ui;
    private UiManager uiManager;
    private CharacterManager characterManager;
    private TeamManager teamManager;
    private ItemManager itemManager;
    private StatisticManager statisticManager;
    private CombatManager combatManager;

    public Controller(UI ui, UiManager uiManager, CharacterManager characterManager, TeamManager teamManager, ItemManager itemManager, StatisticManager statisticManager, CombatManager combatManager) {
        this.ui = ui;
        this.uiManager = uiManager;
        this.characterManager = characterManager;
        this.teamManager = teamManager;
        this.itemManager = itemManager;
        this.statisticManager = statisticManager;
        this.combatManager = combatManager;
    }

    public void run() {
        int menuOption;
        boolean filesOk = false;

        ui.printWelcomeMessage();

        if (checkCharactersFile()) {
            do {
                menuOption = displayMainMenu();

                switch (menuOption) {
                    case 1 -> listCharacters();
                    case 2 -> manageTeams();
                    case 3 -> listTeamsMenu();
                    case 4 -> simulateCombat();
                    case 5 -> ui.printMessage("Exiting...");
                }

            } while (menuOption != 5);
        } else {
            ui.printMessage("Shutting down...");
        }
    }

    public boolean checkCharactersFile() {
        try {
            ui.printMessage("Verifying local files...");
            characterManager.checkFileExists();
            ui.printMessage("Files OK!");
            ui.printMessage("Starting program...\n");

            return true;

        } catch (PersonalizedException e) {
            ui.printMessage(e.getMessage());
            return false;
        }
    }

    public int displayMainMenu() {
        int menuOption = 0;
        boolean validInput = false;

        while (!validInput) {
            try {

                String mainMenuInput = ui.printMainMenu();

                menuOption = uiManager.checkUserInput(mainMenuInput, 1, 5);
                validInput = true;

            } catch (PersonalizedException e) {
                ui.printMessage(e.getMessage());
            }
        }
        return menuOption;
    }

    public void listCharacters() {
        System.out.println("TODO: IMPLEMENT PRINT TEAMS FROM SPECIFIC USER");
        String input;
        int menuOption = -1;

        do {
            try {
                input = ui.printListCharacters(characterManager.getAllCharacterNames());
                menuOption = uiManager.checkUserInput(input, 0, characterManager.getAllCharacterLength());

                if (menuOption != 0) {
                    Character specificCharacter = characterManager.getCharacterById(menuOption);
                    ui.printCharacterInfo(specificCharacter);
                    // TODO MAKE THE PRINT CHARACTER INFO ALSO PRINT THE TEAMS THE CHARACTER MUST BE IN
                    // TODO: IMPLEMENT IN TEAM MENU THE ABILITY TO ADD A CHARACTER TO A TEAM, AND TO RETURN A LIST OF TEAMS CHAR IS IN

                    ui.printWaitKeyPress();

                }

            } catch (Exception e) {
                ui.printMessage(e.getMessage());
            }
        } while(menuOption != 0);
    }

    public void manageTeams() {
        String input;
        int menuOption = -1;

        do {
            try {
                input = ui.printTeamMenu();
                menuOption = uiManager.checkUserInput(input, 0, 4);

                switch (menuOption) {
                    case 1 -> createTeamMenu();
                    case 2 -> listTeamsMenu();
                    case 3 -> deleteTeamMenu();
                    case 4 -> ui.printMessage("Exiting team management menu..");
                }
            } catch (Exception e) {
                ui.printMessage(e.getMessage()); ;
            }
        } while (menuOption != 4);

        System.out.println("TODO: Implement manageTeams");
    }

    public void createTeamMenu() {
        String teamName = ui.askForString("\nPlease enter the team's name: ");

        try {
            if (!teamManager.checkNameUnique (teamName)) {
                ui.printMessage("We are sorry '" + teamName + "' is taken.");
                return;
            }

            int characterNum = 1;
            TeamMember[] teamCharacters = new TeamMember[4];

            while (characterNum != 5) {
                try {
                    CharacterMember characterMember = null;
                    while (characterMember == null) {
                        try {
                            String idNameInput = ui.askForString("Please enter the id or name of character #" + characterNum + ": ");
                            characterMember = new CharacterMember(characterManager.getCharacterByIdName(idNameInput)); // Create CharacterMember from found Character
                        } catch (Exception e) {
                            ui.printMessage(e.getMessage());
                        }
                    }

                    Strategy strategy = null;
                    while (strategy == null) {
                        try {
                            int strategyInput = ui.askForStrategy("Game strategy for character #" + characterNum + "?");
                            strategy = characterManager.checkStrategy(strategyInput);
                        } catch (Exception e) {
                            ui.printMessage(e.getMessage());
                        }
                    }

                    // System.out.println("Strategy: " + strategy);
                    System.out.println();
                    teamCharacters[characterNum - 1] = new TeamMember(characterMember, strategy); // Add the character to the team
                    characterNum++;

                } catch (Exception e) {
                    ui.printMessage(e.getMessage());
                }
            }

            try {
                //System.out.println("Trying to create team");
                teamManager.createTeam(teamName, teamCharacters);

            } catch (Exception e) {
                ui.printMessage(e.getMessage());
            }



        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }

        System.out.println("TODO: Implement createTeamMenu");
    }

    public void listTeamsMenu() {
        try {
            List<Team> teams = teamManager.getAllTeams();
            if (teams.isEmpty()) {
                ui.printMessage("No teams found.");
                return;
            } else {
                ui.printTeams(teams);
                int teamOption = uiManager.checkUserInput(ui.askForString("Choose an option: "), 0, teams.size());

                if (teamOption == 0) {
                    return;
                }

                ui.printTeamInfo(teams.get(teamOption - 1));

            }


        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }
        System.out.println("TODO: Implement listItems");
    }

    public void deleteTeamMenu() {
        System.out.println("TODO: Implement listItems");
    }

    public void simulateCombat() {
        System.out.println("TODO: Implement simulateCombat");
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


