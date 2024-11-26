package Business;
import java.util.List;

public class CharacterManager {
    private CharacterDAO characterDAO;

    public CharacterManager(CharacterDAO dao) {
        this.characterDAO = dao;
    }

    public List<Character> getList() {
        return characterDAO.getCharacters();
    }
}
