package Business;

import com.google.gson.annotations.SerializedName;

public class Item {
    private int id;
    private String name;
    private int power;
    private int durability;
    private String className; 
    private Type itemType;

    public Item(int id, String name, int power, int durability, Type itemType) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.durability = durability;
        this.itemType = itemType;
    }

    public Item() {} // for gson if needed 

    public void resolveItemType() {
        if (className != null) {
            if (className.equalsIgnoreCase("Weapon")) {
                itemType = Type.WEAPON;
            } else if (className.equalsIgnoreCase("Armor")) {
                itemType = Type.ARMOR;
            } else {
                // Default or unknown type handling
                itemType = null;
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getDurability() {
        return durability;
    }

    public Type getItemType() {
        return itemType;
    }

    public String toString() {
        return name;
    }

}
