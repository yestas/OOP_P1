package Presentation;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import Business.*;
import Business.Character;
import Business.CharacterMember;
import Persistence.PersonalizedException;

/**
 * UI class: Manages all the user interactions, that is printing on screen or receiving user input.
 */
public class UI {

    private Scanner scanner;

    /**
     * UI constructor
     */
    public UI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Print welcome message
     */
    public void printWelcomeMessage() {
        System.out.println( "  ____                          _     ____    ____            _ \n" +
                            " / ___| _   _ _ __   ___ _ __  | |   / ___|  | __ ) _ __ ___ | |\n" +
                            " \\___ \\| | | | '_ \\ / _ \\ '__| | |   \\___ \\  |  _ \\| '__/ _ \\| |\n" +
                            "  ___) | |_| | |_) |  __/ |    | |___ ___) | | |_) | | | (_) |_|\n" +
                            " |____/ \\__,_| .__/ \\___|_|    |_____|____/  |____/|_|  \\___/(_)\n" +
                            "             |_|                                                ");

        System.out.println("\nWelcome to the Super LS, Bro! Simulator.\n");
    }

    /**
     * Print main menu
     * @return String: The user input.
     * @throws PersonalizedException
     */
    public String printMainMenu() throws PersonalizedException {

        System.out.println("\t1) List Characters");
        System.out.println("\t2) Manage Teams");
        System.out.println("\t3) List Items");
        System.out.println("\t4) Simulate Combat");
        System.out.println();
        System.out.println("\t5) Exit");
        System.out.println();
        System.out.print("Choose an option: ");

        return scanner.nextLine();
    }

    public void printMenu() {
    }

    /**
     * Print list of characters
     * @param characterNames: The list of character names.
     * @return String: The user input.
     */
    public String printListCharacters(List<String> characterNames) {
        int i = 1;

        for (String name : characterNames) {
            System.out.println("\t" + i + ") " + name);
            i++;
        }

        System.out.println();
        System.out.println("\t0) Back");
        System.out.println();
        System.out.print("Choose an option: ");

        return scanner.nextLine();
    }

    /**
     * Print character info
     * @param character: The character.
     */
    public void printCharacterInfo(Character character) {
        System.out.println();
        System.out.println("\tID: " + character.getId());
        System.out.println("\tNAME: " + character.getName());
        System.out.println("\tWEIGHT: " + character.getWeight());
        System.out.println("TEAMS: ");
        // TODO: IMPLEMENT TEAMS
    }

    /**
     * Print team menu
     * @return String: The user input.
     */
    public String printTeamMenu() {
        System.out.println();
        System.out.println("Team Management.");
        System.out.println("\t1) Create a Team");
        System.out.println("\t2) List a Team");
        System.out.println("\t3) Delete a Team");
        System.out.println();
        System.out.println("\t4) Exit");
        System.out.println();
        System.out.print("Choose an option: ");

        return scanner.nextLine();
    }

    /**
     * Print Wait Key Press
     * @throws IOException
     */
    public void printWaitKeyPress() throws IOException {

        System.out.println();
        System.out.println("<Press enter to continue...>");
        scanner.nextLine();
        // TODO: Continue on any key press, not only enter

    }

    public void printItemMenu() {
    }

    public void printStatisticMenu() {
    }

    public void printCombatMenu() {
    }

    public void printCombatInfo(Combat combat) {
    }

    /**
     * Print message
     * @param message: The message.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Ask for int
     * @param message: The message.
     * @return int: The user input.
     */
    public int askForInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    /**
     * Ask for strategy
     * @param message: The message.
     * @return int: The user input.
     */
    public int askForStrategy(String message) {
        System.out.println(message);
        int i = 1;
        for (Strategy strategy : Strategy.values()) {
            System.out.println("\t" + i + ") " + strategy);
            i++;
        }

        System.out.print("\n\tChoose an option: ");

        return Integer.parseInt(scanner.nextLine()); // Grab as string and then parse to avoid scanning enter
    }

    /**
     * Ask for string
     * @param message: The message.
     * @return String: The user input.
     */
    public String askForString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Prints teams to choose from
     * @param teams: The list of teams.
     */
    public void printTeams(List<Team> teams) {
        int i = 1;
        System.out.println();
        for (Team team : teams) {
            System.out.println("\t" + i + ") " + team.getName());
            i++;
        }
        System.out.println("\n\t0) Back\n");
    }

    /**
     * Prints teams to choose from for battle
     * @param teams: The list of teams.
     */
    public void printTeamsBattle(List<Team> teams) {
        int i = 1;
        System.out.println();
        for (Team team : teams) {
            System.out.println("\t" + i + ") " + team.getName());
            i++;
        }
        System.out.println();
    }

    /**
     * Prints team info
     * @param team: The team.
     */
    public void printTeamInfo(Team team) {
        System.out.println("\n\tTeam name: " + team.getName());
        System.out.println();
        for (TeamMember member : team.getMembers()) {
            System.out.println(member.getCharacterMember());
            //System.out.println("\t" + member.getCharacterMember().getName() + "\t\t\t(" + member.getStrategy().toString().toUpperCase() + ")");
        }
    }

    public void listCharacters(List<CharacterMember> characterMembers) {
    }

    public void listTeams(List<Team> teams) {
    }

    /**
     * Prints items to choose from
     * @param items: The list of items.
     */
    public void listItems(List<Item> items) {
        int i = 1;
        System.out.println();
        for (Item item : items) {
            System.out.println("\t" + i + ") " + item.getName());
            i++;
        }
        System.out.println("\n\t0) " + "Back");

    }

    /**
     * Prints item info
     * @param item: The item.
     * @throws IOException
     */
    public void printItemInfo(Item item) throws IOException {
        System.out.println("\n\tID: " + item.getId());
        System.out.println("\tNAME: " + item.getName());
        System.out.println("\tCLASS: " + item.getClassName());
        System.out.println("\tPOWER: " + item.getPower());
        System.out.println("\tDURABILITY: " + item.getDurability());
        System.out.println();
        printWaitKeyPress();
    }

    public void listStatistics(List<Statistic> statistics) {
    }
}
