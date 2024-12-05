package Presentation;
import java.util.List;
import java.util.Scanner;
import Business.*;
import Business.Character;
import Business.CharacterMember;
import Persistence.PersonalizedException;

public class UI {

    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void printWelcomeMessage() {
        System.out.println( "  ____                          _     ____    ____            _ \n" +
                            " / ___| _   _ _ __   ___ _ __  | |   / ___|  | __ ) _ __ ___ | |\n" +
                            " \\___ \\| | | | '_ \\ / _ \\ '__| | |   \\___ \\  |  _ \\| '__/ _ \\| |\n" +
                            "  ___) | |_| | |_) |  __/ |    | |___ ___) | | |_) | | | (_) |_|\n" +
                            " |____/ \\__,_| .__/ \\___|_|    |_____|____/  |____/|_|  \\___/(_)\n" +
                            "             |_|                                                ");

        System.out.println("\nWelcome to the Super LS, Bro! Simulator.\n");
    }

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

    public String printListCharacters(List<String> characterNames) {
        int i = 1;

        for (String name : characterNames) {
            System.out.println("\t" + i + ") " + name);
            i++;
        }

        System.out.print("Choose an option: ");

        return scanner.nextLine();
    }

    public void printCharacterInfo(Character character) {
        System.out.println();
        System.out.println("\tID: " + character.getId());
        System.out.println("\tNAME: " + character.getName());
        System.out.println("\tWEIGHT: " + character.getWeight());
        System.out.println("TEAMS: ");
        System.out.println("TODO: IMPLEMENT TEAMS");
    }

    public void printTeamMenu() {
    }

    public void printItemMenu() {
    }

    public void printStatisticMenu() {
    }

    public void printCombatMenu() {
    }

    public void printCombatInfo(Combat combat) {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int askForInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public String askForString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void listCharacters(List<CharacterMember> characterMembers) {
    }

    public void listTeams(List<Team> teams) {
    }

    public void listItems(List<Item> items) {
    }

    public void listStatistics(List<Statistic> statistics) {
    }
}
