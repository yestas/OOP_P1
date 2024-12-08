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

    /**
     * The main controller class that manages the flow of the application.
     */
    public void run() {
        int menuOption;
        boolean filesOk = false;

        ui.printWelcomeMessage();

        if (checkFilesExist()) {
            do {
                menuOption = displayMainMenu();

                switch (menuOption) {
                    case 1 -> listCharacters();
                    case 2 -> manageTeams();
                    case 3 -> listItemsMenu();
                    case 4 -> simulateCombat();
                    case 5 -> ui.printMessage("Exiting...");
                }

            } while (menuOption != 5);
        } else {
            ui.printMessage("Shutting down...");
        }
    }

    /**
     * Checks if the necessary files exist.
     * @return boolean
     */
    public boolean checkFilesExist() {
        try {
            ui.printMessage("Verifying local files...");
            characterManager.checkFileExists();
            itemManager.checkFileExists();
            ui.printMessage("Files OK!");
            ui.printMessage("Starting program...\n");

            return true;

        } catch (PersonalizedException e) {
            ui.printMessage(e.getMessage());
            return false;
        }
    }

    /**
     * Displays the main menu and returns the user's choice.
     * @return int
     */
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

    /**
     * Lists all characters in the characters.json file.
     */
    public void listCharacters() {
        System.out.println("TODO: IMPLEMENT PRINT TEAMS FROM SPECIFIC USER");
        int menuOption = -1;

        do {
            try {
                String input = ui.printListCharacters(characterManager.getAllCharacterNames());
                menuOption = uiManager.checkUserInput(input, 0, characterManager.getAllCharacterLength());

                if (menuOption != 0) {
                    Character specificCharacter = characterManager.getCharacterByListId(menuOption);
                    //List<Team> teams = teamManager.getTeamsByCharacter(specificCharacter);
                    //System.out.println("Teams: ");
                    //for (Team team : teams) {
                    //    System.out.println(team.getName());
                    //}
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

    /**
     * Prints and handles the manage teams submenu.
     */
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
                    case 4 -> ui.printMessage("\nExiting team management menu...\n");
                }
            } catch (Exception e) {
                ui.printMessage(e.getMessage()); ;
            }
        } while (menuOption != 4);

        // TODO: LIST TEAMS MEMBERS
        // TODO: DELETE TEAM MENU
    }

    /**
     * Asks for a team name and 4 characters to create a team.
     */
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
                teamManager.createTeam(teamName, teamCharacters);

            } catch (Exception e) {
                ui.printMessage(e.getMessage());
            }



        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }

        System.out.println("TODO: Implement createTeamMenu");
    }

    /**
     * Lists all items in the items.json file and allows to view details.
     */
    public void listItemsMenu() {
        try {
            int itemOption = 0;
            List<Item> itemList = itemManager.getAllItems();
            ui.listItems(itemList);
            itemOption = uiManager.checkUserInput(ui.askForString("Choose an option: "), 0, itemList.size());
            if (itemOption != 0) {
                ui.printItemInfo(itemManager.getItemByListId(itemOption));
            }
        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }
    }

    /**
     * Lists all teams in the teams.json file and allows to view details.
     */
    public void listTeamsMenu() {
        try {
            List<Team> teams = teamManager.getAllTeams();
            if (teams.isEmpty()) {
                ui.printMessage("No teams found.");
            } else {
                ui.printTeams(teams);
                int teamOption = uiManager.checkUserInput(ui.askForString("Choose an option: "), 0, teams.size());

                if (teamOption == 0) {
                    return;
                }

                ui.printTeamInfo(teams.get(teamOption - 1));
                // TODO: Implement team members print
            }
        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }

    }

    /**
     * Deletes a team from the teams.json file.
     */
    public void deleteTeamMenu() {
        // TODO: Implement deleteTeamMenu
        System.out.println("TODO: Implement deleteTeamMenu");
    }

    /**
     * Simulates a combat between two teams.
     */
    public void simulateCombat() {
        ui.printMessage("\nStarting simulation...");
        ui.printMessage("Looking for available teams...\n");
        try {
            int team1Id = 0, team2Id = 0;
            do {
                int teamNum = teamManager.getAllTeams().size();

                ui.printTeamsBattle(teamManager.getAllTeams());
                team1Id = uiManager.checkUserInput(ui.askForString("Choose team #1: "), 1, teamNum);
                team2Id = uiManager.checkUserInput(ui.askForString("Choose team #2: "), 1, teamNum);

                if (team1Id == team2Id) {
                    ui.printMessage("\nTeams must be different! Please  choose again.\n");
                    team1Id = 0;
                    team2Id = 0;
                }

            } while (team1Id == 0 || team2Id == 0);

            Team team_1 = teamManager.getTeamByListId(team1Id);
            Team team_2 = teamManager.getTeamByListId(team2Id);

            ui.printMessage("\nInitializing teams...\n");

            combatManager.prepareCombat(team_1, team_2);
        } catch (Exception e) {
            ui.printMessage(e.getMessage());
        }
    }
}


