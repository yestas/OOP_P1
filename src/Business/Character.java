package Business;

/**
 * Entity class for the characters.
 */
public class Character {
    private long id;
    private String name;
    private double weight;

    /**
     * Constructor for the Character class.
     * @param id The id of the character.
     * @param name The name of the character.
     * @param weight The weight of the character.
     */
    public Character(long id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
