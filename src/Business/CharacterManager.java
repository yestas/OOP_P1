package Business;
import Persistence.CharacterDAO;
import Persistence.PersonalizedException;

public class CharacterManager {
    private CharacterDAO characterDAO;

    public CharacterManager(CharacterDAO dao) {
        this.characterDAO = dao;
    }

    public void checkFileExists() throws PersonalizedException {
        characterDAO.checkFile();
    }

    //public List<Character> getList() {
    //    return characterDAO.getAll();
    //}
}
