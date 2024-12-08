package Business;

import Persistence.ItemDAO;
import Persistence.PersonalizedException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class ItemManager {
    private ItemDAO itemDAO;

    public ItemManager(ItemDAO dao) {
        this.itemDAO = dao;
    }

    public void checkFileExists() throws PersonalizedException {
        boolean fileIsOkay = itemDAO.checkFile();
        if (!fileIsOkay) {
            throw new PersonalizedException("ERROR: 'items.json' is not present or incorrectly formatted!");
        }
    }

    public List<Item> getAllItems() throws FileNotFoundException {
        return itemDAO.getAllItems();
    }

    public List<String> getAllItemNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();
        List<Item> items = itemDAO.getAllItems();
        for (Item item : items) {
            names.add(item.getName());
        }
        return names;
    }

    public int getAllItemsLength() throws FileNotFoundException {
        List<Item> items = itemDAO.getAll();
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public Item getSpecificItem(int orderId) throws FileNotFoundException, PersonalizedException {
        List<Item> itemList = itemDAO.getAll();

        if (orderId < 1 || orderId > itemList.size()) {
            throw new PersonalizedException("ERROR: Invalid item order ID provided");
        }

        int selectedItemId = itemList.get(orderId - 1).getId();
        Item foundItem = itemDAO.getById(selectedItemId);

        if (foundItem == null) {
            throw new PersonalizedException("ERROR: Item not found");
        }

        return foundItem;
    }

    public Item getRandomWeapon() throws FileNotFoundException {
        List<Item> items = itemDAO.getAllItems();
        List<Item> weapons = new ArrayList<>();
        for (Item item : items) {
            if (item.getItemType() == Type.WEAPON) {
                weapons.add(item);
            }
        }

        if (weapons.isEmpty()) return null;
        int randomIndex = (int) (Math.random() * weapons.size());
        return weapons.get(randomIndex);
    }

    public Item getRandomArmour() throws FileNotFoundException {
        List<Item> items = itemDAO.getAllItems();
        List<Item> armours = new ArrayList<>();
        for (Item item : items) {
            if (item.getItemType() == Type.ARMOUR) {
                armours.add(item);
            }
        }

        if (armours.isEmpty()) return null;
        int randomIndex = (int) (Math.random() * armours.size());
        return armours.get(randomIndex);
    }

}
