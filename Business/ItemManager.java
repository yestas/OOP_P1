package Business;

public class ItemManager {
    private ItemDAO itemDAO;

    public ItemManager(ItemDAO dao) {
        this.itemDAO = dao;
    }

    public Item getRandomWeapon() {
        return null;
    }

    public Item getRandomArmour() {
        return null;
    }
}
