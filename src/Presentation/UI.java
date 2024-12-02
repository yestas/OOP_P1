package Presentation;
import java.util.List;
import java.util.Scanner;
import Business.*;

public class UI {

    private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

    }

    public void printMenu() {
    }

    public void printCharacterMenu() {
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

    public void listCharacters(List<Character> characters) {
    }

    public void listTeams(List<Team> teams) {
    }

    public void listItems(List<Item> items) {
    }

    public void listStatistics(List<Statistic> statistics) {
    }
}
