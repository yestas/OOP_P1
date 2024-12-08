package Business;

/**
 * Entity class for the character members.
 */
public class CharacterMember extends Character {
    private float accumulatedDamage;
    private float knockout;
    private float damageReduction;
    private boolean isEliminated;

    /**
     * Constructor for the CharacterMember class, by only setting the id, name and weight.
     * @param id The id of the character.
     * @param name The name of the character.
     * @param weight The weight of the character.
     */
    public CharacterMember(int id, String name, double weight) {
        super(id, name, weight);

        this.accumulatedDamage = 0;
        this.knockout = 0;
        this.damageReduction = 0;
        this.isEliminated = false;
    }

    /**
     * Constructor for the CharacterMember class by only inputting a character.
     * @param character The character to be converted to a CharacterMember.
     */
    public CharacterMember(Character character) {
        super(character.getId(), character.getName(), character.getWeight());

        this.accumulatedDamage = 0;
        this.knockout = 0;
        this.damageReduction = 0;
        this.isEliminated = false;
    }

    public float getAccumulatedDamage() {
        return accumulatedDamage;
    }

    public void setAccumulatedDamage(float accumulatedDamage) {
        this.accumulatedDamage = accumulatedDamage;
    }

    public float getKnockout() {
        return knockout;
    }

    public void setKnockout(float knockout) {
        this.knockout = knockout;
    }

    public float getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(float damageReduction) {
        this.damageReduction = damageReduction;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }
}