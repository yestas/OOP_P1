package Persistence;
import com.google.gson.Gson;
import java.util.List;

public abstract class BaseDAO<T> implements DAO<T> {
    protected String filename;

    public Gson readFile() {
        return null;
    }

    public void writeFile(Gson data) {
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
