package Business;

public class Character {
    private int id;
    private String name;
    private double weight;
    private float accumulatedDamage;
    private float knockout;
    private float damageReduction;
    private boolean isEliminated;

    public Character(int id, String name, double weight, float accumulatedDamage, float knockout, float damageReduction, boolean isEliminated) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.accumulatedDamage = accumulatedDamage;
        this.knockout = knockout;
        this.damageReduction = damageReduction;
        this.isEliminated = isEliminated;
    }

    public String toString() {
        return name;
    }
}
