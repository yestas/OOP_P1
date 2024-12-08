package Business;

/**
 * Entity class for the items.
 */
public class Item {
    private long id;
    private String name;
    private int power;
    private int durability;
    private String className;
    private Type itemType;

    /**
     * Constructor for the Item class.
     * @param id The id of the item.
     * @param name The name of the item.
     * @param power The power of the item.
     * @param durability The durability of the item.
     * @param itemType The type of the item.
     */
    public Item(long id, String name, int power, int durability, Type itemType) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.durability = durability;
        this.itemType = itemType;
    }

    /**
     * resolveItemType method to resolve the type of the item based on class name
     */
    public void resolveItemType() {
        if (className != null) {
            if (className.equalsIgnoreCase("Weapon")) {
                itemType = Type.Weapon;
            } else if (className.equalsIgnoreCase("Armor")) {
                itemType = Type.Armor;
            } else {
                itemType = null;
            }
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Type getItemType() {
        return itemType;
    }

    public void setItemType(Type itemType) {
        this.itemType = itemType;
    }
}
