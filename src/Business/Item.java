package Business;

public class Item {
    private int id;
    private String name;
    private int power;
    private int durability;
    private Type itemType;

    public Item(int id, String name, int power, int durability, Type itemType) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.durability = durability;
        this.itemType = itemType;
    }

    public String toString() {
        return name;
    }
}
