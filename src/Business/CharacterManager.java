package Business;
import Persistence.CharacterDAO;
import Persistence.PersonalizedException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private CharacterDAO characterDAO;

    public CharacterManager(CharacterDAO dao) {
        this.characterDAO = dao;
    }

    public void checkFileExists() throws PersonalizedException {
        characterDAO.checkFile();
    }

    public List<Character> getAllCharacters() throws FileNotFoundException {
        return characterDAO.getAll();
    }

    public List<String> getAllCharacterNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();

        List<Character> characters = getAllCharacters();
        for (Character character : characters) {
            names.add(character.getName());
        }

        return names;
    }

    public int getAllCharacterLength() throws FileNotFoundException {
        List<Character> characters = characterDAO.getAll();
        return characters.size();
    }

    public boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* Check if input matches with any ID, if it doesn't match it will check if it matches with any name */
    public Character getCharacterByIdName(String idName) throws FileNotFoundException, PersonalizedException {
        try {

            if (isLong(idName)) {
                long characterId = Long.parseLong(idName);

                return getCharacterById(characterId);
            }

            return getCharacterByName(idName);

        } catch (Exception e) {
            throw new PersonalizedException("Character with ID or name '" + idName + "' not found.");
        }
    }

    public Character getCharacterByListId(int id) throws PersonalizedException {
        try {
            return characterDAO.getAll().get(id - 1);
        } catch (Exception e) {
            throw new PersonalizedException("Character with ID '" + id + "' not found.");
        }
    }


    public Character getCharacterById(long characterId) throws FileNotFoundException, PersonalizedException {
        List<Character> characterList = characterDAO.getAll();

        return characterDAO.getById(characterId, characterList);
    }

    public Character getCharacterByName(String name) throws FileNotFoundException, PersonalizedException {
        List<Character> characterList = characterDAO.getAll();
        return characterDAO.getByName(name, characterList);
    }

    public Strategy checkStrategy(int strategyInput) {
        return Strategy.getStrategy(strategyInput);
    }
}
