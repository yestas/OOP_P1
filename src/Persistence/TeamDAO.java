package Persistence;
import Business.Team;

import Business.TeamMember;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Business.Strategy;

public class TeamDAO extends BaseDAO<Team> {
    
    public TeamDAO() {
        this.filename = "data/teams.json";
    }

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
        File file = new File(filename);

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
        File file = new File(filename);

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

    public void addTeamToFile(Team team) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String name = team.getName();
        TeamMember[] members = team.getMembers();

        List<Map<String, Object>> membersInfo = new ArrayList<>();
        for (TeamMember member : members) {
            Map<String, Object> memberData = new HashMap<>();
            memberData.put("id", member.getCharacterMember().getId());
            memberData.put("strategy", member.getStrategy());
            membersInfo.add(memberData);
        }

        String jsonString = gson.toJson(
                Map.of(
                        "name", name,
                        "members", membersInfo
                )
        );

        this.writeFile(jsonString);

    }

    @Override
    public void writeFile(String jsonString) {
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            File file = new File(filename);

            StringBuilder fileContent = new StringBuilder();
            if (file.exists()) {
                try (Scanner scan = new Scanner(file)) {
                    while (scan.hasNextLine()) {
                        fileContent.append(scan.nextLine()).append(System.lineSeparator());
                    }
                }
            }

            String content = fileContent.toString();
            int arrayStartIndex = content.indexOf('[');
            int arrayEndIndex = content.lastIndexOf(']');

            if (arrayStartIndex != -1 && arrayEndIndex != -1) {
                String existingArray = content.substring(arrayStartIndex, arrayEndIndex + 1);
                String updatedArray = existingArray.substring(0, existingArray.length() - 1) + "," + jsonString + "\n]";
                content = content.substring(0, arrayStartIndex) + updatedArray;
            } else {
                content = "[" + jsonString + "]";
            }

            try (FileWriter writer = new FileWriter(filename, false)) {
                writer.write(content);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }
    public boolean teamsExists() {
        return false;
    }
}
