package Persistence;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.lang.reflect.Type;

import java.util.Scanner;

/**
 * BaseDAO class
 * @param <T>: Generic Type
 */
public abstract class BaseDAO<T> implements DAO<T> {
    protected String filename;

    /**
     * Read file
     * @return Gson: Gson object
     */
    public Gson readFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);

        StringBuilder fileContent = new StringBuilder();

        while (scan.hasNextLine()) {
            fileContent.append(scan.nextLine());
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<T>>() {}.getType();
        return gson.fromJson(fileContent.toString(), listType);
    }

    /**
     * Write file
     * @param jsonString: Json string
     * @throws FileNotFoundException
     */
    public void writeFile(String jsonString) throws FileNotFoundException {
        File file = new File(filename);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(jsonString + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    /**
     * Get next id
     * @return int
     */
    public int getNextId() {
        return 0;
    }

    /**
     * Save data
     * @param data: Data
     */
    public void save(T data) {
    }

    /**
     * Get by id
     * @param id: Id
     * @return T
     */
    public T getById(long id) {
        return null;
    }

    /**
     * Get all
     * @return List<T>
     * @throws FileNotFoundException
     */
    public List<T> getAll() throws FileNotFoundException {
        return null;
    }

}
