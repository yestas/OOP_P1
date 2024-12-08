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

/**
 * ItemDAO class: Extends BaseDAO
 */
public class ItemDAO extends BaseDAO<Item> {

    /**
     * ItemDAO constructor
     */
    public ItemDAO() {
        this.filename = "data/items.json";
    }

    /**
     * Check if file exists
     * @throws PersonalizedException
     */
    public boolean checkFile() throws PersonalizedException {
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
            throw new PersonalizedException("ERROR: 'items.json' file not found!");
        } catch (JsonSyntaxException e) {
            throw new PersonalizedException("ERROR: 'items.json' doesn't have the correct format!");
        }
    }

    /**
     * Get item by id
     * @param id: The id of the item.
     * @return Item
     * @throws PersonalizedException
     */
    public Item getItemById(int id) throws PersonalizedException {
        try {
            List<Item> items = getAllItems();
            for (Item item : items) {
                if (item.getId() == id) {
                    return item;
                }
            }
        } catch (FileNotFoundException e) {
            throw new PersonalizedException("ERROR: 'items.json' file not found!");
        }
        return null;
    }

    /**
     * Get all items
     * @return List<Item>
     * @throws FileNotFoundException
     */
    public List<Item> getAllItems() throws FileNotFoundException {
        try {
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
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("ERROR: 'items.json' is not present or incorrectly formatted!");
        }

    }

    public void save(Item data) {
    }

}
