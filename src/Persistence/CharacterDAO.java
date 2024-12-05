package Persistence;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import Business.Character;

public class CharacterDAO extends BaseDAO<Character> {
    public void checkFile() throws PersonalizedException {
        File file = new File("src/data/characters.json");

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
            gson.fromJson(cleanedContent, new TypeToken<List<Character>>(){}.getType());

        } catch (FileNotFoundException e) {
            throw new PersonalizedException("ERROR: 'characters.json' file not found!");
        } catch (JsonSyntaxException e) {
            throw new PersonalizedException("ERROR: 'characters.json' doesn't have the correct format!");
        }
    }

    public void save(Character data) {
    }

    public Character getById(long id, List<Character> characters) throws PersonalizedException {

        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }

        throw new PersonalizedException("ERROR: Character not found!");
    }

    public List<Character> getAll() throws FileNotFoundException {
        File file = new File("src/data/characters.json");

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
        return gson.fromJson(cleanedContent, new TypeToken<List<Character>>(){}.getType());

    }
}
