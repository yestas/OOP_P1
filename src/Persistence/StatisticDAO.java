package Persistence;

import Business.Statistic;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class StatisticDAO extends BaseDAO<Statistic> {

    public StatisticDAO() {
        this.filename = "data/stats.json";
    }

    public boolean createFile() {
        return false;
    }

    public void addStatistic(Statistic data) {
    }

    public void save(Statistic data) {
    }

    public void checkFile() throws PersonalizedException {
        File file = new File(filename);

        try {
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
            gson.fromJson(cleanedContent, new TypeToken<List<Statistic>>(){}.getType());

        } catch (FileNotFoundException e) {
            throw new PersonalizedException("ERROR: 'stats.json' file not found!");
        } catch (JsonSyntaxException e) {
            throw new PersonalizedException("ERROR: 'stats.json' doesn't have the correct format!");
        }
    }


    public Statistic getById(int id) {
        return null;
    }

    public Statistic getByTeamName(String name) throws PersonalizedException {
        List<Statistic> allStats;
        try {
            allStats = getAll();
        } catch (FileNotFoundException e) {
            throw new PersonalizedException("ERROR: 'stats.json' file not found!");
        }

        for (Statistic stat : allStats) {
            if (stat.getName().equalsIgnoreCase(name)) {
                return stat;
            }
        }

        throw new PersonalizedException("ERROR: Statistic for team '" + name + "' not found!");
    }

    public List<Statistic> getAll() {
        return null;
    }

    public List<Statistic> getAll() throws FileNotFoundException {
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
        return gson.fromJson(cleanedContent, new TypeToken<List<Statistic>>(){}.getType());
    }
}
