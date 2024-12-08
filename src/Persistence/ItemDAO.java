package Persistence;

import Business.Item;
import Business.Type;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ItemDAO extends BaseDAO<Item> {

    public ItemDAO() {
        this.filename = "data/items.json";
    }

    public boolean checkFile() {
        File file = new File(filename);

        try {
            Scanner scan = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();

            while (scan.hasNextLine()) {
                fileContent.append(scan.nextLine()).append("\n");
            }

            String cleanedContent = fileContent.toString().trim();
            if (cleanedContent.endsWith(",")) {
                cleanedContent = cleanedContent.substring(0, cleanedContent.length() - 1);
            }

            Gson gson = new Gson();

            gson.fromJson(cleanedContent, new TypeToken<List<Item>>(){}.getType());
            return true;

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: 'items.json' file not found!");
            return false;
        } catch (JsonSyntaxException e) {
            System.err.println("ERROR: 'items.json' doesn't have the correct format!");
            return false;
        }
    }

    public Item getItemById(int id) {
        try {
            List<Item> items = getAllItems();
            for (Item item : items) {
                if (item.getId() == id) {
                    return item;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: 'items.json' file not found!");
        }
        return null;
    }

    public List<Item> getAllItems() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();

        while (scan.hasNextLine()) {
            fileContent.append(scan.nextLine()).append("\n");
        }

        String cleanedContent = fileContent.toString().trim();
        if (cleanedContent.endsWith(",")) {
            cleanedContent = cleanedContent.substring(0, cleanedContent.length() - 1);
        }

        Gson gson = new Gson();
        List<Item> items = gson.fromJson(cleanedContent, new TypeToken<List<Item>>(){}.getType());
        
        for (Item item : items) {
            item.resolveItemType();
        }

        return items;
    }

    public void save(Item data) {
    }

    public Item getById(int id) {
        return getItemById(id);
    }

    public List<Item> getAll() {
        try {
            return getAllItems();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: 'items.json' file not found!");
            return null;
        }
    }
}
