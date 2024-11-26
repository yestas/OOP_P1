package Persistence;
import org.json.JSONObject;
import java.util.List;

public interface DAO<T> {
    JSONObject readFile();
    void writeFile(JSONObject data);
    void save(T data);
    T getById(int id);
    int getNextId();
    List<T> getAll();
}
