package Persistence;
import com.google.gson.Gson;
import java.util.List;

public interface DAO<T> {
    Gson readFile();
    void writeFile(Gson data);
    void save(T data);
    T getById(int id);
    int getNextId();
    List<T> getAll();
}
