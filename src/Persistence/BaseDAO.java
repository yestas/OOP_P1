package Persistence;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.lang.reflect.Type;

import java.util.Scanner;

public abstract class BaseDAO<T> implements DAO<T> {
    protected String filename;

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

    public void writeFile(Gson data) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
    }

    public int getNextId() {
        return 0;
    }

    public void save(T data) {
    }

    public T getById(long id) {
        return null;
    }

    public List<T> getAll() throws FileNotFoundException {
        return null;
    }
}
