package Persistence;
import Business.Team;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TeamDAO extends BaseDAO<Team> {
    public boolean createFile() {
        return false;
    }

    public void addTeam(Team data) {
    }

    public List<Team> getTeamsByCharacter(Character data) {
        return null;
    }

    public void save(Team data) {
    }

    public Team getById(int id) {
        return null;
    }

    public List<Team> getAll() throws FileNotFoundException {
        File file = new File("src/data/teams.json");

        Scanner scan = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();

        while (scan.hasNextLine()) {
            fileContent.append(scan.nextLine()).append("\n");
        }

        String cleanedContent = fileContent.toString().trim();

        if (cleanedContent.endsWith(",")) {
            cleanedContent = cleanedContent.substring(0, cleanedContent.length() - 1);
        }

        Gson gson = new Gson();
        return gson.fromJson(cleanedContent, new TypeToken<List<Team>>(){}.getType());
    }


    public boolean deleteTeam(Team team) {
        return false;
    }

    public boolean checkNameUnique(String name) throws FileNotFoundException {
        File file = new File("src/data/teams.json");

        Scanner scan = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();

        while (scan.hasNextLine()) {
            fileContent.append(scan.nextLine()).append("\n");
        }

        String cleanedContent = fileContent.toString().trim();

        if (cleanedContent.endsWith(",")) {
            cleanedContent = cleanedContent.substring(0, cleanedContent.length() - 1);
        }

        Gson gson = new Gson();
        List<Team> teams = gson.fromJson(cleanedContent, new TypeToken<List<Team>>(){}.getType());

        for (Team team : teams) {
            if (team.getName().equals(name.trim())) {
                return false;
            }
        }

        return true;
    }

    //public Team getTeam() {
    //    return Team;
    //}

    public boolean createTeam(Team team) {


        return false;
    }

    public boolean teamsExists() {
        return false;
    }
}
