package Persistence;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.util.List;

public interface DAO<T> {
    Gson readFile() throws FileNotFoundException;
    void writeFile(Gson data) throws FileNotFoundException;
    void save(T data);
    T getById(int id);
    int getNextId();
    List<T> getAll();
}
