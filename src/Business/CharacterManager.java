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



    public Character getSpecificCharacter(int orderId) throws FileNotFoundException, PersonalizedException {
        List<Character> characterList = characterDAO.getAll();

        long selectedCharacterId = characterList.get(orderId - 1).getId();

        return characterDAO.getById(selectedCharacterId, characterList);
    }
}
