package Persistence;
import org.json.JSONObject;
import java.util.List;

public abstract class BaseDAO<T> implements DAO<T> {
    protected String filename;

    public JSONObject readFile() {
        return null;
    }

    public void writeFile(JSONObject data) {
    }

    public int getNextId() {
        return 0;
    }

    public void save(T data) {
    }

    public T getById(int id) {
        return null;
    }

    public List<T> getAll() {
        return null;
    }
}
