package Persistence;
import Business.Item;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ItemDAO extends BaseDAO<Item> {
    public boolean checkFile() {
        return false;
    }

    public Item getItemById(int id) {
        return null;
    }

    public List<Item> getAllItems() {
        return null;
    }

    public void save(Item data) {
    }

    @Override
    public void writeFile(String json) {

    }

    public Item getById(int id) {
        return null;
    }

    public List<Item> getAll() {
        return null;
    }
}
