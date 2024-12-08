package Business;
import Persistence.CharacterDAO;
import Persistence.PersonalizedException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* CharacterManager class  */
public class CharacterManager {
    private CharacterDAO characterDAO;

    /**
    Constructor
     **/
    public CharacterManager(CharacterDAO dao) {
        this.characterDAO = dao;
    }

    /**
     * Checks if file exists
     * @throws PersonalizedException
     */
    public void checkFileExists() throws PersonalizedException {
        characterDAO.checkFile();
    }

    /**
     * Get all characters using characterDAO
     * @return List<Character>
     * @throws FileNotFoundException
     */
    public List<Character> getAllCharacters() throws FileNotFoundException {
        return characterDAO.getAll();
    }

    /**
     * Get all character names using characterDAO
     * @return List<String>
     * @throws FileNotFoundException
     */
    public List<String> getAllCharacterNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();

        List<Character> characters = getAllCharacters();
        for (Character character : characters) {
            names.add(character.getName());
        }

        return names;
    }

    /**
     * Get all character lengths using characterDAO
     * @return int
     * @throws FileNotFoundException
     */
    public int getAllCharacterLength() throws FileNotFoundException {
        List<Character> characters = characterDAO.getAll();
        return characters.size();
    }

    /**
     * Check if input is a long
     * @param str: Input string
     * @return boolean
     */
    public boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Get character by ID or name
     * @param idName: ID or name of the character
     * @return Character
     * @throws FileNotFoundException
     * @throws PersonalizedException
     */
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

    /**
     * Get character by list ID
     * @param id: List ID of the character
     * @return Character
     * @throws PersonalizedException
     */
    public Character getCharacterByListId(int id) throws PersonalizedException {
        try {
            return characterDAO.getAll().get(id - 1);
        } catch (Exception e) {
            throw new PersonalizedException("Character with ID '" + id + "' not found.");
        }
    }


    /**
     * Get character by ID
     * @param characterId: ID of the character
     * @return Character
     * @throws FileNotFoundException
     * @throws PersonalizedException
     */
    public Character getCharacterById(long characterId) throws FileNotFoundException, PersonalizedException {
        List<Character> characterList = characterDAO.getAll();

        return characterDAO.getById(characterId, characterList);
    }

    /**
     * Get character by name
     * @param name: Name of the character
     * @return Character
     * @throws FileNotFoundException
     * @throws PersonalizedException
     */
    public Character getCharacterByName(String name) throws FileNotFoundException, PersonalizedException {
        List<Character> characterList = characterDAO.getAll();
        return characterDAO.getByName(name, characterList);
    }

    /**
     * Check if strategy is valid
     * @param strategyInput: Check strategy input
     */
    public Strategy checkStrategy(int strategyInput) {
        return Strategy.getStrategy(strategyInput);
    }
}
