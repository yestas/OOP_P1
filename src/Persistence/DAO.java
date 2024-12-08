package Persistence;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * DAO interface
 * @param <T>: Generic Type
 */
public interface DAO<T> {
    Gson readFile() throws FileNotFoundException;
    void writeFile(String json) throws FileNotFoundException;
    void save(T data);
    T getById(long id);
    int getNextId();
    List<T> getAll() throws FileNotFoundException;
}
