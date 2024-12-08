package Business;

import Persistence.ItemDAO;
import Persistence.PersonalizedException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * ItemManager class
 */
public class ItemManager {
    private ItemDAO itemDAO;

    /**
     * Constructor
     * @param dao: Item dao
     */
    public ItemManager(ItemDAO dao) {
        this.itemDAO = dao;
    }

    /**
     * Checks if file exists
     * @throws PersonalizedException
     */
    public void checkFileExists() throws PersonalizedException {
        boolean fileIsOkay = itemDAO.checkFile();
        if (!fileIsOkay) {
            throw new PersonalizedException("ERROR: 'items.json' is not present or incorrectly formatted!");
        }
    }

    /**
     * Get all items using itemDAO
     * @return List<Item>
     * @throws FileNotFoundException
     */
    public List<Item> getAllItems() throws FileNotFoundException {
        return itemDAO.getAllItems();
    }

    /**
     * Get all item names using itemDAO
     * @return List<String>
     * @throws FileNotFoundException
     */
    public List<String> getAllItemNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();
        List<Item> items = itemDAO.getAllItems();
        for (Item item : items) {
            names.add(item.getName());
        }
        return names;
    }

    /**
     * Get all item lengths using itemDAO
     * @return long
     * @throws FileNotFoundException
     */
    public long getAllItemsLength() throws FileNotFoundException {
        List<Item> items = itemDAO.getAllItems();
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    /**
     * Get item by list id
     * @param listId: List id
     * @return Item
     * @throws FileNotFoundException
     */
    public Item getItemByListId(int listId) throws FileNotFoundException {
        List<Item> itemList = itemDAO.getAllItems();

        return itemList.get(listId - 1);
    }

    /**
     * Get random weapon
     * @return Item
     * @throws FileNotFoundException
     */
    public Item getRandomWeapon() throws FileNotFoundException {
        List<Item> items = itemDAO.getAllItems();
        List<Item> weapons = new ArrayList<>();
        for (Item item : items) {
            if (item.getItemType() == Type.Weapon) {
                weapons.add(item);
            }
        }

        if (weapons.isEmpty()) return null;
        int randomIndex = (int) (Math.random() * weapons.size());
        return weapons.get(randomIndex);
    }

    /**
     * Get random armour
     * @return Item
     * @throws FileNotFoundException
     */
    public Item getRandomArmour() throws FileNotFoundException {
        List<Item> items = itemDAO.getAllItems();
        List<Item> armours = new ArrayList<>();
        for (Item item : items) {
            if (item.getItemType() == Type.Armor) {
                armours.add(item);
            }
        }

        if (armours.isEmpty()) return null;
        int randomIndex = (int) (Math.random() * armours.size());
        return armours.get(randomIndex);
    }
}
